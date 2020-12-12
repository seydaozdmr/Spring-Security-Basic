package com.security.demo.Service;

import com.security.demo.Model.User;
import com.security.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    //UserDetails nesnesi AuthenticationManager'e authentication nesnesine kullanıcı bilgileri olarak gönderiliyor.
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findByUserName(s);

        user.orElseThrow(()->new UsernameNotFoundException("Kullanıcı bulunamadı."));
        System.out.println("kullanıcı adı:"+s);
        User newUser=user.get();
        //userRepository ile bulduğumuz kullanıcıyı MyUserDetails sınıfı ile map ediyoruz.
        //yani bulduğumuz kullanıcının bilgilerini kullanarak ya da başka bir değişle eşleştirerek UserDetails yaratıyoruz.
        //eşleştirdiğimiz yeni UserDetails nesnesini SecurityConfig'e configure içindeki authentication nesnesine gönderiyoruz.
        //MyUserDetails sınıfında newUser nesnesini map ediyorum. Bana UserDetails nesnesi geri döndürüyor bende
        //bu nesneyi SecurityConfig'e geri döndürüyorum.
        return new  MyUserDetails(newUser);
        //return new org.springframework.security.core.userdetails.User(newUser.getUserName(),newUser.getPassword(),getAuthorities(newUser));
    }
    /*
    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }

     */
}

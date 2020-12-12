package com.security.demo.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //Eğer JDBC Authentication kullanmak istiyorsak dataSource implemente etmemiz gerekiyor.
    //Bunun configure de auth nesnesine veriyoruz ve orada özelliştirmemiz gerekiyor.
    //Yani sorgularını kendimiz yazmalıyız.
    @Autowired
    DataSource dataSource;

    //Kullanıcı bilgilerini mysql'de bulunan tablodan çekmek için UserDetailsService ile Jpa aracılığı ile bilgileri çekiyoruz.
    @Autowired
    UserDetailsService userDetailsService;

    //Bu configure metodunu uygulamaya giriş yaparken kimlik bilgilerini doğrulamak için kullanıyoruz. (Authentication)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //super.configure(auth); -> bu metot WebSecurityConfigurerAdapter da tanımlanmış configure metodunun özelliklerini kullanmamıza yarıyor.
        //Bunun yerine kendi Authentication özelliklerimizi ayarlıyoruz.
        /*
        auth.inMemoryAuthentication()
                .withUser("blah")
                .password("blah")
                .roles("USER")
                .and()
                .withUser("seyda")
                .password("seyda")
                .roles("ADMIN");
        */
        /*H2 database aracılığı ile bilgileri çekmek için
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                "select username,password,true" +
                "from Database where username=?")
                .authoritiesByUsernameQuery(
                "select username,'ROLE_USER' from Database where username=?")
                .passwordEncoder(new BCryptPasswordEncoder());

         */
        //MyUserDetailsServisinde üretilen kullanıcı bilgilerini authentication nesnesinde giriş yaparken kullanıyoruz.
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
    }

    //Burada encode edilmemiş şifre kullanmak için NoOpPasswordEncoder nesnesini kullanıyoruz.
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //Authorizing
    //Uygulama API'larımızın hangilerine hangi kullanıcı rollerinin girip giremeyeceğini belirlemek için bu configure metodunu Override ediyoruz.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                /* Direct login sayfasına gitmek yerine bu pathlere giriş yapmadan (authentication) giriş yapabilmemiz için
                izin veriyorum.
                .antMatchers("/","/haberler").permitAll()
                 */
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/","static/css","static/js").permitAll()
                .and().formLogin(); //Uygulamamız direct formLogin'e gidiyor açılırken.
                //Bunu şu şekilde değiştirebiliriz.
                /*
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error")
                .permitAll()
                 */

    }
}

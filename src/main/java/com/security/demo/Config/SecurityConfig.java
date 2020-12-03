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
                .dataSource(dataSource);

         */

        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //Authorizing
    //Uygulama API'larımızın hangilerine hangi kullanıcı rollerinin girip giremeyeceğini belirlemek için bu configure metodunu Override ediyoruz.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/","static/css","static/js").permitAll()
                .and().formLogin();

    }
}

package g43729.webg5.pae;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Tables définies par nous, utilisateurs ajoutés via SQL.

        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery(
                "select username, password, enabled from user where username=?")
            .authoritiesByUsernameQuery(
                "select username, authority" + " from authority where username=?");


        // Mot de passes cryptés

        PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
        auth.jdbcAuthentication()
            .dataSource(dataSource).withDefaultSchema()
            .passwordEncoder(pwdEncoder)
            .withUser(
                User.withUsername("user")
                    .password(pwdEncoder.encode("passwd"))
                    .authorities("USER")
                )
            ;  

        /*  // Stocké en brut

        auth.inMemoryAuthentication()
                .withUser("prof")
                    .password("{noop}prof")     // noop = non chiffré
                    .authorities("PROF")   // 
            .and()
                .withUser("etudiant")
                    .password("{noop}etudiant")
                    .authorities("USER")
            .and()
                    .withUser("secretariat")
                        .password("{noop}secretariat")
                        .authorities("SECRETARIAT");

        */
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            /* .antMatchers("/courses").authenticated() */ // Nécessite d'être identifié seulement
            .antMatchers("/courses").hasAnyAuthority("PROF", "SECRETARIAT", "USER")
            .antMatchers("/students").hasAnyAuthority("PROF", "SECRETARIAT", "USER")
            .antMatchers("/**").permitAll()    // Toutes les autres sont publiques			
        .and()
           /* .formLogin() */	// Identification via la page de login par défaut
        .formLogin().loginPage("/login")
        .and()
            .exceptionHandling().accessDeniedPage("/")
        .and()
            .logout().logoutSuccessUrl("/")
        ;

        // Accès à console H2
        http.authorizeRequests().antMatchers("/").permitAll().and()
                .authorizeRequests().antMatchers("/console/**").permitAll();
                http.csrf().disable();
                http.headers().frameOptions().disable();
    }
}


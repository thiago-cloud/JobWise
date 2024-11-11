package com.appRH.appRH;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


//Classe responsável pela configuração do spring security para fazer authenticação

@Configuration
@EnableWebSecurity
public class WebConfig {

	// O noop serve para não criptografar a senha
	// roles user permissão de usuario para o usuario thiago e ADMIN para o usuario root.
	
    // Configuração de usuários e papéis em memória
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("thiago")
                               .password("{noop}thiago")
                               .roles("USER")
                               .build());
        manager.createUser(User.withUsername("root")
                               .password("{noop}root")
                               .roles("ADMIN")
                               .build());
        return manager;
    }

    // Configuração de segurança para definir acesso a URLs e autenticação por formulário
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests(authorize -> authorize
                .requestMatchers("/", "/vagas**", "/home**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .permitAll()
            )//Todo mundo tem acesso a página de login, e página de login e padrão do spring security que é a formLogin
            .logout(logout -> logout
                .permitAll()
            )//Todo mundo tem acesso a página de logout, também é padrão.
            .csrf(csrf -> csrf.disable());//No momento o csrf se encontra desabilitado porém quando o sistema for para produção o interessante e manter habilitado.

        return http.build();
    }
}

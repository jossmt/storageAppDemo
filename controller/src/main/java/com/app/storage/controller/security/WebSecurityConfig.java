/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.app.storage.controller.security;

import com.app.storage.controller.security.handlers.UrlAuthenticationSuccessHandler;
import com.app.storage.service.security.AuthenticationProviderHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.sql.DataSource;


/**
 * Spring Web Security Configuration.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /** {@link AuthenticationProviderHandler}. */
    @Autowired
    private AuthenticationProviderHandler authenticationProviderHandler;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/signup", "/", "/home", "/about")
                .permitAll()
            .antMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(successHandler())
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home")
                .permitAll()
                .and()
                .rememberMe()
                .key("uniqueAndSecret")
                .tokenValiditySeconds(86400)
                .and()
                .sessionManagement()
                .sessionFixation().migrateSession()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .invalidSessionUrl("/invalid_session")
                .maximumSessions(2)
                .expiredUrl("/expired_session");
    }

    /**
     * User login validation configuration.
     *
     * @param auth
     *         {@link AuthenticationManagerBuilder}
     * @throws Exception
     *         {@link Exception}
     */
    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder auth)
            throws
            Exception {
        auth
                .authenticationProvider(authenticationProviderHandler);
    }

    /**
     * Handles login success configuration policy.
     *
     * @return {@link AuthenticationSuccessHandler}
     */
    private final AuthenticationSuccessHandler successHandler() {
        return new UrlAuthenticationSuccessHandler();
    }

    /**
     * Sets security evaluation context.
     *
     * @return {@link SecurityEvaluationContextExtension}
     */
    @Bean
    public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
        return new SecurityEvaluationContextExtension();
    }
}

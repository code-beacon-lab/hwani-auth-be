package com.boiler.auth.global.configure;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 웹 보안
     * */
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    /**
     * http 보안
     * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}

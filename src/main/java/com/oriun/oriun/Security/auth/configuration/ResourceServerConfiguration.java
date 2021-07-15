package com.oriun.oriun.Security.auth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter{

    private static final String[] publicResources = new String[]{ "/userreg/**" };
    private static final String[] userResources = new String[]{ "/usuario/**", "/registro/nuevo-rol/**",
            "/mis-roles", "/mis-cursos" };
    private static final String[] teacherResources = new String[]{ "/profesor/**" };
    private static final String[] studentResources = new String[]{ "/estudiante/**" };

    @Override
    public void configure( HttpSecurity httpSecurity ) throws Exception{
        httpSecurity
                .authorizeRequests( )
                .antMatchers( publicResources ).permitAll( )
                .and( ).cors( ).disable( );
    }

}
package com.imooc.uaa.security.filter;

/**
 * @description:
 * @author: Simon
 * @date: 2021-02-05 23:05
 */


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import java.util.List;

@RequiredArgsConstructor
public class ClientErrorLoggingConfigurer extends AbstractHttpConfigurer<com.imooc.uaa.config.dsl.ClientErrorLoggingConfigurer, HttpSecurity> {

    private final List<HttpStatus> errorCodes;

    @Override
    public void init(HttpSecurity http) throws Exception {
        // initialization code
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        // 配置 Filter，让它的位置在 FilterSecurityInterceptor 之后
        http.addFilterAfter(new ClientErrorLoggingFilter(errorCodes), FilterSecurityInterceptor.class);
    }

}

package com.techtest.vhforum.configuration.filters;

import com.techtest.vhforum.services.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {

    @Autowired
    public UtilService utilService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        response.setHeader(UtilService.ACCESS_CONTROL_ALLOW_ORIGIN, utilService.APP_HOST);
        response.setHeader(UtilService.ACCESS_CONTROL_ALLOW_CREDENTIALS, String.format("%b", UtilService.ALLOW_CREDENTIALS));
        response.setHeader(UtilService.ACCESS_CONTROL_ALLOW_METHODS, UtilService.ALLOW_METHODS);
        response.setHeader(UtilService.ACCESS_CONTROL_MAX_AGE, String.format("%d", UtilService.MAX_AGE));
        response.setHeader(UtilService.ACCESS_CONTROL_ALLOW_HEADERS, UtilService.ALLOW_HEADERS);

        if(request.getMethod().equals(HttpMethod.OPTIONS.name())){
            response.setStatus(HttpStatus.NO_CONTENT.value());

        } else {
            filterChain.doFilter(req, res);
        }
    }


    @Override
    public void destroy() {

    }
}

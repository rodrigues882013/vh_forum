package com.techtest.vhforum.configuration.filters;

import com.techtest.vhforum.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TokenFilter implements Filter{

    @Autowired
    private JwtTokenUtil jwt;

    @Value("${jwt.header}")
    private String tokenHeader;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        String url = request.getRequestURL().toString();
        Pattern p = Pattern.compile("auth(!?\\/login$|\\/register)$");
        Matcher m = p.matcher(url);

        if(!m.find()){
            String token = request.getHeader(this.tokenHeader);

            if (token == null || !jwt.validateToken(token)){
                response.sendError(HttpStatus.UNAUTHORIZED.value(), "Token is not valid");
            }
        }

        filterChain.doFilter(request, response);

    }

    @Override
    public void destroy() {

    }
}

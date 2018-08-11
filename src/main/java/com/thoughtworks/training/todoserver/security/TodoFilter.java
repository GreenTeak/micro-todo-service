package com.thoughtworks.training.todoserver.security;

import com.google.common.net.HttpHeaders;


import com.thoughtworks.training.todoserver.server.TodoServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class TodoFilter extends OncePerRequestFilter {

    @Value("privateKey")
    private String privateKey;

    @Autowired
    private TodoServer todoServer;

//    @Autowired
//    private UserFeign userFeign;

    String[] token;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String tokens = request.getHeader(HttpHeaders.AUTHORIZATION);

        token = tokens.split(":");
        System.out.println("-----------------------todo----------------------");
        if (!StringUtils.isEmpty(token[1])) {
            try {
                   //User user = userFeign.verifyToken(token[1]);
                    if(tokens!=null){
                    SecurityContextHolder.getContext()
                            .setAuthentication(
                                    new UsernamePasswordAuthenticationToken(token[1],
                                            null, Collections.emptyList()));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        filterChain.doFilter(request, response);
    }

    public Integer requestId(){
        return Integer.parseInt(token[0]);
    }
}

package com.idat.idatapirest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTTokenFilter extends OncePerRequestFilter {
    @Autowired
    private  JWTTokenUtil util;
    @Autowired
    private JWTUserDetailService jwtUserDetailService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String tokenheader = request.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        if (jwtToken != null && tokenheader.startsWith("Bearer ")){
            jwtToken= tokenheader.substring(7);
            try {
                username = util.getUsernameFromToken(jwtToken);
            }catch (Exception e){System.out.println("Ocurrio un error");}
        }else{
            logger.warn("JWT no esta inicializando con Bearer");
        }

        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetail = this.jwtUserDetailService.loadUserByUsername(username);
            if(util.validateToken(jwtToken,userDetail)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(jwtToken,null,userDetail.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}

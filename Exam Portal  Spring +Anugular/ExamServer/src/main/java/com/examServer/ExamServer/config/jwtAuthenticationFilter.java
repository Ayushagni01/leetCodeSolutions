package com.examServer.ExamServer.config;

import com.examServer.ExamServer.service.impl.UserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //extracting header and forward request
        final String requestTokenHeader = request.getHeader("Authorization");
        System.out.println(requestTokenHeader);

        String username=null;
        String jwtToken=null;

       if(requestTokenHeader!=null && requestTokenHeader.startsWith("Bearer "))
       {
           //yes
            jwtToken=requestTokenHeader.substring(7);
            try {
                username = this.jwtUtil.extractUsername(jwtToken);
            }
            catch(ExpiredJwtException e)
            {
                System.out.println("jwt token expire");
            }
            catch(Exception e )
            {
                e.printStackTrace();
                System.out.println("Error");
            }

       }else{

           System.out.println("Invalid taken does not start with Bearer");
       }

       //validating token
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if(this.jwtUtil.validateToken(jwtToken,userDetails))
            {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                //token is valid
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
        }
        else{
            System.out.println("Token is not valid");
        }

    filterChain.doFilter(request,response);
    }


}

package com.location.web.flight.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
@Service
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	UserDetailsService uds;
	
	@Autowired
	AuthenticationManager am;
	
	@Override
	public boolean login(String username, String password) {
		UserDetails userDet = uds.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(userDet, password,userDet.getAuthorities());
		am.authenticate(token);
		boolean res = token.isAuthenticated();
		
		if(res)
		{
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		
		return res;
	}

}

package com.dungsecurity.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dungsecurity.entity.RoleEntity;
import com.dungsecurity.entity.UserEntity;
import com.dungsecurity.repository.UserRepository;
import com.dungsecurity.util.MyUserDetail;

@Service
public class MyUserDeatailsService implements UserDetailsService{

	private final Logger _log = org.slf4j.LoggerFactory.getLogger(MyUserDeatailsService.class);
	
	@Autowired
	private UserRepository userReposity;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userReposity.findOneByUserName(username);
		if(userEntity == null) {
			_log.error("User not!");
			throw new UsernameNotFoundException("User not found !");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (RoleEntity role : userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUserDetail myUserDetail = new MyUserDetail(username, userEntity.getPassword(),
				true, true, true, true, authorities);
		BeanUtils.copyProperties(userEntity, myUserDetail);
		return myUserDetail;
	}

}

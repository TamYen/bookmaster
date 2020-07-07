package com.example.secutity;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.orm.mapper.TblAdminMapper;
import com.example.orm.model.TblAdmin;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private TblAdminMapper tblAdminMapper;

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException, CannotConnectDBException {
		
		TblAdmin admin = null;
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		try {
			admin = tblAdminMapper.selectByPrimaryKey(userId);
		} catch (MyBatisSystemException e) {
			throw new CannotConnectDBException("DBエラーが発生しました。");
		}
		
		if(admin  == null || admin.getDeleteFlg() == "1") {
			throw new UsernameNotFoundException("管理者IDまたはパスワードが正しくありません。");
		}
		return new org.springframework.security.core.userdetails.User(admin.getAdminId(), admin.getPassword(), authorities) ;
	}

}

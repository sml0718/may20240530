package com.eden.dao;

import com.eden.entity.User;

public interface UserDao {
	

	
		User findByUserName(String username);
	
		public void save(User user);

		
	

}

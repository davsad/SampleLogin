package com.sample.login.stateless;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.login.dto.UserDTO;
import com.sample.login.jpa.api.IUserDAO;
import com.sample.login.stateless.api.IUserEJB;

/**
 * For demo purposes we are only going to expose add user (register) and validate (login)
 */
@Stateless
public class UserEJB implements IUserEJB {
	
	private static Logger logger = LoggerFactory.getLogger(UserEJB.class);
	
	@Inject
	private IUserDAO userDao;

	@Override
	public boolean addUser(UserDTO user) {
		logger.info("Add user :: {}", user.getUsername());
		try {
		userDao.addUser(user);
		return true;
		} catch (Exception e) {
			logger.error("Add user error, username :: {}, error :: {}",user.getUsername(), e);
			return false;
		}
	}

	@Override
	public boolean validate(String username, String password) {
		return userDao.validateUserByPassword(username, password) ? true : false;
	}
}

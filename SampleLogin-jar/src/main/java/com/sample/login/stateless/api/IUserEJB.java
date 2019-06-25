package com.sample.login.stateless.api;

import com.sample.login.dto.UserDTO;

public interface IUserEJB {

	boolean addUser(UserDTO user);

	boolean validate(String username, String password);

}
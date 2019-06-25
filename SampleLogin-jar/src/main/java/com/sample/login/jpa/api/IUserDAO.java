package com.sample.login.jpa.api;

import java.util.List;

import com.sample.login.dto.UserDTO;

public interface IUserDAO {

	void addUser(UserDTO userDto);

	void deleteUser(String username);

	void updateUser(UserDTO userDto);

	UserDTO getUserDTO(String username);

	List<UserDTO> getUserDTOByAttribute(String attribute, Object value);

	boolean validateUserByPassword(String username, String password);

}
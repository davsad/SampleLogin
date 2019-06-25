package com.sample.login.jpa.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.login.dto.UserDTO;
import com.sample.login.jpa.api.IUserDAO;
import com.sample.login.jpa.base.PersistenceProvider;

@SuppressWarnings("all")
@Stateless
public class UserDAO extends PersistenceProvider implements IUserDAO{

	private final static Class<User> uclazz = User.class;
	private final static Logger logger = LoggerFactory.getLogger(UserDAO.class);

	@Override
	public void addUser(UserDTO userDto) {
		User user = new User(userDto.getName(), userDto.getSurname(), userDto.getDOB(), userDto.getEmail(),
				userDto.getBio(), userDto.getPhone(), userDto.getUsername(), userDto.getPassword());
		logger.info("Adding user for the first time :: {}", user.toString());
		addEntity(user);
	}

	@Override
	public void deleteUser(String username) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		Root<User> root = criteriaQuery.from(User.class);
		deleteEntity(uclazz, (Long) entityManager.createQuery(criteriaQuery.multiselect(root.get(User_.USER_ID))
				.where(criteriaBuilder.equal(root.get(User_.USERNAME), username))).getSingleResult());
	}

	@Override
	public void updateUser(UserDTO userDto) {
		User user = getUserByUsername(userDto.getUsername());
		translateUser(user, userDto);
	}

	@Override
	public UserDTO getUserDTO(String username) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserDTO> criteriaQuery = criteriaBuilder.createQuery(UserDTO.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(criteriaBuilder.construct(UserDTO.class, root.get(User_.name), root.get(User_.surname),
				root.get(User_.DOB), root.get(User_.email), root.get(User_.phone),
				root.get(User_.username), root.get(User_.password)));
		ParameterExpression<String> express = criteriaBuilder.parameter(String.class);
		criteriaQuery.where(criteriaBuilder.equal(root.get(User_.USERNAME), express));
		TypedQuery<UserDTO> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setParameter(express, username);
		return typedQuery.getSingleResult();
	}
	
	
	@Override
	public List<UserDTO> getUserDTOByAttribute(String attribute, Object value) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserDTO> criteriaQuery = criteriaBuilder.createQuery(UserDTO.class);
		Root<User> root = criteriaQuery.from(User.class);
		criteriaQuery.select(criteriaBuilder.construct(UserDTO.class, root.get(User_.name), root.get(User_.surname),
				root.get(User_.DOB), root.get(User_.email), root.get(User_.phone),
				root.get(User_.username), root.get(User_.password)));
		ParameterExpression express = criteriaBuilder.parameter(value.getClass());
		criteriaQuery.where(criteriaBuilder.equal(root.get(attribute), express));
		TypedQuery<UserDTO> typedQuery = entityManager.createQuery(criteriaQuery);
		typedQuery.setParameter(express, value);
		return typedQuery.getResultList();
	}

	private User getUserByUsername(String username) {
		return findByAttribute(uclazz, User_.USERNAME, username).get(0);
	}

	@Override
	public boolean validateUserByPassword(String username, String password) {
		List<User> user = findByAttribute(User.class, User_.USERNAME, username);
		if (user == null || user.size() <= 0) {
			return false;
		}
		user.get(0).setLogged_at(System.currentTimeMillis());
		return true;
	}

	private void translateUser(User user, UserDTO userDto) {
		if (!userDto.getName().equals(user.getName())) {
			user.setName(userDto.getName());
		}
		if (!userDto.getSurname().equals(user.getSurname())) {
			user.setSurname(userDto.getSurname());
		}
		if (!userDto.getDOB().equals(user.getDOB())) {
			user.setDOB(userDto.getDOB());
		}
		if (!userDto.getEmail().equals(user.getEmail())) {
			user.setEmail(userDto.getEmail());
		}
		if (!userDto.getPassword().equals(user.getPassword())) {
			user.setPassword(userDto.getPassword());
		}
		if (!userDto.getPhone().equals(user.getPhone())) {
			user.setPhone(userDto.getPhone());
		}
		user.setUpdated_at(System.currentTimeMillis());
	}
}

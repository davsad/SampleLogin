package com.sample.login.jpa.user;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, Long> created_at;
	public static volatile SingularAttribute<User, String> password;
	public static volatile SingularAttribute<User, Long> updated_at;
	public static volatile SingularAttribute<User, Long> logged_at;
	public static volatile SingularAttribute<User, Long> user_id;
	public static volatile SingularAttribute<User, String> phone;
	public static volatile SingularAttribute<User, String> surname;
	public static volatile SingularAttribute<User, Date> DOB;
	public static volatile SingularAttribute<User, String> name;
	public static volatile SingularAttribute<User, String> email;
	public static volatile SingularAttribute<User, String> username;

	public static final String CREATED_AT = "created_at";
	public static final String PASSWORD = "password";
	public static final String UPDATED_AT = "updated_at";
	public static final String LOGGED_AT = "logged_at";
	public static final String USER_ID = "user_id";
	public static final String PHONE = "phone";
	public static final String SURNAME = "surname";
	public static final String D_OB = "DOB";
	public static final String NAME = "name";
	public static final String EMAIL = "email";
	public static final String USERNAME = "username";

}


package com.sample.login.rest.api;

import static com.sample.login.cookie.CookieUtil.getCookie;
import static com.sample.login.cookie.CookieUtil.isLogged;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sample.login.dto.UserDTO;
import com.sample.login.stateless.api.IUserEJB;


@Path("/user")
public class UserRestApi {

	private final static Logger logger = LoggerFactory.getLogger(UserRestApi.class);

	@Inject
	private IUserEJB userEjb;

	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@POST
	public Response addUser(UserDTO user) {
		logger.info("REST post method called, payload :: {}", user.toString());
		if (userEjb.addUser(user)) {
			return Response.status(Status.OK).cookie(getCookie(user.getUsername(), user.getPassword(), false)).entity("Welcome!").build();
		} else
			return Response.status(Status.BAD_REQUEST).entity("Something went wrong").build();
	}

	@Path("/validate/{username}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response validate(@CookieParam("samplelogin") Cookie cookie, @PathParam("username") String username,
			@PathParam("password") String password) {
		if (!isLogged(cookie, username)) {
			return userEjb.validate(username, password)
					? Response.status(Status.OK)
							.cookie(getCookie(username, password, false))
							.entity("Logged in").build()
					: Response.status(Status.FORBIDDEN).entity("Failed to login").build();
		} else
			return Response.status(Status.OK).entity("Already logged in").build();
	}

	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Response logout(@CookieParam("samplelogin") Cookie cookie) {
		if (cookie == null)
			return Response.status(Status.OK).entity("Not logged in").build();
		logger.info("cookie details for deletion :: {}", cookie.toString());
		return Response.status(Status.OK)
				.cookie(getCookie(cookie.getName(), cookie.getValue(), true))
				.entity("Logged out").build();
	}
}

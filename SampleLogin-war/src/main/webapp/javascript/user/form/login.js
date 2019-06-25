/* Handles users login, registration and logout */
/* Cookie will be create for user on login
 Destroyed on logout or browser session ended*/
var login = document.getElementById('login');
var register = document.getElementById("reg");
var logout = document.getElementById("logout");

login.onclick = function() {
	document.getElementsByClassName("modal")[0].style.display = "block";
}

reg.onclick = function() {
	document.getElementsByClassName("modal")[1].style.display = "block";
}

logout.onclick = function () {
	var type = "GET";
	var url = "http://localhost:8080/sample/rest/user/logout";
	serverCall(url, type, undefined, callbackLogout);
}

/* Business Logic */
function userLogin() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var type = "GET";
	var url = "http://localhost:8080/sample/rest/user/validate/" + username
			+ "/" + password;
	serverCall(url, type, undefined, callbackLogin);
}

function userRegister() {
	name = document.getElementById("new_name").value;
	surname = document.getElementById("new_surname").value;
	username = document.getElementById("new_username").value;
	password = document.getElementById("new_password").value;
	email = document.getElementById("new_email").value;
	DOB = document.getElementById("new_DOB").value;

	data = {
		name : this.name,
		surname : this.surname,
		username : this.username,
		password : this.password,
		email : this.email,
		phone : "00000000",
		bio : "",
		DOB : new Date(this.DOB).getTime()
	};

	serverCall("http://localhost:8080/sample/rest/user/add", "POST", data, callbackRegister);
}

/* Call back functions to be used by ajax methods */
function callbackLogin(response) {
	if (response.readyState == 4 && response.status == 200) {
		document.getElementById("login-close").click();
		snackbar(response.responseText, true);
	} else if (response.readyState == 4 || response.status > 200) {
		snackbar(response.responseText, false);
	}
}

function callbackLogout(response) {
	if (response.readyState == 4 && response.status == 200) {
		snackbar(response.responseText, false);
	} else {
		snackbar("Failed to logout", false);
	}
}

function callbackRegister(response) {
	if (response.readyState == 4 && response.status == 200) {
		snackbar(response.responseText, true);
		document.getElementById("register-close").click();
	} else {
		snackbar("Failed to register user", false);
	}
}

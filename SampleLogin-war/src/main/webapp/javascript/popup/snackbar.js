function snackbar(message, outcome) {
	// Get the snackbar DIV
	var snack = document.getElementById("snackbar");
	if (outcome == false) {
		snack.style.backgroundColor = "Tomato";
	} else
		snack.style.backgroundColor = "#00C851";
	snack.innerHTML = "<strong>" + message + "</strong>"
	snack.className = "show";

	// After 3 seconds, remove the show class from DIV
	setTimeout(function() {
		snack.className = snack.className.replace("show", "");
	}, 4000);
}
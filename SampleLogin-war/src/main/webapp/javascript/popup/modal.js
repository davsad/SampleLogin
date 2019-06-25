/* Handles Modal closure */
var model = document.getElementsByClassName("modal");
var close = document.getElementsByClassName("close");

window.addEventListener("click", function(event) {
	if (event.target.classList.contains("modal")) {
		for(i=0;i < model.length;i++) {
			document.getElementsByClassName("modal")[i].style.display = "none";
		}
	}
});

window.addEventListener("click", function(event) {
	if (event.target.classList.contains("close")) {
		for(i=0;i < model.length;i++) {
			document.getElementsByClassName("modal")[i].style.display = "none";
		}
	}
});
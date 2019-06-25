/* Handles ajax calls to server */
function serverCall(url, type, data, callback) {
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4) {
			callback(this);
		}
	};
	xhttp.open(type, url, true);
	xhttp.setRequestHeader('Content-Type', 'application/json');
	
	if (data != undefined) {
		xhttp.send(JSON.stringify(data));
	} else
		xhttp.send();
}
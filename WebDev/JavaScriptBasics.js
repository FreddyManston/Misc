function myFunction() {
	var x, text
	
	x = 		document.getElementById("numb").value;
	if(isNaN(x) || x < 1 || x > 10) {
		text = "Input invalid.";
	}
	else {
		text = "Input OK.";
	}
	document.getElementById("Message").innerHTML = text;	
}

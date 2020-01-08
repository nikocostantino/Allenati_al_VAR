function clickOnRegistrati(){
	window.location.href = "../html/registrati.html";
}

function clickOnLogin(){
	window.location.href = "../html/home.jsp";
}
//NON FUNZIONA
window.addEventListener("load", function() {
reset();
});

function reset(){
	document.getElementById("myForm").reset();
	document.getElementById("username").setAttribute("autocomplete","off");
}


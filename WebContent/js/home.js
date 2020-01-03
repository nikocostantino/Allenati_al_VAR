//javascript file

function clickOnLogout(){
	window.location.href = "../html/index.jsp";
}

window.addEventListener("load", function() {
//document.getElementsByClassName("nav-item").addEventListener("load", showNavBar);
showNavBar();
});

function showNavBar(){
	var dim = document.getElementsByClassName("nav-item").length;

	for(i = 0; i < dim; i++) {
		document.getElementsByClassName("nav-item")[i].style.visibility = "visible";
	}
}

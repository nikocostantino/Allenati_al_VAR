window.addEventListener("load", function() {
    document.getElementById("rispostaErrata").addEventListener("click", checkButtonWrong);
    document.getElementById("rispostaCorretta").addEventListener("click", checkButtonCorrect);
    showNavBar();
    

	document.getElementById("rispostaErrata").addEventListener("mouseover", changeColor1);
	document.getElementById("rispostaCorretta").addEventListener("mouseover", changeColor2);
	document.getElementById("rispostaErrata").addEventListener("mouseleave", function(){
		if(document.getElementById("rispostaErrata").className == "btn btn-warning")
			document.getElementById("rispostaErrata").className = "btn btn-dark";
	});
	document.getElementById("rispostaCorretta").addEventListener("mouseleave", function(){
		if(document.getElementById("rispostaCorretta").className == "btn btn-warning")
			document.getElementById("rispostaCorretta").className = "btn btn-dark";
	});
    
});

// come faccio a richiamare una funzione presente in un altro file js
function showNavBar(){
	var dim = document.getElementsByClassName("nav-item").length;

	for(i = 0; i < dim; i++) {
		document.getElementsByClassName("nav-item")[i].style.visibility = "visible";
	}
}

function checkButtonCorrect() {
    document.getElementById("rispostaCorretta").className = "btn btn-success";
    document.getElementById("rispostaErrata").className = "btn btn-dark";
    	
 }
function checkButtonWrong() {
	document.getElementById("rispostaErrata").className = "btn btn-danger";
	document.getElementById("rispostaCorretta").className = "btn btn-dark";
    
}

function changeColor1(){
	if(document.getElementById("rispostaErrata").className != "btn btn-danger")
	document.getElementById("rispostaErrata").className = "btn btn-warning";

}

function changeColor2(){
	if(document.getElementById("rispostaCorretta").className != "btn btn-success")
		document.getElementById("rispostaCorretta").className = "btn btn-warning";

	
}


/////////////////////////////////////




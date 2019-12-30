
window.onload = function() {
    document.getElementById("rispostaCorretta").addEventListener("click", checkAnswer );
    document.getElementById("rispostaErrata").addEventListener("click", checkAnswer );
    document.getElementById("rispostaErrata").addEventListener("click", enableButtonCorrect );
    document.getElementById("rispostaCorretta").addEventListener("click", enableButtonWrong );   
}



function checkAnswer(e){
	alert("Controllo la risposta ma ricordati di implementare una funziona decente");
}
function enableButtonCorrect() {
    document.getElementById("rispostaCorretta").setAttribute("disabled", "disabled");
    document.getElementById("rispostaErrata").className = "btn btn-danger";
    	
 }
function enableButtonWrong() {
    document.getElementById("rispostaErrata").setAttribute("disabled", "disabled");
    document.getElementById("rispostaCorretta").className = "btn btn-success";
}
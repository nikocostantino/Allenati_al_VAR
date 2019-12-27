function changeText(){
	if(document.getElementById("addPreferiti").textContent == "Preferiti")
		document.getElementById("addPreferiti").textContent = "Rimuovi";
	else
		document.getElementById("addPreferiti").textContent = "Preferiti";
}


//NON FUNZIONA, PERCHE'?????
document.getElementById("rispostaCorretta").addEventListener("click", checkAnswer);
function checkAnswer(){
	alert("controlla");
}
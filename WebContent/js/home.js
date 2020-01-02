//javascript file

function clickOnLogout(){
	window.location.href = "../html/index.jsp";
}

window.onload = function() {
document.getElementById("prova_autovalutazione").addEventListener("click", seiSicuro );
}
function seiSicuro() {
	  var inizia = confirm("Sei sicuro di voler iniziare una Prova di Autovalutazione?");
	  if (inizia === true) {
	    location.href="prova_autovalutazione";
	  }else{
	    alert('Operazione annullata');
	  }
	}

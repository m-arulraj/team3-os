function redirect2ProductUpload(){
	 var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     window.location="/upload";
	    }
	    else 
	    	window.location=="/home";
	  };
	  xhttp.open("GET", "", true);
	  xhttp.send();
}
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

function loadCategory(){
	var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     categories = JSON.parse(this.response);
		 setCategories(categories);
	    }
	  };
	  xhttp.open("GET", "http://172.25.229.35:8072/api/products/categories", true);
	  xhttp.send();
	}

function setCategories(categories){
	let element=document.getElementsByTagName("select")[0];
    let htmlString="<option value='' style='display:hidden'>Choose Category</option>";
	categories.forEach(function(category){
		htmlString+="<option value='"+category.name+"'>"+category.name+"</option>";
	})
	console.log(htmlString);
	element.innerHTML=htmlString;
}
loadCategory();
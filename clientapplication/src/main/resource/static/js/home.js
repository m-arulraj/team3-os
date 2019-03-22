var allProduct;
var categories;
var filteredProducts;
function loadProducts() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     allProduct = JSON.parse(this.response);
	 setProducts(allProduct);
    }
  };
  xhttp.open("GET", "http://127.25.229.35:8080/api/products", true);
  xhttp.send();
};

function loadCategory(){
var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     categories = JSON.parse(this.response);
	 setCategories(categories);
    }
  };
  xhttp.open("GET", "http://127.25.229.35:8080/api/products/categories", true);
  xhttp.send();
}


function setProducts(products){
  let container=document.getElementsByClassName("product-items")[0];
  container.innerHTML="";
  console.log(container);
  for(let i=0;i<products.length;i++){
    var element = document.createElement("DIV");
	element.classList.add('w3-col');
	element.classList.add('l3');
	element.classList.add('s6');
	element.innerHTML='<div class="my-img-container" >'+
					  '<img src="images/jeans1.jpg" style="width:100%">'+
					  '<p>'+products[i].name+'<br><b>Rs.'+products[i].price+'</b></p>'
					  +'</div>';
					  
	container.appendChild(element);
  }
}

function setCategories(categories){
  let container=document.getElementById("demoAcc");
   categories.forEach(function(category){
       var element = document.createElement("span");
	   element.innerHTML='<span onclick=categoryClickEvent("'+category.name+'") class="w3-bar-item w3-button">'+category.name+'</span>'
	   container.appendChild(element);
   })
}

function categoryClickEvent(categoryName){
var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     filteredProducts = JSON.parse(this.response);
	 console.log(filteredProducts);
	 setProducts(filteredProducts);
    }
  };
  xhttp.open("GET", "http://127.25.229.35:8080/api/products/filtered/"+categoryName, true);
  xhttp.send();
}
loadProducts();
loadCategory();
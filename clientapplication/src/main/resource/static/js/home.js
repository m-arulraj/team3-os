var allProduct;
var categories;
var filteredProducts;
var images=['laptop.jpg','manimage.jpg','jeans.jpg','shoe.jpeg','tshirt.jpg','watch.jpg','phone.jpg'];
function loadProducts() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     allProduct = JSON.parse(this.response);
	 setProducts(allProduct);
    }
  };
  xhttp.open("GET", "http://127.25.229.35:8091/api/products", true);
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
  xhttp.open("GET", "http://127.25.229.35:8091/api/products/categories", true);
  xhttp.send();
}


function setProducts(products){
	let imgUrl=images[getRandom()];
  let container=document.getElementsByClassName("product-items")[0];
  container.innerHTML="";
  console.log(container);
  for(let i=0;i<products.length;i++){
    var element = document.createElement("DIV");
	element.classList.add('img-wrapper');
	/*element.classList.add('l3');
	element.classList.add('s6');*/
	element.innerHTML='<div class="my-img-container" >'+
					  '<img src="/images/'+images[getRandom()]+'" height="100%" width="auto">'+
					  '<p class="product-text">'+products[i].name+'<br><b>Rs.'+products[i].price+'</b></p>'
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
	var urlStrings="http://127.25.229.35:8091/api/products/filtered/"+categoryName; ;
	if(categoryName!=null){
		
		 var xhttp = new XMLHttpRequest();
		  xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     filteredProducts = JSON.parse(this.response);
			 console.log(filteredProducts);
			 setProducts(filteredProducts);
		    }
		  };
		  xhttp.open("GET",urlStrings, true);
		  xhttp.send();
	}
		
	else
		setProducts(allProduct);
}

function getRandom(){
	var x=Math.floor(Math.random()*images.length);
    return x;
}
loadProducts();
loadCategory();
getRandom();
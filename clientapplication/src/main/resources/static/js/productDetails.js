let product;
let isAddedToCart;
function loadDetails() {
	var url_string =window.location.href;
	console.log(url_string );
	var url = new URL(url_string);
	var id = url.searchParams.get("id");
	console.log(id);
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     product = JSON.parse(this.response);
     console.log(product);
	 setProduct(product);
    }
  };
  xhttp.open("GET", "http://172.25.229.35:8072/api/products/"+id, true);
  xhttp.send();
};

function setProduct(){
	let container=document.getElementById("detailed-container");
	container.innerHTML='<div style="display:inline-block;width:30%"><ul>'+
	                    '<li><strong>Product Name:</strong> '+product.name+'</li>'+
                        '<li><strong>Product Type:</strong> '+product.productcategoryfk.name+'</li>'+
                        '<li><strong>Product Price:</strong> '+product.price+'</li>'+
                        '<li><strong>Product Description:</strong> '+product.description+'</li>'+
                        '</ul></div>'+
		                '<div id="main-product" class="w3-display-container w3-container" style="display:inline-block;width:50%;margin:auto">'+
		                '<img src="/images/jeans.jpg" alt="Jeans" style="width:100%"></div>'+
		                '<div class="detailed-more"><img src="/images/jeans.jpg" alt="Jeans" style="width:100%"></div>'+
		                '<div class="detailed-more"><img src="/images/jeans.jpg" alt="Jeans" style="width:100%"></div>'+
		                '<div class="detailed-more"><img src="/images/jeans.jpg" alt="Jeans" style="width:100%"></div>'
}

function showCartMessage(){
	let element=document.getElementById("cart-message");
	if(isAddedToCart){
		element.innerHTML="<strong>Added to the cart</strong>";
		element.style.visibility="visible";
		setTimeout(function(){
			element.innerHTML="";
			element.style.visibility="hidden";
		},3000);
	}

}

function addToCart(){
	

	let cartObject={customerfk:2,productfk:2/*product.id*/};
	let jsonString=JSON.stringify(cartObject);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     isAddedToCart=this.responseText;
	     showCartMessage();
	    }
	  };
	xhttp.open("POST","http://127.25.229.35:8090/api/addToCart", true);
	xhttp.setRequestHeader("Content-type", "application/json;charset=utf-8");
	xhttp.send(jsonString);
}

function placeOrder(){
	today=new Date();
	dateString=today.getFullYear()+"-"+formatDateField(today.getMonth())+"-"+formatDateField(today.getDate());
	let orderObject={status:"Active",customerfk:2,productfk:product.id,date:dateString};
	let jsonString=JSON.stringify(orderObject);
	console.log(jsonString);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	     isAddedToCart=this.responseText;
	     showCartMessage();
	    }
	  };
	xhttp.open("POST","http://127.25.229.35:8090/api/order", true);
	xhttp.setRequestHeader("Content-type", "application/json;charset=utf-8");
	xhttp.send(jsonString);
}

function formatDateField(field){
	 field=field+1;
	if(field<10){
		field="0"+field;
	}
	return field
}
loadDetails();
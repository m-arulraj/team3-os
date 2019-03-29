let product;
let url_string=window.location.href;
let url = new URL(url_string);
let id = url.searchParams.get("id");
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
     product = JSON.parse(this.response);
     document.getElementById("price").innerHTML=product.price;
     calculate(1);
    }
  };
xhttp.open("get","http://172.25.229.35:8072/api/products/"+id, true);
xhttp.send();
function addOrRemove(add){
	let text;
	let quantity=document.getElementById("quantity");
	text=Number(quantity.innerHTML);
	if(add){
		text+=1;
		 quantity.innerHTML=text;
	}
	else 
		{
		  if(text>1)
			  text-=1;
			  quantity.innerHTML=text;
		}
	calculate(text);
}

function calculate(quantity){
	document.getElementById("total").innerHTML=quantity*product.price;
}

function placeOrder(){
	today=new Date();
	dateString=today.getFullYear()+"-"+formatDateField(today.getMonth())+"-"+formatDateField(today.getDate());
	let orderObject={status:"Active",customerfk:2,productfk:product.id,date:dateString};
	let jsonString=JSON.stringify(orderObject);
	console.log(jsonString);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    document.getElementById("error-modal").visibility="visible";	
	    if (this.readyState == 4 && this.status == 200) {
	     isAddedToCart=this.responseText;
	     console.log(isAddedToCart);
	     
	     document.getElementById("error-modal").innerHTML="<span>Thank You Buddy</span><br><a style='text-decoration:none' href='/'>Continue Shopping</a>"
	     document.getElementById("error-modal").style.backgroundColor="green";		
	     console.log( document.getElementById("error-modal").innerHTML);
	    }
	    
	    else {
	    	document.getElementById("error-modal").innerHTML="<span>Something went wrong</span><br><a style='text-decoration:none' href="/">Continue Shopping</a>"
	    	/*setTimeout(function(){
	    	    window.location.href="/";
	    	},2000);*/
	    		
	    	
	    }
	    document.getElementById("error-modal").visibility="visible";	
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
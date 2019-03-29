let cartList;
let cartContainer;
let totalAmmount=0;
let xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function() {
  if (this.readyState == 4 && this.status == 200) {
   user = JSON.parse(this.response);
   console.log(user);
   sessionStorage.setItem("userName", user.username);
   sessionStorage.setItem("userId", 1);
   document.getElementById("user").innerHTML=user.username;
   loadCart();
  }
};
xhttp.open("GET", "http://localhost:8090/api/user", true);
xhttp.send();

function loadCart(){
	let uId=sessionStorage.getItem("userId");
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	  if (this.readyState == 4 && this.status == 200) {
	   cartList = JSON.parse(this.response);
	   displayCartElement(cartList);
	  }
	};
	xhttp.open("GET", "http://172.25.229.35:8072/api/products/cart/customer/"+uId, true);
	xhttp.send();
}

function displayCartElement(cart){
	console.log(cart);
	document.getElementById("cartQuant").innerHTML=cart.length;
	cartContainer=document.getElementsByClassName("cart-container")[0];
	cartContainer.innerHTML="";
	cart.forEach(function(cartItem,index){
		cartContainer.innerHTML+="<span class='cart-item'> " +
				                 "<strong class='left'>"+cartItem.name+"("+cartItem.price+")"+				           
				                 "</strong>"+
				                 "<span class='quantity' style='font-size: 20px;font-weight:bold'> 1</span>"+
				                 "<button class='btn' style='width: auto;' onclick='addOrRemove(true,"+index+")'>+</button>"+
				                 "<button class='btn' style='width: auto;' onclick='addOrRemove(false,"+index+")'>-</button>"+
				                 "<button class='btn remove-btn' onclick='removeItem("+index+")'> Remove</button>"+
				                 "<button class='btn save-btn' onclick='saveItem("+index+")'> Save</button>"+
				                 "<strong style='float: right;padding-top: 2px;cursor: default;' class='btn'>Price:<span class='total'>"+cartItem.price+"</span>" +
				                 "</strong>"+
				                 "</span><br>";
		totalAmmount+=cartItem.price;
	})
	cartContainer.innerHTML+="<strong id='totalAmount' class='btn total-amount'>Price to Pay("+totalAmmount+")</strong>"
}

function addOrRemove(add,index){
	let quantity;
	let element=document.getElementsByClassName("quantity")[index];
	console.log(element);
	quantity=Number(element.innerHTML);
	if(add){
		quantity+=1;
		element.innerHTML=quantity;
		totalAmmount+=cartList[index].price;
	}
	else 
		{
		  if(quantity>1)
			  quantity-=1;
		  element.innerHTML=quantity;
		  totalAmmount-=cartList[index].price;
		}
     document.getElementById("totalAmount").innerHTML="<span>Total Price To Pay</span>"+totalAmmount;
	calculate(quantity,index);
}

function calculate(quantity,index){
	console.log(cartList[index],cartList);
	document.getElementsByClassName("total")[index].innerHTML=quantity*cartList[index].price;
}
function saveItem(index){
	data={customerfk:sessionStorage.getItem("userId"),productfk:cartList[index].id};
	console.log(JSON.stringify(data));
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	if (this.readyState == 4) {
		   loadCart();
		   console.log("done");
    }
	}
	xhttp.open("POST", "http://localhost:8090/api/user/cart_item", true);
	xhttp.setRequestHeader("Content-type", "application/json;charset=utf-8");
	xhttp.send(JSON.stringify(data));
	
}

function removeItem(index){
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4) {
			   loadCart();
			   console.log("done");
	    }
		}
	xhttp.open("DELETE", "http://localhost:8090/api/user/cart_item?cId="+sessionStorage.getItem("userId")+"&pId="+cartList[index].id, true);
	xhttp.send();
}
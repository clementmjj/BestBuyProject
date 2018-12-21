function updatePrice(elementId) 
{
	var pId = elementId.slice(9);
	var quantity = document.getElementById(elementId).value;
	var pricePerUnit = document.getElementById("price_" + pId).innerHTML
			.slice(1);
	var totalPrice = quantity * pricePerUnit;
	if (totalPrice.toString().indexOf(".") == -1)
		totalPrice = totalPrice + ".0";
	document.getElementById("totalPrice_" + pId).innerHTML = "&#8377;"
			+ totalPrice;

	var productSubtotalList = document
			.getElementsByClassName("productSubtotal");
	var grandTotal = 0;
	for (var i = 0; i < productSubtotalList.length; i++) 
	{
		grandTotal = grandTotal+parseInt(productSubtotalList[i].innerHTML.slice(1));
	}
	if(grandTotal.toString().indexOf(".")==-1)
		grandTotal = "&#8377;"+grandTotal + ".0";
	else
		grandTotal="&#8377;"+grandTotal;
	
	document.getElementById("grandTotal").innerHTML=grandTotal;
}

function showPaymentForm()
{
  var selectedOption=document.getElementById("payment-select").value;
  if(selectedOption=="Credit Card")
  {
    document.getElementById("debitcard-container").style.display="none";
    document.getElementById("cashondelivery-container").style.display="none";
    document.getElementById("creditcard-container").style.display="block";
  }
  else if(selectedOption=="Debit Card")
  {
    document.getElementById("cashondelivery-container").style.display="none";
    document.getElementById("creditcard-container").style.display="none";
    document.getElementById("debitcard-container").style.display="block";
  }
  else
  {
    document.getElementById("debitcard-container").style.display="none";
    document.getElementById("creditcard-container").style.display="none";
    document.getElementById("cashondelivery-container").style.display="block";
  }
}

function closeErrorContainer()
{
	  document.getElementById("error-box-close-button").click();
}
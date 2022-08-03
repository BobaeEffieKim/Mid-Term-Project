/**
 *  cart.js
 	경로 : JSPTest/cart/cart.jsp 
 */
 
 
 //카드에 상품 쌓이게하는 함수
 function cartList(result){
	console.log(result);	//(2) [{…}, {…}]
	
	//위에 있는 애를 가지고 페이지를 그리겠다 
	let cartTemplate = document.querySelector('#template'); //cart.jsp에 id:template있음
	let basket = document.querySelector('#basket');
	
	//위 div태그에다 계속 append할것임
	for(let i=0; i<result.length; i++){
		let rowDiv = cartTemplate.childNodes[1].cloneNode(true);	//div태그의 첫번째 div row data를 가져오겠다 => 카트템플릿의 자식중에 두번째자식을 하나 카피하겠다

		rowDiv.setAttribute('data-id', result[i].no);
		rowDiv.querySelector('div.pname span').textContent = result[i].productNm;
		rowDiv.querySelector('div.basketprice input[name="p_price"]').value = result[i].price;
		rowDiv.querySelector('div.basketprice').childNodes[2].textContext = result[i].price;
		rowDiv.querySelector('div.num input').value = result[i].qty;
		rowDiv.querySelector('div.sum').textContent = (result[i].price * result[i].qty);
		rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('id', 'p_num'+result[i].no);
		rowDiv.querySelector('div.num>div.updown>input:nth-of-type(1)').setAttribute('onKeyup', 'javascript:changePnum('+ result[i].no +')');
		rowDiv.querySelector('div.num>div.updown>span:nth-of-type(1)').setAttribute('onclick', 'javascript:changePnum('+ result[i].no +')');
		rowDiv.querySelector('div.num>div.updown>span:nth-of-type(2)').setAttribute('onclick', 'javascript:changePnum('+ result[i].no +')');

		
		basket.append(rowDiv);
	}
	
}
 
 
 function makeList(){
	
	//ajax. XMLHTTPReauest
	fetch('../cartList.do')
/*	.then(function(result){
		return result.json();
	})*/
	.then(result => result.json())	//윗줄 화살표 함수로 바꾼 것
/*	.then(function(result){
		console.log(result);
	})*/
	.then(cartList)/*	-> 첫번쩨 then에서 넘어온 값이 매개값이 됨 /()안에는 함수의 실행구문이 아니라 , 콜백함수의 이름이 와야한다
	.catch(function(err){
		console.log(err);
	})*/
	.catch(err => console.log(err))
}

function changePnum(no){
	let currentItem = event.target; //이벤트를 받는 대상 가져오기
	console.log(currentItem);
	let currentQty = currentItem.closest('.updown').childNodes[1].value;
	let currentPrice = currentItem.closest('.subdiv').childNodes[1].childNodes[1].value;
	console.log(currentQty, currentPrice);
	
	if(currentItem.classList[2] == 'down'){
		changeQty = parseInt(currentQty) -1;
		currentItem.closest('.updown').childNodes[1].value = changeQty;
	} else{
		changeQty = parseInt(currentQty) +1;
		currentItem.closest('.updown').childNodes[1].value = changeQty;
	}
	
	
	//ajax
	fetch('../cartUpdate.do',{
		method: 'post',
		headers: {'Content-type' : 'application/x-www-form-urlencoded'},
		body: 'no ='+no+'&qty ='+ changeQty
	})
	.then(result => result.text())
	.then(result => console.log(result))
	.catch(err => console.log(err))
	
} 


makeList();
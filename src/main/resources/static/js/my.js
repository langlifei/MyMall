function addToCart(elem){
debugger
    //获取商品信息
    var cart  = new Object();
    cart.PID = parseInt(elem.name);
    cart.quantity = 1;
    cart.price = $(elem).parent().parent().prev().find("span").eq(0).text().substring(1);
    cart.price = parseFloat(cart.price);
    cart.product_attr=cart.PID+"-";
    sendAjaxRequest("/addProduct.do",cart);
}

function addToCompare(elem){
    //获取商品信息
    var cart  = new Object();
    cart.PID = parseInt(elem.name);
    cart.quantity = 1;
    cart.price = $(elem).parent().parent().prev().find("span").eq(0).text().substring(1);
    cart.price = parseFloat(cart.price);
    cart.product_attr=cart.PID+"-";
    sendAjaxRequest("/addCompare.do",cart);
}

function addToWishList(elem) {
    var url ='/addToWishList.do?id='+elem.name;
    sendAjaxRequest(url,null);
}
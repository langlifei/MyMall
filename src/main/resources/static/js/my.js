function addToCart(elem) {
debugger
    //获取商品信息
    var cart = new Object();
    cart.PID = parseInt(elem.name);
    cart.quantity = 1;
    cart.price = $(elem).parent().parent().prev().find("span").eq(0).text().substring(1);
    cart.price = parseFloat(cart.price);
    cart.product_attr = cart.PID + "-";
    var status = $(elem).parent().parent().parent().next().find("span").eq(0).attr("value");
    if (status == 1) {
        sendAjaxRequest("/addProduct.do", cart);
    } else {
        alert("商品缺货或下架,无法加入购物车!")
    }
}

function addToCompare(elem) {
    //获取商品信息
    var cart = new Object();
    cart.PID = parseInt(elem.name);
    cart.quantity = 1;
    cart.price = $(elem).parent().parent().prev().find("span").eq(0).text().substring(1);
    cart.price = parseFloat(cart.price);
    cart.product_attr = cart.PID + "-";
    sendAjaxRequest("/addCompare.do", cart);
}

function addToWishList(elem) {
    var url = '/addToWishList.do?id=' + elem.name;
    sendAjaxRequest(url, null);
}
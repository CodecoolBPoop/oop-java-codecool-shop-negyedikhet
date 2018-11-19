function init() {
    addToCart()
}

function addToCart(){
    let addButtons = document.getElementsByClassName("addtocart");
    for (let button of addButtons){
        button.addEventListener("click", function (event) {
            let productId = event.target.dataset.productid;
            console.log(productId)
        })
    }
    
}

init();
function init() {
    addToCart()
}

function addToCart(){
    let addButtons = document.getElementsByClassName("addtocart");
    for (let button of addButtons){
        button.addEventListener("click", function (event) {
            let productId = event.target.dataset.productid;
            let url = "add-to-cart";
            $.post(url,
                {
                    "productId" : productId
                }, function(response, status) {
                        if (status === "success"){
                            alert("Successfully added to cart")
                        } else {
                            alert("Status: " + status)
                        }

                }
            );
        })
    }

}

init();
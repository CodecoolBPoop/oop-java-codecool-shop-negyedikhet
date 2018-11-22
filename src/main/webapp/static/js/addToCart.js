function init() {
    addToCart();
    $('.alert').hide();

}

function addToCart() {
    let addButtons = document.getElementsByClassName("addtocart");
    for (let button of addButtons) {
        button.addEventListener("click", function (event) {
            let productId = event.target.dataset.productid;
            let url = "add-to-cart";
            $.post(url,
                {
                    "productId": productId
                }, function (response, status) {
                    if (status === "success") {
                        console.log("added ti cart")
                    } else {
                        console.log("Status: " + status)
                    }
                }
            );
        })
    }

}

init();
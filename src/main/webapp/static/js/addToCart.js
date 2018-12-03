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

                }, function(response, status){
                    if (status==='success'){
                        $('#add-cart-success').hide();
                        $('#add-cart-success').show();
                        $('#add-cart-success').delay(1500).fadeOut('slow')
                    }
                }

            );
        })
    }

}

init();
function hideElements(checkbox) {
    let shippingForm = document.getElementById("shippingForm");
    checkbox.addEventListener("click", function () {
        if (checkbox.checked === true) {
            shippingForm.style.display = "none";
        } else {
            shippingForm.style.display = "block";
        }
    })
}

function checkout(checkbox) {
    let checkoutButtons = document.getElementsByClassName("checkoutButton");
    for (let button of checkoutButtons){
        button.addEventListener("click", function () {
            let name = document.getElementById("name").value;
            let email = document.getElementById("email").value;
            let phone = document.getElementById("phone").value;
            let bcountry = document.getElementById("b-country").value;
            let bzip = document.getElementById("b-zip").value;
            let bcity = document.getElementById("b-city").value;
            let baddress = document.getElementById("b-address").value;
            let shcountry = document.getElementById("sh-country").value;
            let shzip = document.getElementById("sh-zip").value;
            let shcity = document.getElementById("sh-city").value;
            let shaddres = document.getElementById("sh-address").value;

            let billingAddress = bcountry+" "+bzip+" "+bcity+" "+baddress;
            let shippingAddress;
            let url = "checkout";
            let queryvalue = this.getAttribute('id');

            if (checkbox.checked === true){
                shippingAddress = billingAddress;
            } else {
                shippingAddress = shcountry+" "+shzip+" "+shcity+" "+shaddres;
            }

            $.post(url,
                {
                    "name": name,
                    "email": email,
                    "phone": phone,
                    "billingAddress":billingAddress,
                    "shippingAddress":shippingAddress,
                }, function(response, status) {
                    if (status === "success"){
                        console.log("Successfully checked out ");
                    } else {
                        alert("Status: " + status + "\nSomething went wrong, please try again!")
                    }
                }
            );
        })
    }
}

function init() {
    let checkbox = document.getElementById("checkbox");
    hideElements(checkbox);
    checkout(checkbox);
}

init();
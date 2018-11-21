function hideElements() {
    let checkbox = document.getElementById("checkbox");
    let shippingForm = document.getElementById("shippingForm");
    checkbox.addEventListener("click", function () {
        if (checkbox.checked === true) {
            shippingForm.style.display = "none";
        } else {
            shippingForm.style.display = "block";
        }
    })
}

function init() {
    hideElements()
}

init();
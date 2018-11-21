function init () {
    const urlParams = new URLSearchParams(window.location.search);
    const paymentMethod = urlParams.get('paymentMethod');
    let formNode = document.getElementById("paymentform");
    if (paymentMethod === "paypal") {
        let divName, divPass;
        let labelName, labelPass;
        let inputName, inputPass;
        divName = document.createElement("div");
        divName.classList.add("form-group");

        labelName = document.createElement("label");
        labelName.setAttribute("for", "username");
        labelName.text = "Username";

        inputName = document.createElement("input");
        inputName.setAttribute("type", "text");
        inputName.classList.add("form-control");
        inputName.setAttribute("id", "username");
        inputName.setAttribute("placeholder", "Username");
        inputName.setAttribute("required", "");



        divPass = document.createElement("div");
        divPass.classList.add("form-group");

        labelPass = document.createElement("label");
        labelPass.setAttribute("for", "password");
        labelPass.text = "Password";

        inputPass = document.createElement("input");
        inputPass.setAttribute("type", "text");
        inputPass.classList.add("form-control");
        inputPass.setAttribute("id", "password");
        inputPass.setAttribute("placeholder", "Password");
        inputPass.setAttribute("required", "");

        divName.appendChild(labelName);
        divName.appendChild(inputName);
        formNode.appendChild(divName);

        divPass.appendChild(inputPass);
        divPass.appendChild(inputPass);
        formNode.appendChild(divPass);


    } else if (paymentMethod === "creditcard") {
        console.log(paymentMethod);
    }
}

init();
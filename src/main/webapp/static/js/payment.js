function init () {
    const urlParams = new URLSearchParams(window.location.search);
    const paymentMethod = urlParams.get('paymentMethod');
    let formNode = document.getElementById("paymentform");
    if (paymentMethod === "paypal") {
        let divName, divPass;
        let labelName, labelPass;
        let inputName, inputPass;
        let spanPaypal;
        let divRow;
        divRow = document.createElement("div");
        divRow.classList.add("form-row");

        spanPaypal = document.createElement("span");
        spanPaypal.classList.add("dataParagraph");
        spanPaypal.innerHTML = "Paypal Credentials";

        divName = document.createElement("div");
        divName.classList.add("form-group");

        labelName = document.createElement("label");
        labelName.setAttribute("for", "username");
        labelName.classList.add("formLabels");
        labelName.innerHTML = "Username";

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
        labelPass.classList.add("formLabels");
        labelPass.innerHTML = "Password";

        inputPass = document.createElement("input");
        inputPass.setAttribute("type", "text");
        inputPass.classList.add("form-control");
        inputPass.setAttribute("id", "password");
        inputPass.setAttribute("placeholder", "Password");
        inputPass.setAttribute("required", "");

        formNode.appendChild(spanPaypal);
        divName.appendChild(labelName);
        divName.appendChild(inputName);
        divRow.appendChild(divName);

        divPass.appendChild(labelPass);
        divPass.appendChild(inputPass);
        divRow.appendChild(divPass);

        formNode.appendChild(divRow);
    }
    buttonBuild(formNode)
}

function buttonBuild(formNode) {
    let paymentButton = document.createElement("button");
    paymentButton.setAttribute("type", "button");
    paymentButton.classList.add("btn");
    paymentButton.classList.add("btn-success");
    paymentButton.setAttribute("id", "paymentbutton");
    paymentButton.innerHTML = "Pay";
    formNode.appendChild(paymentButton);
}

init();
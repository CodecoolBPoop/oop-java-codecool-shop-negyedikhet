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
        let divCardNumber, divCardHolder, divExpDate, divCode;
        let labelCardNumber, labelCardHolder, labelExpDate, labelCode;
        let inputCardNumber, inputCardHolder, inputExpdate, inputCode;

       divCardNumber = document.createElement("div");
        divCardNumber.classList.add("form-group");

        labelCardNumber = document.createElement("label");
        labelCardNumber.setAttribute("for", "cardnumber");
        labelCardNumber.text = "Card Number";

        inputCardNumber = document.createElement("input");
        inputCardNumber.setAttribute("type", "text");
        inputCardNumber.classList.add("form-control");
        inputCardNumber.setAttribute("id", "cardnumber");
        inputCardNumber.setAttribute("placeholder", "Card Number");
        inputCardNumber.setAttribute("required", "");


        divCardHolder = document.createElement("div");
        divCardHolder.classList.add("form-group");

        labelCardHolder = document.createElement("label");
        labelCardHolder.setAttribute("for", "cardholder");
        labelCardHolder.text = "Card Holder";

        inputCardHolder = document.createElement("input");
        inputCardHolder.setAttribute("type", "text");
        inputCardHolder.classList.add("form-control");
        inputCardHolder.setAttribute("id", "cardholder");
        inputCardHolder.setAttribute("placeholder", "Card Holder");
        inputCardHolder.setAttribute("required", "");


        divExpDate = document.createElement("div");
        divExpDate.classList.add("form-group");

        labelExpDate = document.createElement("label");
        labelExpDate.setAttribute("for", "cardnumber");
        labelExpDate.text = "Expiration Date";

        inputExpdate = document.createElement("input");
        inputExpdate.setAttribute("type", "text");
        inputExpdate.classList.add("form-control");
        inputExpdate.setAttribute("id", "expdate");
        inputExpdate.setAttribute("placeholder", "Expiration Date");
        inputExpdate.setAttribute("required", "");


        divCode = document.createElement("div");
        divCode.classList.add("form-group");

        labelCode = document.createElement("label");
        labelCode.setAttribute("for", "code");
        labelCode.text = "Code";

        inputCode = document.createElement("input");
        inputCode.setAttribute("type", "text");
        inputCode.classList.add("form-control");
        inputCode.setAttribute("id", "code");
        inputCode.setAttribute("placeholder", "Code");
        inputCode.setAttribute("required", "");

        divCardNumber.appendChild(labelCardNumber);
        divCardNumber.appendChild(inputCardNumber);
        formNode.appendChild(divCardNumber);

        divCardHolder.appendChild(labelCardHolder);
        divCardHolder.appendChild(inputCardHolder);
        formNode.appendChild(divCardHolder);

        divExpDate.appendChild(labelExpDate);
        divExpDate.appendChild(inputExpdate);
        formNode.appendChild(divExpDate);

        divCode.appendChild(labelCode);
        divCode.appendChild(inputCode);
        formNode.appendChild(divCode);
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
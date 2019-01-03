function init() {
    login();
}

function login() {
    let loginButton = document.getElementById("loginButton");
    loginButton.addEventListener("click", function () {
        let loginResponse = document.getElementById("loginResponse");
        let email = document.getElementById("loginEmail").value;
        let password = document.getElementById("loginPassword").value;
        let url = "signin";
        $.post(url,
            {
                "email": email,
                "password": password,
            }).done(function () {
            loginResponse.innerText = "Succesfully logged in";
            setTimeout(function () {
                $("#loginModal").modal('hide');
            }, 1000);
        }).fail(function () {
            loginResponse.innerText = "Email or username is invalid!"
        })
    })
}

init();
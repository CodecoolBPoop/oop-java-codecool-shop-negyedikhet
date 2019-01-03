function init() {
    login();
}

function login() {
    let loginButton = document.getElementById("loginButton");
    loginButton.addEventListener("click", function () {
        let email = document.getElementById("loginEmail").value;
        let password = document.getElementById("loginPassword").value;
        let url = "signin";
        $.post(url,
            {
                "email": email,
                "password": password,
            }
        );
    })
}

init();
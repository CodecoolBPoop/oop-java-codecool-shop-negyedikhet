function init() {
    register();
}

function register() {
    let regButton = document.getElementById("regButton");
    regButton.addEventListener("click", function () {
        let email = document.getElementById("regEmail").value;
        let password = document.getElementById("regPassword").value;
        let url = "signup";
        $.post(url,
            {
                "email": email,
                "password": password,
            }
        );
    })
}

init();
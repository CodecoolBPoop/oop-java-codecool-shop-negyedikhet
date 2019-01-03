function init() {
    register();
}

function register() {
    let regButton = document.getElementById("regButton");
    regButton.addEventListener("click", function () {
            let regResponse = document.getElementById("regResponse");
            let email = document.getElementById("regEmail").value;
            let password = document.getElementById("regPassword").value;
            let url = "signup";
            $.post(url,
                {
                    "email": email,
                    "password": password,
                }).done(function () {
                regResponse.innerText = "Succesfully registered";
                setTimeout(function () {
                    $("#registerModal").modal('hide');
                }, 1000);
            }).fail(function () {
                regResponse.innerText = "This user is already registered!"
            })
        }
    )
}

init();
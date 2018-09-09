function onLoad() {

    $("#password").keyup(checkPasswordsMatch);
    $("#password_confirmation").keyup(checkPasswordsMatch);

    $("#form").submit(canSubmit);
}

function canSubmit() {
    var password = $("#password").val();
    var confirmpass = $("#password_confirmation").val();

    if (password !== confirmpass) {
        alert("Passwords do not match!");
        return false;
    }
    else {
        return true;
    }
}

function checkPasswordsMatch() {
    var password = $("#password").val();
    var confirmpass = $("#password_confirmation").val();

    if (password.length > 3 || confirmpass.length > 3) {

        if (password === confirmpass) {
            $("#passwords_match_text").text("Passwords match.");
            $("#passwords_match_text").addClass("green-text");
            $("#passwords_match_text").removeClass("materialize-red-text");
        } else {
            $("#passwords_match_text").text("Passwords do not match.");
            $("#passwords_match_text").addClass("materialize-red-text");
            $("#passwords_match_text").removeClass("green-text");
        }
    }
}

$(document).ready(onLoad);

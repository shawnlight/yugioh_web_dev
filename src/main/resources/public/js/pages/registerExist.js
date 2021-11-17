function check_pass() {
    var psw_repeat  = document.getElementById("psw-repeat");
    if (document.getElementById('psw').value ===
        document.getElementById('psw-repeat').value) {
        document.getElementById('submit').disabled = false;
        psw_repeat.style.borderColor = "green";
    } else {
        document.getElementById('submit').disabled = true;
        psw_repeat.style.borderColor = "red";
    }
}


function check_email(){
    var email_box = document.getElementById("email");
    var input_email = document.getElementById("email").value;
    var format = /\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
    if(format.test(input_email)){
        email_box.style.borderColor = "green";
        document.getElementById('submit').disabled = false;
    }
    else{
        email_box.style.borderColor = "red";
        document.getElementById('submit').disabled = true;
    }
}

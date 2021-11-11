function check_pass() {
    if (document.getElementById('psw').value ==
        document.getElementById('psw-repeat').value) {
        document.getElementById('submit').disabled = false;
    } else {
        document.getElementById('submit').disabled = true;
    }
}
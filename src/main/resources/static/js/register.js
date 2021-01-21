
function showImg(obj) {
    var file=$(obj)[0].files[0];
    var imgdata='';
    if(file)
    {
        var reader=new FileReader();
        reader.readAsDataURL(file);
        reader.onload=function(evt){
            $("#img").attr('src',evt.target.result)
        };
    }
    else{
        alert("error");
    }
}
function isEmail(str) {
    var reg = /^[a-zA-Z0-9_-]{1,}@[a-zA-Z0-9_-]+(\.[a-zA-Z]+)+$/;
    return reg.test(str);
}
function register() {
    var username = $('#username').val();
    var password = $('#password').val();
    var firstname = $('#firstname').val();
    var lastname = $('#lastname').val();
    var email = $('#email').val();
    if (username.length < 2||username.length > 20) {
        alert('Username should be 2 to 20 characters');
        return false;
    }
    if (password.length < 6) {
        alert('Password length cannot be less than 6 characters');
        return false;
    }
    if (firstname.length < 2||firstname.length > 20) {
        alert('First name should be 2 to 20 characters');
        return false;
    }
    if (lastname.length < 2||lastname.length > 20) {
        alert('Last name should be 2 to 20 characters');
        return false;
    }
    if (!isEmail(email)){
        alert('Invalid email');
        return false;
    }
    return true;
}
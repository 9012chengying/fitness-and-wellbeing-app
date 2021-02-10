// //checkUserName
// function checkUserName() {
//     var fname = document.myform.username.value;
//     var reg = /^[0-9a-zA-Z]/;
//     if (fname.length != 0) {
//         for (i = 0; i < fname.length; i++) {
//             if (!reg.test(fname)) {
//                 alert("Only letters or numbers can be entered");
//                 return false;
//             }
//         }
//         if (fname.length < 4 || fname.length > 16) {
//             alert("\n" +
//                 "Can only enter 4-16 characters");
//             return false;
//         }
//     }
//     else {
//         alert("Please enter username");
//         document.myform.username.focus();
//         return false;
//     }
//     return true;
// }
//
// function passCheck() { // confirm password
//     var userpass = document.myform.password.value;
//     if (userpass == "") {
//         alert("Please enter password");
//         document.myform.password.focus();
//         return false;
//     }
//     if (userpass.length < 6 || userpass.length > 12) {
//         alert("Can only enter 4-16 characters\n");
//         return false;
//     }
//     return true;
// }
//
// function passCheck2() {
//     var p1 = document.myform.password.value;
//     var p2 = document.myform.password2.value;
//     if (p1 != p2) {
//         alert("Confirm password is inconsistent with password input");
//         return false;
//     } else {
//         return true;
//     }
// }
//
//
//
// // show/hide password
// $(function () {
//     $("#passwordeye").click(function () {
//         let type = $("#password").attr('type')
//         if (type === "password") {
//             $("#password").attr("type", "text");
//         } else {
//             $("#password").attr("type", "password");
//         }
//     });
// });
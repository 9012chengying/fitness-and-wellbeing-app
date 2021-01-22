$(document).ready(function () {
    $("#form1").on("submit", function(e){
        e.preventDefault()
        $.ajax(
            {
                type: "GET",
                data: $("#form1").serialize(),
                cache: false,
                url: "/trainer/PtPersonalInfo",
                success: function () {
                    alert("Updated changes");
                },
                error: function () {
                    alert("Error - Data not saved");
                }

            })})
    $("#form2").on("submit", function(e){
        e.preventDefault()
        $.ajax(
            {
                type: "GET",
                data: $("#form2").serialize(),
                cache: false,
                url: "/trainer/PtGeneralInfo",
                success: function()
                {
                    alert("Updated changes");
                },
                error: function()
                {
                    alert("Error - Data not saved");
                }

            }) })})
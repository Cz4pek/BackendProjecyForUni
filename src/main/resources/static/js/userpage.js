$(document).ready(function () {

    $('#info').click(function () {

        var url = 'http://localhost:8080/userpage/info';
        $.ajax({
            url: url,
            type: 'GET',
            success: function (data) {
                $("#userPageContent").html(data);
            }
        })

    });

    $('#change').click(function () {

        var url = 'http://localhost:8080/userpage/change';
        $.ajax({
            url: url,
            type: 'GET',
            success: function (data) {
                $("#userPageContent").html(data);
            }
        })
    });

    $('#submitChanges').click(function () {
        var data = {};
        var temp = $('#firstname').val();
        if(temp !== "") data.firstname = temp;
        temp = $('#lastname').val();
        if(temp !== "") data.lastname = temp;
        temp = $('#email').val();
        if(temp !== "") data.email = temp;
        if(Object.keys(data).length === 0 && data.constructor === Object)  alert("Nie wprowadzono danych do zmiany");
        else {
            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");

            var body = JSON.stringify(data)

            var requestOptions = {
                method: 'PUT',
                headers: myHeaders,
                body: body,
                redirect: 'follow'
            };

            fetch("http://localhost:8080/userpage/change", requestOptions)
                .then(response => response.text())
                .then(result => console.log(result))
                .catch(error => console.log('error', error));

        }

    });

    $('#delete').click(function () {


        var data = {};
        data.firstname = $('#firstname').val();
        data.lastname = $('#lastname').val();
        data.email = $('#email').val();

        if(Object.keys(empty).length === 0 && empty.constructor === Object)

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        var body = JSON.stringify(data)

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: body,
            redirect: 'follow'
        };

        // fetch("http://localhost:8080/userpage", requestOptions)
        //     .then(response => response.text())
        //     .then(result => console.log(result))
        //     .catch(error => console.log('error', error));
        //
        
    });
    

});
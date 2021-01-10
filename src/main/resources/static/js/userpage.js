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

        if (confirm("Usunięcie konta spowoduje stracenie dostępu do danych z nim związnych, kontynuować?")){

            var requestOptions = {
                method: 'DELETE',
                redirect: 'follow'
            };

            fetch("http://localhost:8080/userpage/delete", requestOptions)
                .then(response => {
                    window.location.href = "http://localhost:8080/logout"
                })
                .then(result => console.log(result))
                .catch(error => console.log('error', error));

        }

    });

    $('#addOffer').click(function () {

        var url = 'http://localhost:8080/userpage/addOffer';
        $.ajax({
            url: url,
            type: 'GET',
            success: function (data) {
                $("#userPageContent").html(data);
            }
        })
    });


    $('#submitNewOffer').click(function () {

        var data = {};
        data.title = $('#city').val();
        data.summary = $('#summary').val();
        data.bodytitle = $('#title').val();
        data.info = $('#newOfferInfo').val();
        data.img_url = $('#img').val();
        data.price = $('#price').val();
        data.category = $('#category').val();



        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        var body = JSON.stringify(data)

        console.log(body);

        var requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: body,
            redirect: 'follow'
        };

        fetch("http://localhost:8080/userpage/addOffer", requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));



    });




});
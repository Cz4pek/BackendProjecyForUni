$(document).ready(function () {

    $('#register').click(function () {
        var dane = {};
        dane.username = $('#username').val();
        dane.firstname = $('#firstname').val();
        dane.lastname = $('#lastname').val();
        dane.email = $('#email').val();
        dane.password = $('#password').val();


        if (validates('')) {
            var lista = JSON.parse(localStorage.getItem('lista'));
            if (lista === null) lista = [];
            lista.push(dane);
            localStorage.setItem('lista', JSON.stringify(lista));
            var myHeaders = new Headers();
            myHeaders.append("Content-Type", "application/json");

            var body = JSON.stringify(dane)

            var requestOptions = {
                method: 'POST',
                headers: myHeaders,
                body: body,
                redirect: 'follow'
            };

            fetch("http://localhost:8080/register", requestOptions)
                .then(response => {
                    if (response.status === 206) {
                        response.text().then(result =>{
                           if (result === "user or email")alert("Nazwa użytkownika lub email jest błędny ")
                            else alert("Błędne dane" + result)
                        })
                    }
                    else window.location.href = "http://localhost:8080/login"
                })
                .then(result => console.log(result))
                .catch(error => console.log('error', error));
        }

    });

    function validates(str) {
        return (document.getElementById(str + 'firstname').checkValidity() && document.getElementById(str + 'lastname').checkValidity() && document.getElementById(str + 'email').checkValidity() && document.getElementById(str + 'username').checkValidity() &&
            document.getElementById(str + 'password').checkValidity());
    }

});
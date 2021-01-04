function ofertaSwiat() {

    var url = 'http://localhost:8080/world';
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            $("#oferty").html(data);
        }
    })
    $('#kraj').removeClass('active');
    $('#europa').removeClass('active');
    $('#swiat').addClass('active');

}


function ofertakKraj() {

    var url = 'http://localhost:8080/country';
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            $("#oferty").html(data);
        }
    })
    $('#kraj').addClass('active');
    $('#europa').removeClass('active');
    $('#swiat').removeClass('active');
}

function ofertaEuropa() {
    var url = 'http://localhost:8080/continent';
    $.ajax({
        url: url,
        type: 'GET',
        success: function (data) {
            $("#oferty").html(data);
        }
    })
    $('#kraj').removeClass('active');
    $('#europa').addClass('active');
    $('#swiat').removeClass('active');
}

function ofertaBrak() {

    let tresc = '<h2>Brak następnych ofert</h2>';
    $('.card').css('display', 'none');
    $('#brak').css('display', 'block');

}
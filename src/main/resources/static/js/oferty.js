function ofertaSwiat() {
    window.location.href = '/world';
    $('#kraj').removeClass('active');
    $('#europa').removeClass('active');
    $('#swiat').addClass('active');

}


function ofertakKraj() {

    window.location.href = '/country';
    $('#kraj').addClass('active');
    $('#europa').removeClass('active');
    $('#swiat').removeClass('active');
}

function ofertaEuropa() {
    window.location.href = '/continent';
    $('#kraj').removeClass('active');
    $('#europa').addClass('active');
    $('#swiat').removeClass('active');
}

function ofertaBrak() {

    let tresc = '<h2>Brak następnych ofert</h2>';
    $('.card').css('display', 'none');
    $('#brak').css('display', 'block');

}
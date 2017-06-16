$(document).ready(function () {
    var o = $(document).scrollTop() / 200;
    $("nav").css('background-color', 'transparent');
    $(".color").css('background-color', 'transparent');
    $('.color').css('opacity', 1);
    $(document).on('scroll', function (e) {
        e.preventDefault();
        var o = $(document).scrollTop() / 200;
        if (o > 1.000) {
            console.log('teste');
             o = 1; }
             else{
                 $('.color').css('opacity', 1);
             }

        var e = $('nav');
        $('.color').css('opacity', o);
    });
});


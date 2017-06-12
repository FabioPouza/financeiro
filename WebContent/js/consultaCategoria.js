
    $(document).ready(function () {
        var val = $(this).serialize();
        var ggg = $("#txtCategoria");

        //console.log($("#txtCategoria").append('<option value="option6">option6</option>'));
        $.ajax({

            url: '/financeiro/ConsultaCategoria',
            type: "POST",
            dataType: 'html',
            contentType: 'application/json',
            data: val,
            success: function (data) {
                ggg.append('<option value="option6">option6</option>');
                var json = $.parseJSON(data);
                console.log($("#txtCategoria").append('<option value="option6">option6</option>'));
                console.log(data);
                console.log(json);
                $('#txtCategoria').append('<option value="option6">option6</option>');
                $('#txtValor').val(json.teste2);
                callback();
                
            }
        });
    });
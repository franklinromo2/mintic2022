
$(document).ready(function () {

    BuscarUsuario();


});



function BuscarUsuario() {

    if (window.sessionStorage) {
        var username = sessionStorage.getItem("nombre");
        if (username === null)
        {
            window.location.href = 'index.html';
        }
    }


    $.ajax({
        type: "POST",
        dataType: "html",
        url: "./ServletConsultarPlanesInversion",
        success: function (result) {

            let parsedResult = JSON.parse(result);
            if (parsedResult != false) {
                let contenido = "";
                let periodo ="";

                $.each(parsedResult, function (index, planes) {
                    objplanes = JSON.parse(planes);
                    periodo = objplanes.pln_periodicidad;
                    
                    periodo = (periodo.trim() ==='D' ? 'DIARIO': (periodo.trim() ==='M' ? ' MENSUAL': 'ANUAL'));
                    
                    let detalle = "Porcentaje:"+objplanes.pln_porcentaje+"% <br>Rentabilidad: "+periodo ;

                    contenido += '<div class="col-sm-4 align-self-start">' +
                            ' <div class="card" style="width: 90%;">' +
                            '   <img src="img/bitcoin.jpg" class="card-img-top" widt="10px" >' +
                            '    <div class="card-body">' +
                            '       <h5 class="card-title">' + objplanes.pln_nombre + '</h5>' +
                            '       <p class="card-text">'+detalle+'</p>' +
                            '       <a href="#" class="btn btn-primary">Adquir Plan</a>' +
                            '    </div>' +
                            '  </div> ' +
                            ' </div>';



                });
                $("#listadoplanes").html(contenido);

            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Profile Usuario',
                    text: 'Error al consultar datos!',
                    confirmButtonText: 'Aceptar'
                });

            }
        }
    });
}

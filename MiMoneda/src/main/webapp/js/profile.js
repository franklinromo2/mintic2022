
$(document).ready(function () {

    BuscarUsuario();



    $(".btn-update").click(function () {
        event.preventDefault();
        ModificarUsuario();
    });


    $(".btn-delete").click(function () {
        event.preventDefault();
        EliminarUsuario();
    });
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
        url: "./ServletConsultarUsuario",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);



            if (parsedResult != false) {


                let username = parsedResult['pk_usr_login'];
                let password = parsedResult['usr_password'];
                let fullnombre = parsedResult['usr_nombre'];
                let email = parsedResult['usr_email'];

                $("#profile_username").val(username);
                $("#profile_password").val(password);
                $("#profile_confirmpassword").val(password);
                $("#profile_fullname").val(fullnombre);
                $("#profile_email").val(email);

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





function ModificarUsuario() {

    let var_login = $("#profile_username").val();
    let var_password = $("#profile_password").val();
    let var_confirmpassword = $("#profile_confirmpassword").val();
    let var_nombre = $("#profile_fullname").val();
    let var_email = $("#profile_email").val();

    if (var_login == '' || var_password == '' || var_nombre == '')
    {
        Swal.fire({
            icon: 'error',
            title: 'Profile Usuario',
            text: 'Debe diligencia todos los campos',
            confirmButtonText: 'Aceptar'
        });

    }
    if (var_password != var_confirmpassword)
    {
        Swal.fire({
            icon: 'error',
            title: 'Profile Usuario',
            text: 'Las contraseñas deben ser iguales!',
            confirmButtonText: 'Aceptar'
        });


    } else
    {
        $.ajax({
            type: "POST",
            dataType: "html",
            url: "./ServletActualizarUsuario",
            data: $.param({
                username: var_login,
                contrasena: var_password,
                fullname: var_nombre,
                email: var_email
            }),
            success: function (result) {

                if (result.trim() === "OK") {

                    Swal.fire({
                        icon: 'success',
                        title: 'Profile Usuario',
                        text: 'El usuario se ha actualizado correctamente!',
                        confirmButtonText: 'Aceptar'

                    });

                } else {
                    Swal.fire({
                        icon: 'error',
                        title: 'Profile Usuario',
                        text: 'Se presento un error la actualizar el usuario!',
                        confirmButtonText: 'Aceptar'
                    });

                }
            }
        });

    }
}

function EliminarUsuario() {

    if (window.sessionStorage) {
        var username = sessionStorage.getItem("nombre");
        if (username === null)
        {
            window.location.href = 'index.html';
        }
    }

    Swal.fire({
        title: 'Profile Usuario',
        text: "Esta seguro de borar el usuario?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire(
                    $.ajax({
                        type: "POST",
                        dataType: "html",
                        url: "./ServletEliminarUsuario",
                        data: $.param({
                            username: username
                        }),
                        success: function (result) {

                            if (result.trim() === "OK") {

                                Swal.fire({
                                    icon: 'success',
                                    title: 'Profile Usuario',
                                    text: 'El usuario se ha eliminado correctamente!',
                                    confirmButtonText: 'Aceptar'

                                }).then(() => {
                                    window.location.href = 'index.html';
                                });

                            } else {
                                Swal.fire({
                                    icon: 'error',
                                    title: 'Profile Usuario',
                                    text: 'Error al Eliminar datos!',
                                    confirmButtonText: 'Aceptar'
                                });

                            }
                        }
                    })
                    )
        }
    });




}






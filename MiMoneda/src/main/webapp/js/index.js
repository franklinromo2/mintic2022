
$(document).ready(function () {
    sessionStorage.clear();

    $(".btn-signin").click(function () {
        event.preventDefault();
        autenticarUsuario();
    });


    $(".btn-signup").click(function () {
        event.preventDefault();
        RegistrarUsuario();
    });
});





function autenticarUsuario() {

    sessionStorage.clear();
    let username = $("#username").val();
    let contrasena = $("#password").val();

    $.ajax({
        type: "POST",
        dataType: "html",
        url: "./ServletUsuarioLogin",
        data: $.param({
            username: username,
            contrasena: contrasena
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult != false) {

                let username = parsedResult['pk_usr_login'];
                let usr_nombre = parsedResult['usr_nombre'];


                if (window.sessionStorage) {

                    sessionStorage.setItem("nombre", username);

                } else
                {
                    throw new Error('Tu Browser no soporta sessionStorage!');
                }

                $(".welcome").text("Bienvenido, " + usr_nombre);
                $(".btn-animate").toggleClass("btn-animate-grow");
                $(".welcome").toggleClass("welcome-left");
                $(".cover-photo").toggleClass("cover-photo-down");
                $(".frame").toggleClass("frame-short");
                $(".profile-photo").toggleClass("profile-photo-down");
                $(".btn-goback").toggleClass("btn-goback-up");
                $(".forgot").toggleClass("forgot-fade");

                setTimeout(function () {
                    window.location.href = 'main.html';
                }, 5000);

            } else {
                Swal.fire({
                    icon: 'error',
                    title: 'Acceso',
                    text: 'Usuario o contraseña invalida!',
                    confirmButtonText: 'Aceptar'
                });

            }
        }
    });
}



function RegistrarUsuario() {

    sessionStorage.clear();

    let var_login = $("#signup_username").val();
    let var_password = $("#signup_password").val();
    let var_confirmpassword = $("#signup_confirmpassword").val();
    let var_nombre = $("#signup_fullname").val();
    let var_email = $("#signup_email").val();


    console.log("**" + var_login.trim() + "**");


    if (var_login.trim() === '' || var_password.trim() === '' || var_nombre.trim() === '')
    {
        Swal.fire({
            icon: 'error',
            title: 'Registro',
            text: 'Debe diligencia todos los campos',
            confirmButtonText: 'Aceptar'
        });

    } else
    {
        if (var_password !== var_confirmpassword)
        {
            Swal.fire({
                icon: 'error',
                title: 'Registro',
                text: 'Las contraseñas deben ser iguales!',
                confirmButtonText: 'Aceptar'
            });


        } else
        {
            $.ajax({
                type: "POST",
                dataType: "html",
                url: "./ServletRegistrarUsuario",
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
                            title: 'Registro',
                            text: 'El usuario se ha creado correctamente!',
                            confirmButtonText: 'Aceptar'
                        }).then(() => {
                            window.location.href = 'index.html';
                        });

                    } else {
                        Swal.fire({
                            icon: 'error',
                            title: 'Registro',
                            text: 'Se presento un error la registrar el usuario!',
                            confirmButtonText: 'Aceptar'
                        });

                    }
                }
            });
        }

    }
}

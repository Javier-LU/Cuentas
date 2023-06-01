// Este script gestiona toda la web de registro de usuario

// Variables
var usuariosJson = "";
const validarFormulario = document.getElementById('iDsubmit');
const basura = document.getElementById('basura');
// Eliminar
const formulario = document.getElementById('formPost');
// Tipo de imagen
var formImg = document.getElementById('formImg');
const fileInput = document.getElementById('file');
// Variables para cambiar el color al texto
var textoName = document.getElementById('labeLusername');
var texUser = textoName.textContent;
var textoPass = document.getElementById('labeLpassword');
var texPass = textoPass.textContent;
var imglabel = document.getElementById('seleccionaImagen');
var teximgla = imglabel.textContent;
var text1 = "Usuario repetido";
var text2 = "Password no valido";
var text4 = "";
var divs = "";
var rgb = "";
// Variables para capturar el campo de la imagen


// ╔══════════════════════════════════════════╗
// ║               Fetch inicial              ║
// ╚══════════════════════════════════════════╝

function llamar(url) {
    fetch(url)
        .then(res => res.json())
        .then(res => {
            const respuestaC = JSON.parse(res.respuestaC);
            usuariosJson = JSON.parse(res.usuarios);
            pintar(respuestaC);

        })
        .catch(error => {
            console.log(error);
        });
}

// Pintar datos
function pintar(datos) {

    tipoImagen.value = "login";
    console.log(tipoImagen.value);
    let htm = "";
    for (i = 0; i < datos.length; i++) {
        htm += "<div id='" + datos[i].id + "' class='contenedorImagen'><img src='" + datos[i].img + "'></div>";
    }
    document.getElementById("contenedor").innerHTML = htm;

    divs = document.querySelectorAll('.contenedorImagen');

    divs.forEach(function (div) {
        div.addEventListener('click', function () {
            divs.forEach(function (otherDiv) {
                otherDiv.style.backgroundColor = 'transparent';
            });
            div.style.backgroundColor = 'red';
            let imagen = div.querySelector('img');
            let src = imagen.getAttribute('src');
            sessionStorage.clear();
            sessionStorage.setItem('dir', src);
            let divId = imagen.parentNode.id;
            imgform.value = divId;
        });
    });
}
// Al cargar la pagina
window.onload = function () {

    llamar("../gestionImagenUsuario");

}

// ╔══════════════════════════════════════════╗
// ║   Animación de eliminar y poner texto    ║
// ╚══════════════════════════════════════════╝

// cambiar el color del texto texto
function cambiarColor(dato1, dato2, dato3, colorRGB) {
    for (let i = 1; i < dato2.length + 1; i++) {
        var newText = "";
        setTimeout(function () {
            newText = dato2.slice(0, -i);
            dato1.textContent = newText;
            if (i === dato2.length) {
                dato1.style.color = colorRGB;
                for (let j = 0; j < dato3.length; j++) {
                    setTimeout(function () {
                        newText += dato3[j];
                        dato1.textContent = newText;
                    }, j * 50);
                }
            }
        }, i * 50);
    }
    if (dato3 == "Usuario repetido" || dato3 == "Nombre unico" || dato3 == "No puede estar vacio este campo") {
        texUser = dato3;
    } else if (dato3 == "Password no valido" || dato3 == "Password correcto" || dato3 == "No puede estar vacio el password") {
        texPass = dato3;
    } else {
        teximgla = dato3;
    }
}

// ╔══════════════════════════════════════════╗
// ║               Validaciones               ║
// ╚══════════════════════════════════════════╝


// Validad contraseña
function validarContrasena(llave) {
    if (llave.length < 3) {
        return false;
    }
    // if (!/[A-Z]/.test(llave)) {
    //     return false;
    // }
    // if (!/[0-9]/.test(llave)) {
    //     return false;
    // }
    return true;
}

// Validar Usuario
function validarUsuario() {
    var username = document.getElementById('username');
    var Name = username.value;
    let existe = usuariosJson.some(usuariosJson => usuariosJson.nombre === Name);

    if (Name.trim() === '') {
        if (texUser != "No puede estar vacio este campo") {
            rgb = "red"
            text4 = "No puede estar vacio este campo";
            cambiarColor(textoName, texUser, text4, rgb);
        }
    } else if (existe) {
        if (texUser != "Usuario repetido") {
            rgb = "red"
            cambiarColor(textoName, texUser, text1, rgb);
        }
    } else {
        if (texUser != "Nombre unico") {
            rgb = "green";
            text4 = "Nombre unico";
            cambiarColor(textoName, texUser, text4, rgb);
        }
    }
}

// Validar passwword
function validarPass() {
    var password = document.getElementById('password');
    var Pass = password.value;
    var esValida = validarContrasena(Pass);
    if (Pass.trim() === '') {
        if (texPass != "No puede estar vacio el password") {
            rgb = "red"
            text4 = "No puede estar vacio el password";
            cambiarColor(textoPass, texPass, text4, rgb);
        }
    } else if (esValida) {
        if (texPass != "Password correcto") {
            rgb = "green";
            text4 = "Password correcto";
            cambiarColor(textoPass, texPass, text4, rgb);
        }
    } else {
        if (texPass != "Password no valido") {
            rgb = "red";
            cambiarColor(textoPass, texPass, text2, rgb);
        }
    }
}

// Validar imagen
function validarImagen() {
    var imgform = document.getElementById('imgform');
    var imgf = imgform.value;
    if (imgf.trim() === '') {
        if (teximgla != "Debes seleccionar una imagen") {
            rgb = "red"
            text4 = "Debes seleccionar una imagen";
            cambiarColor(imglabel, teximgla, text4, rgb);
        }
    } else {
        if (teximgla != "Bien hecho, seleccionaste una imagen") {
            rgb = "green"
            text4 = "Bien hecho, seleccionaste una imagen";
            cambiarColor(imglabel, teximgla, text4, rgb);
        }
    }

}


// Validar formulario
validarFormulario.addEventListener('click', function (event) {
    event.preventDefault();
    var newText = "";
    validarUsuario();
    validarPass();
    validarImagen();

    if (texUser === "Nombre unico" && teximgla === "Bien hecho, seleccionaste una imagen") {
        // Creo un objeto FormData a partir del formulario. Recoge todos los campos del formulario
        const formData = new FormData(formulario);
        // URLSearchParams es una interfaz útil para trabajar con parámetros de URL
        const data = new URLSearchParams();
        // Recorrer todos los pares clave(pair[0])/valor(pair[1]) en el objeto formData y se añaden al objeto URLSearchParams.
        for (const pair of formData) {
            data.append(pair[0], pair[1]);
        }
        // Envia el formulario de forma asincrona
        fetch(formulario.action, {
            method: formulario.method,
            body: data
        }).then(response => {
            console.log("realizado");
            window.location.href = 'login.html';
        }).catch(error => {
            console.error(error);
            // Aquí puedes manejar los errores de la solicitud
        });


    };
});

// ╔══════════════════════════════════════════╗
// ║           Gestión de las imagenes        ║
// ╚══════════════════════════════════════════╝


// Gestiona las imagenes
file.addEventListener('change', function (event) {
    const file = fileInput.files[0];
    if (file) {
        const formData = new FormData();
        formData.append('photo', file);
        // Puedes agregar más campos al objeto formData según tus necesidades
        const tipoImagen = document.getElementById('tipoImagen').value;
        formData.append('ima', tipoImagen);

        fetch('../GestionImagenes', {
            method: 'POST',
            body: formData
        }).then(response => {
            console.log('Subida completada');
            llamar("../gestionImagenUsuario");
        }).catch(error => {
            console.error('Error en la subida:', error);
            // Aquí puedes manejar los errores de la solicitud
        });
    } else {
        console.log('No se seleccionó ningún archivo');
    }
});


// Boton para eliminar
basura.addEventListener('click', function (event) {
    console.log("hola");
    var imgform = document.getElementById('imgform');
    var imgf = imgform.value;
    if (imgf.trim() != '') {
        let scr = sessionStorage.getItem('dir');
        fetch('../EliminarImagenes', {
            method: 'POST',
            body: scr,
        }).then(response => {
            console.log('eliminado');
            llamar("../gestionImagenUsuario");
        }).catch(error => {
            console.error('Error en la subida:', error);

        });
    }
});

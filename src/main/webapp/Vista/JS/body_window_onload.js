 // Script que gestiona el resaltado de los enlaces en la barra de navegación superior según la página actual del usuario.
// Creo variables con los elementos de la barra de navegacion
var cuenta = document.getElementById('cuenta');
var ahorro = document.getElementById('ahorro');
var resumenes = document.getElementById('resumenes');
var configuracion = document.getElementById('Cabecera_derecha_li');

// Al cargar la pagina, pregunto por el titulo de la misma y dependiendo de cual sea, modifico el estilo de ese elemento. 
window.onload = function() {
    if (document.title == "Index"){
        cuenta.style.opacity = "100%";
        cuenta.style.backgroundColor = "#0cc2f9";
        cuenta.style.borderRadius = "10px 10px 0 0"
        cuenta.style.cursor = "none";
    }else if (document.title == "ahorro"){
        ahorro.style.opacity = "100%";
        ahorro.style.backgroundColor = "#0cc2f9";
        ahorro.style.borderRadius = "10px 10px 0 0"
        ahorro.style.cursor = "none";
        
    }else if (document.title == "resumenes"){
        resumenes.style.opacity = "100%";
        resumenes.style.backgroundColor = "#0cc2f9";
        resumenes.style.borderRadius = "10px 10px 0 0"
        resumenes.style.cursor = "none";

    }else {
        configuracion.style.opacity = "100%";
        configuracion.style.backgroundColor = "#0cc2f9";
        configuracion.style.borderRadius = "10px 10px 0 0"
        configuracion.style.cursor = "none";

    }
}

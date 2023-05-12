var boton_add = document.getElementById("naz_boton_add");
var move = document.getElementById("contenedor_fondo_registro_id");
var form_record = document.getElementById("form_add_records");
var reg_dinamicos = document.getElementById("contenedor_registros_dinamicos");


var activado = 0; // Variable para determinar si esta activado o no el boton

 // Obtiene los elementos de entrada de categoria y subcategoria
    // La siguiente linea obtiene el texto de la opción seleccionada en la categoría
    var categoriaInput = document.getElementById('cr_categoria');
    var categoria = categoriaInput.options[categoriaInput.selectedIndex].text;
    var subcategoriaInput = document.getElementById('cr_subcategoria');
    var subcategoria = subcategoriaInput.options[subcategoriaInput.selectedIndex].text;

// Boton añadir +
boton_add.addEventListener('click', function (event) {
    // alert("Texto de la advertencia");
    if (activado == 0) {
        activado = 1;
        move.style.transition = 'transform 1.0s';
        move.style.transform = 'translate(0, 0)';

        reg_dinamicos.style.transition = 'transform 1s ';
        reg_dinamicos.style.transform = 'translate(0, 0)';
        boton_add.style.backgroundColor = "#1A83BA";
        move.style.opacity = '1';
        move.style.pointerEvents = "auto";

    } else {
        activado = 0;
        move.style.transition = 'transform 1.55s';
        move.style.transform = 'translate(0, -200%)';

        reg_dinamicos.style.transition = 'transform 1s ';
        reg_dinamicos.style.transform = 'translate(0, -80px)';
        boton_add.style.backgroundColor = "#38A8E4";
        
        move.style.pointerEvents = "none";
    }
});

// Función que remplaza al HOVER de CSS
boton_add.addEventListener('mouseover', function (event) {
    boton_add.style.backgroundColor = '#1A83BA';
});
boton_add.addEventListener('mouseout', function (event) {
    if (activado == 0) {
        boton_add.style.backgroundColor = '';
    }
});

// Evento que ocurre cuando cambia la opciçon de categoría
const cambiarOpcion = document.querySelector('#cr_categoria');
cambiarOpcion.addEventListener("change", function() {
    var seleccion = categoriaInput.querySelector('option[value="categoria"]');      
    if (categoria !== 'Elige una categoría') {       
        var seleccionSubcategoria = subcategoriaInput.querySelector('option[value="subcategoria"]');
        seleccionSubcategoria.textContent = "Elige";
        subcategoriaInput.style.pointerEvents = "auto";
        subcategoriaInput.style.backgroundColor = "transparent"
        subcategoriaInput.style.color = "black"
        seleccion.remove();
        alert("cosas");       
    }
});

const cambiar2 = document.querySelector('#cr_subcategoria');
cambiar2.addEventListener("change", function() {
        
    if (subcategoria !== 'Elige') {       
        var seleccion2 = subcategoriaInput.querySelector('option[value="subcategoria"]');
        seleccion2.remove();

        alert("cosas");       
    }
});





// Validación del formulario
form_record.addEventListener("submit", function (event) {
    event.preventDefault();

    // Variable que obtiene la fecha altual
    var fechaActual = new Date();

    // Obtiene los valores de fecha, concepto e importe
    var fecha = document.getElementById('cr_fecha').value;
    var fechaProcesada = new Date(fecha);    
    var concepto = document.getElementById('cr_concepto').value;
    var importe = document.getElementById('cr_importe').value;

    // Obtiene los elementos de entrada de fecha, concepto e importe
    var fechaInput = document.getElementById('cr_fecha');
    var conceptoInput = document.getElementById('cr_concepto');
    var importeInput = document.getElementById('cr_importe');

   


    

    // Obtiene los elementos de entrada de targeta(si de debito, o si de dos tipos de opciones para credito)
    // y el tipo de tarjeta que previamente a creado el usuario. 
    // La siguiente linea obtiene el texto de la opción seleccionada en la categoría
    var tipoTarjetaDebito = document.getElementById('cr_credito');
    var tipoTarjeta = tipoTarjetaDebito.options[tipoTarjetaDebito.selectedIndex].text;
    var tarjetaInput = document.getElementById('cr_tipo_tarjeta');
    var tarjeta = tarjetaInput.options[tarjetaInput.selectedIndex].text;

    
    var fechaTarjeta = document.getElementById('cr_fecha_tarjeta').value;
    var TarjetafechaProcesada = new Date(fechaTarjeta);  
    var fechaTarjetaInput = document.getElementById('cr_fecha_tarjeta');


    // alert(fechaProcesada);

    // Se evalua el input fecha
    if (fechaProcesada > fechaActual || isNaN(fechaProcesada)) {
        event.preventDefault();
        fechaInput.style.backgroundColor = 'red';
        fechaInput.style.color = 'white';
    } else {
        fechaInput.style.backgroundColor = 'transparent';
        fechaInput.style.color = 'black';
    }

    // Se evalua el input concepto
    if (concepto === '') {
        event.preventDefault();
        conceptoInput.style.backgroundColor = 'red';
        conceptoInput.style.color = 'white';        
    } else {
        conceptoInput.style.backgroundColor = 'transparent';
        conceptoInput.style.color = 'black';
    }

    // Se evalua el input importe
    if (importe === '') {
        event.preventDefault();
        importeInput.style.backgroundColor = 'red';
        importeInput.style.color = 'white';
    } else {
        importeInput.style.backgroundColor = 'transparent';
        importeInput.style.color = 'black';
    }

    // Se evalua la opción categoría
    if (categoria === 'Elige una categoría') {
        event.preventDefault();
        categoriaInput.style.backgroundColor = 'red';
        categoriaInput.style.color = 'white';
    } else {
        categoriaInput.style.backgroundColor = 'transparent';
        categoriaInput.style.color = 'black';
    }

    // Se evalua la opción subcategoría
    if (subcategoria === 'Elige' || subcategoria === 'Falta categoría' ) {
        event.preventDefault();
        subcategoriaInput.style.backgroundColor = 'red';
        subcategoriaInput.style.color = 'white';
    } else {
        subcategoriaInput.style.backgroundColor = 'transparent';
        subcategoriaInput.style.color = 'black';
    }

    // Se evalua si la opción no es credito
    if (tipoTarjeta !== 'Debito') {

        if (TarjetafechaProcesada > fechaActual || isNaN(TarjetafechaProcesada)) {            
            event.preventDefault();        
            fechaTarjetaInput.style.backgroundColor = 'red';
            fechaTarjetaInput.style.color = 'white';   
        }else{
            fechaTarjetaInput.style.backgroundColor = 'transparent';  
            fechaTarjetaInput.style.color = 'black';
        }

        // Se evalua si la opción es seleciona tarjeta
        if (tarjeta === 'Seleciona tarjeta') {
            event.preventDefault();
            tarjetaInput.style.backgroundColor = 'red';
            tarjetaInput.style.color = 'white';
        } else {
            tarjetaInput.style.backgroundColor = 'black';
            tarjetaInput.style.color = 'black';
        }
    }


});

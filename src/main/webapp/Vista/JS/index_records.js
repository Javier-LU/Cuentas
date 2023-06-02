// variables para ordenar los registros. Se inicializan en la funcion OrderBy
var fecha_up, Concepto_up, Importe_up, Saldo_up, Categoria_up, Anotaciones_up, TipoGasto_up,
    fecha_down, Concepto_down, Importe_down, Saldo_down, Categoria_down, Anotaciones_down, TipoGasto_down,
    buttonfecha, buttonConcepto, buttonImporte, buttonSaldo, buttonCategoria, buttonAnotaciones, buttonTipoGasto;
//Variables para almacenar el JSON.
var gas, cat, sub, rest, tar;
//Variables para fechas
var unoFechaInput = document.getElementById("uno_fecha");
var dosFechaInput = document.getElementById("dos_fecha");
var fechaActual = new Date();
var fechaAntigua = new Date();
var fechaActualizada1;
var fechaActualizada2;
// Variables para busqueda
const formBusqueda = document.getElementById("sp_boton_busqueda");
var aceptar = document.getElementById("rango_fechas_aceptar");
var validar;

// ╔══════════════════════════════════════════╗
// ║               Fetch inicial              ║
// ╚══════════════════════════════════════════╝

function llamar(url) {
    fetch(url)
        .then(res => res.json())
        .then(res => {

            gas = JSON.parse(res.gas)
            rest = JSON.parse(res.res);
            tar = JSON.parse(res.tar);
            console.log(gas);

            // Parseamos y asignamos los valores a las variables globales cat y sub
            // Las pongo en variables fuera de la función porque se usaran para comparar 
            // variables con su contenido.
            cat = JSON.parse(res.cat);
            sub = JSON.parse(res.sub);

            contenedor = "contenedor_registros_dinamicos";
            pintarGastos(gas, contenedor);
        })
        .catch(error => {
            console.log(error);
        });
}

// Funcion que se lanza al cargar la pagina. 
window.onload = function () {

    funcionesWindowOnload();

    fechaActualizada1 = sessionStorage.getItem('fecha1');
    fechaActualizada2 = sessionStorage.getItem('fecha2');
    key = "f1";

    actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
}


// ╔══════════════════════════════════════════╗
// ║            Pintar la web                 ║
// ╚══════════════════════════════════════════╝

// Pinta todos los registros de gastos.
function pintarGastos(datos, contenedor) {

    //Variables para realizar operaciones con fechas.
    var mes1, year1, fecha1, mes2, year2, fecha2, nombreMes;

    //Array para pintar el nombre del mes.
    const meses = [
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
        "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    ];

    // Iniciamos el pintar la web
    let htm = "";
    for (let i = 0; i < datos.length; i++) {

        // Declaro dos variables para almacenar los valores de las fechas.
        // Estas fechas se utilizarán para comparar la fecha actual con la fecha del siguiente registro.
        // Al llegar al último registro, no se recogerá ningún valor para evitar apuntar a un lugar vacío.        
        if (i < datos.length - 1) {
            fecha2 = new Date(datos[i + 1].fechaString);
            mes2 = fecha2.getMonth();
            year2 = fecha2.getFullYear();
        }

        // Inicializo la variable con la fecha del registro y calculo que año y mes es. 
        fecha1 = new Date(datos[i].fechaString);
        mes1 = fecha1.getMonth();
        year1 = fecha1.getFullYear();
        nombreMes = meses[mes2];


        // Pinto el div del año si se cumple la condición
        if (year1 != year2 || i == 0) {
            htm += `   <div class="contenedor_fondo_registro mes1">
         <div class="contenedor_registro year">
           <div class ="mes3">
             <label>${year2}</label>
           </div>
         </div>
       </div>`
        }

        // Añado el primer div con el mes. Los divs de los meses se añaden al final.
        if (i == 0) {
            htm += `   <div class="contenedor_fondo_registro mes1">
         <div class="contenedor_registro mes2">
           <div class ="mes3">
             <label>${nombreMes}</label>
           </div>
         </div>
       </div>`
        }

        // Pinto los registros de gastos. 
        htm += `<div class="contenedor_fondo_registro">
               <div id="R_${datos[i].ID}" class="contenedor_registro" style="background-color: ${datos[i].color}">
                 <input type="date" class="input registro_fecha" name="date" value="${datos[i].fechaString}">
                 <input type="text" class="input registro_concepto" name="concepto" value="${datos[i].concepto}">
                 <input type="number" class="input registro_importe" name="importe" value="${datos[i].importe}">
                 <input type="number" class="input registro_saldo" name="saldo" value="${datos[i].saldo}">
                 <div class="registro_imagenes">
                   <img src="${datos[i].imagen_categoria != null ? datos[i].imagen_categoria : 'Photos/Iconos_aplicacion/Interrogante.png'}" alt="Categoría_${datos[i].ID}">
                   <img src="${datos[i].imagen_subcategoria != null ? datos[i].imagen_subcategoria : 'Photos/Iconos_aplicacion/Interrogante.png'}" alt="Subcategoría_${datos[i].ID}">
                 </div>
                 <select class="input registro_categoria" name="categoria">
                   <option value="1">${datos[i].nombre_categoria != null && datos[i].nombre_categoria !== undefined ? datos[i].nombre_categoria : 'Elige'}</option>
                 </select>
                 <select class="input registro_subcategoria" name="subcategoria">  
                   <option value="${datos[i].IdSub + "_" + datos[i].IdCatSub}">${datos[i].nombre_subcategoria != null && datos[i].nombre_subcategoria !== undefined ? datos[i].nombre_subcategoria : 'Elige'}</option>
                 </select>
                 <textarea class="input registro_anotaciones" name="Anotaciones">${datos[i].anotaciones != null ? datos[i].anotaciones : ''}</textarea>
                 <div class="contenedor_tipo_tarjeta2">
                   <div class="contenedor_Tarjeta1">
                     <select class="input registro_tar" name="credito">
                       <option value="1">Debito</option>
                       <option value="2">C.Total. Credito de gasto acumulado</option>
                       <option value="3">C.General. Credito de gasto pendiente.</option>
                     </select>
                     <input type="date" class="input registro_tarjeta_fecha" name="fecha_tarjeta" value="${datos[i].fechaTarjetaString}">
                   </div>
                   <div>
                     <select class="input registro_tarjeta_tipo" name="tipo_tarjeta">
                       <option value="1">${datos[i].nombreTarjeta}</option>
                     </select>
                   </div>
                 </div>
               </div>           
             </div>`;

        // Pinto el div de los meses si se cumple la condición
        if (mes1 != mes2) {

            htm += `   <div class="contenedor_fondo_registro mes1">
         <div class="contenedor_registro mes2">
           <div class ="mes3">
             <label>${nombreMes}</label>
           </div>
         </div>
       </div>`
        }
    }

    // Creo el elemnto.
    document.getElementById(contenedor).innerHTML = htm;

    // Inicializo la función
    validar = document.querySelectorAll('.input');
    ValidarInput();
};


// ╔══════════════════════════════════════════╗
// ║               Envio                      ║
// ╚══════════════════════════════════════════╝

// Función utilizada para enviar datos mediante el método POST.
// Esta función se utiliza para las actualizaciones de los inputs.
// Solo se requieren 3 datos: el ID del elemento, una clave que se utilizará en el servidor y el dato a enviar.
function update(id, key, dateUpdate) {
    // Creamos un objeto FormData para enviar los datos del formulario
    var formData = new FormData();

    formData.append('id', id);
    formData.append('llave', key);
    formData.append('dateUpdate', dateUpdate);

    // Enviamos la petición POST utilizando la función fetch
    fetch('../GestionGastosDoSertUpdate', {
        method: 'POST',
        body: formData,
    }).then(response => {
        console.log('Conseguido');
    }).catch(error => {
        console.error('Error en la subida:', error);
    });
};

// Función para realizar búsquedas, ordenar registros o especificar un rango de fechas.
// Esta función está diseñada para trabajar con un diseño en el que se muestran registros dentro de un rango de fechas en lugar de mostrar todos los registros automáticamente.
// Requiere 3 datos: dos para el rango de fechas y uno para realizar operaciones específicas en el servidor basadas en la clave (key) enviada.
function actualizarRegistros(fecha1, fecha2, key) {
    // Creamos un objeto FormData para enviar los datos del formulario
    var formData = new FormData();
    formData.append('fecha1', fecha1);
    formData.append('fecha2', fecha2);
    formData.append('nose', key);

    // Enviar los datos al servidor y ejecutar la búsqueda u operación correspondiente.
    // Luego, llamar al servidor para actualizar la página web según los resultados obtenidos.
    fetch('../GestionGastosDoSetOrderBy', {
        method: 'POST',
        body: formData,
    }).then(response => {
        console.log('Conseguido');
        llamar("../GestionGastosDoGet");
    }).catch(error => {
        console.error('Error en la subida:', error);
    });

};



// ╔══════════════════════════════════════════╗
// ║      Botones y Event Listener            ║
// ╚══════════════════════════════════════════╝

// Funcion de escucha para el formulario de busqueda. 
formBusqueda.addEventListener('click', function () {
    event.preventDefault();
    // Lanzo la función para actualizar las fechas.
    actualizacionFechas();
    // Variables 
    var formBusquedaInput, valor, comp;

    // Cojo el valor del input del documento. 
    formBusquedaInput = document.getElementById("sp_busqueda");
    valor = formBusquedaInput.value;

    // Valido si tiene la longitud adecuada.
    // Estoy utilizando el key con una longitud de 2 para hacer comprobaciones en el servidor.
    // Si envío un key de 2 o de 1 podría dar error.
    comp = parseInt(valor.length, 10);
    console.log(comp);
    if (comp < 3) {
        formBusquedaInput.style.backgroundColor = "red";
    } else {
        formBusquedaInput.style.backgroundColor = "white";

        //Envio los datos.
        key = valor;
        actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
    }
});


// Función para el submit de aceptar del formulario de rango de fechas.
// La comprovación se realiza en otro js y por ello la  utilización de fechaActualizada1 y fechaActualizada2.
// La demora de ejecución la plantee, porque como la validación se realiza en otro  script, para que de tiempo a que
// haga los cambios y ejecute esto sin problemas
aceptar.addEventListener("submit", function (event) {
    setTimeout(function () {
        fechaActualizada1 = sessionStorage.getItem('fecha1');
        fechaActualizada2 = sessionStorage.getItem('fecha2');
        // Pinta la web. 
        key = "f1";
        actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
    }, 100);
});


// ╔══════════════════════════════════════════╗
// ║            Validaciones                  ║
// ╚══════════════════════════════════════════╝


// Función para verificar si la entrada del usuario es idéntica a los datos existentes. Si hay alguna discrepancia, la función  se procesa.
// Funciona con un addEventListener 'click' y un addEventListener 'blur'. Necesitamos comparar los datos de entrada con los de al perder el foco el input.
function ValidarInput() {

    // Se obtienen todos los elementos a validar
    const divs = validar;

    // Variables 
    let valorInicial, valorActual, nombreSub, imputSubImg, impID, colorSub, catSub, nombreInput,
        date, key, id, padre, hijos, textoOption, textoValue, nuevoOption, opcionSeleccionada, hermanoPosterior, hermanoHijo, hermanoAnterior, hermanoAnterior2,
        cadena;
    let Key = 0;


    // Se itera sobre cada elemento en 'divs'
    divs.forEach(function (input) {

        // Se agrega un evento 'click' a cada elemento, para recoger los datos de entrada. 

        input.addEventListener('click', function () {
            // Se recoge los valores del input.
            valorInicial = input.value;
            nombreInput = input.name;

            // Si el nombreInput cumple esta condición entra. 
            if (nombreInput == "categoria" || nombreInput == "subcategoria") {
                // Hay divs interconectados que dependen categoría y subcategoría.
                // Aquí recojo los lo que necesito 
                hijos = input.children;
                textoOption = hijos[0].textContent;
                textoValue = hijos[0].value;
                // Necesito el id de la subcategoría. Ella esta compuesta por idCategoria_idSubcategoría por ejemplo 7_423. Solo necesito el idCategoria para poder mostrar los
                // valores que tienen el id de categoría
                cadena = textoValue.includes("_");
                if (cadena) {
                    cadena = textoValue.split("_")[0];
                    textoValue = cadena;
                    console.log("Averiguar lo que ocurre: " + textoValue);
                }
            }
            // Creo un switch dependiente de nombreInput
            switch (nombreInput) {
                case "categoria":
                    // Encuentro los div que voy a necesitar para modificar los elementos dependiendo de la elección
                    hermanoAnterior = input.previousElementSibling;
                    hermanoHijo = hermanoAnterior.children;
                    padre = input.parentNode;
                    hermanoPosterior = input.nextElementSibling;
                    // Elimino todas las opciones del menú desplegable. 
                    while (input.firstChild) {
                        input.removeChild(input.firstChild);
                    }
                    // Añado el valor que rescate al principio y lo pongo como primera opción. 
                    nuevoOption = document.createElement("option");
                    nuevoOption.value = textoValue;
                    nuevoOption.textContent = textoOption;
                    input.appendChild(nuevoOption);
                    // Pinto las opciones, salvo la que ya esta pintada
                    for (var i = 0; i < cat.length; i++) {
                        if (cat[i].nombre != textoOption) {
                            nuevoOption = document.createElement("option");
                            nuevoOption.value = cat[i].id;
                            nuevoOption.textContent = cat[i].nombre;
                            input.appendChild(nuevoOption);
                        }
                    }
                    // Añado un evento de escucha por si cambia la elección.
                    input.addEventListener('change', function () {
                        // Recojo la selección 
                        opcionSeleccionada = input.options[input.selectedIndex];
                        textoValue = opcionSeleccionada.value;
                        textoOption = opcionSeleccionada.textContent;
                        // Elimino todos los valores. 
                        while (input.firstChild) {
                            input.removeChild(input.firstChild);
                        }
                        // Solo pinto el valor seleccionado. 
                        nuevoOption = document.createElement("option");
                        nuevoOption.value = textoValue;
                        nuevoOption.textContent = textoOption;
                        input.appendChild(nuevoOption);
                        // Elimino todos los valores de la subcategoría. 
                        for (var i = 0; i < hermanoPosterior.length; i++) {
                            hermanoPosterior.options[0].remove();
                        }
                        // Pinto el valor en la subcategoría de "Elige una categoría", para forzar al usuario ha seleccionar una. 
                        nuevoOption = document.createElement("option");
                        nuevoOption.value = textoValue;
                        nuevoOption.textContent = "Elige una categoría";
                        hermanoPosterior.appendChild(nuevoOption);
                        // Busco en el json el nombre que coincida con la elección que he realizado y 
                        // cambio la imagen y el color. 
                        for (var i = 0; i < cat.length; i++) {
                            if (cat[i].nombre == textoOption) {
                                hermanoHijo[0].src = cat[i].imgString;
                                padre.style.backgroundColor = cat[i].color;
                                break;
                            }
                        }
                        //Realizo el envio.
                        key = "ca";
                        padre = input.parentNode;
                        id = padre.id;
                        update(id, key, textoValue)
                    });
                    break;

                case "subcategoria":
                    // Evaluo si no tiene datos el json relacionados con el textoValue que obtuve al hacer click. 
                    for (var i = 0; i < sub.length + 1; i++) {
                        if (sub[i].idCategoria == textoValue && i < sub.length) {
                            break;
                            // Si no tiene, mostrará vacio y finalizará la función. 
                        } else {
                            while (input.firstChild) {
                                input.removeChild(input.firstChild);
                            }
                            nuevoOption = document.createElement("option");
                            nuevoOption.value = "0";
                            nuevoOption.textContent = "Vacio";
                            input.appendChild(nuevoOption);
                            return;
                        }
                    }
                    // Recojo los elementos que necesito para hacer las operaciones necesarias. 
                    hermanoAnterior = input.previousElementSibling;
                    hermanoAnterior2 = hermanoAnterior.previousElementSibling;
                    hermanoHijo = hermanoAnterior2.children;
                    // Borro todos los elementos. 
                    while (input.firstChild) {
                        input.removeChild(input.firstChild);
                    }
                    // Si el elemento es diferente a  Elige una categoría
                    if (textoOption != "Elige una categoría") {
                        nuevoOption = document.createElement("option");
                        nuevoOption.value = textoValue;
                        nuevoOption.textContent = textoOption;
                        input.appendChild(nuevoOption);
                    }
                    // Creo las opciones
                    for (var i = 0; i < sub.length; i++) {
                        if (sub[i].idCategoria == textoValue) {
                            nuevoOption = document.createElement("option");
                            nuevoOption.value = textoValue + "_" + sub[i].id;
                            nuevoOption.textContent = sub[i].nombre;
                            input.appendChild(nuevoOption);
                        }
                    }
                    // Añado un evento de escucha por si cambia la elección.
                    input.addEventListener('change', function () {
                        opcionSeleccionada = input.options[input.selectedIndex];
                        textoValue = opcionSeleccionada.value;
                        textoOption = opcionSeleccionada.textContent;
                        // Elimino todas las opciones
                        while (input.firstChild) {
                            input.removeChild(input.firstChild);
                        }
                        // Creo la opción con el elemento seleccionado. 
                        nuevoOption = document.createElement("option");
                        nuevoOption.value = textoValue;
                        nuevoOption.textContent = textoOption;
                        input.appendChild(nuevoOption);
                        // Cambio la imagen
                        for (var i = 0; i < sub.length; i++) {
                            if (sub[i].nombre == textoOption) {
                                hermanoHijo[1].src = sub[i].img;
                                textoValue = sub[i].id;
                                break;
                            }
                            // Realizo el envio. 
                            padre = input.parentNode;
                            id = padre.id;
                            key = "su";
                            update(id, key, textoValue)
                        }
                    });
                    break;
                default:
                    console.log("Nombre de input desconocido");
                    break;
            }

            // Se agrega un evento 'blur' a cada elemento. 
            // Este evento se activa cuando el elemento pierde el foco.
            input.addEventListener('blur', function () {
                // Se obtiene el valor del elemento después de perder el foco.
                valorActual = input.value;
                // Si el valor del elemento ha cambiado y no está vacío, y ninguna de las condiciones se cumple,         
                if (valorActual == valorInicial || valorActual == "") {
                    input.value = valorInicial;
                    console.log('Valores repetidos');
                    return;
                } else {
                    // Si el nuevo valor es único, se actualiza el elemento y se muestra un mensaje.
                    nombreInput = input.name;
                    date = valorActual
                    padre = input.parentNode;
                    id = padre.id;
                    // Dependiendo del nombre del input se enviará un objeto u otro. 
                    switch (nombreInput) {
                        case "date":
                            key = "da";
                            console.log(key);
                            update(id, key, date)
                            break;
                        case "concepto":
                            key = "co";
                            console.log(key);
                            update(id, key, date)
                            break;
                        case "importe":
                            key = "im";
                            console.log(key);
                            update(id, key, date)
                            break;
                        case "saldo":
                            key = "sa";
                            console.log(key);
                            update(id, key, date)
                            break;

                        case "Anotaciones":
                            key = "an";
                            console.log(key);
                            update(id, key, date)

                            break;
                        default:
                            console.log("Nombre de input desconocido");
                            break;
                    }
                }
            });
        });
    });
}


// ╔══════════════════════════════════════════╗
// ║               Miscelánea                 ║
// ╚══════════════════════════════════════════╝

// Función para actualizar estas variables. 
function actualizacionFechas() {
    fechaActualizada1 = sessionStorage.getItem('fecha1');
    fechaActualizada2 = sessionStorage.getItem('fecha2');
}


// Función que oculta o muestra los botones del titulo de la "tabla" de los gastos y repinta la web en relación a un orden determinado 
// dependiendo del botón. Este mismo codigo, sin los enviós, esta programado en index_nav_records. Lo hice al comienzo del proyecto.
// Lo utilizo en esta hoja porque necesito acceso a las funciones de pintar la web. 
function OrderBy() {


    // Se inicializan. 
    fecha_up = document.getElementById('up_Fecha');
    Concepto_up = document.getElementById('up_Concepto');
    Importe_up = document.getElementById('up_Importe');
    Saldo_up = document.getElementById('up_Saldo');
    Categoria_up = document.getElementById('up_Categoria');
    Anotaciones_up = document.getElementById('up_Anotaciones');
    TipoGasto_up = document.getElementById('up_gasto');

    fecha_down = document.getElementById('down_Fecha');
    Concepto_down = document.getElementById('down_Concepto');
    Importe_down = document.getElementById('down_Importe');
    Saldo_down = document.getElementById('down_Saldo');
    Categoria_down = document.getElementById('down_Categoria');
    Anotaciones_down = document.getElementById('down_Anotaciones');
    TipoGasto_down = document.getElementById('down_gasto');

    buttonfecha = document.getElementById('button_fecha');
    buttonConcepto = document.getElementById('button_concepto');
    buttonImporte = document.getElementById('button_importe');
    buttonSaldo = document.getElementById('button_saldo');
    buttonCategoria = document.getElementById('button_Categoria');
    buttonAnotaciones = document.getElementById('button_Anotaciones');
    buttonTipoGasto = document.getElementById('button_gasto');

    fechaActualizada1 = sessionStorage.getItem('fecha1');
    fechaActualizada2 = sessionStorage.getItem('fecha2');


    // Todos los addEventListener siguen la misma lógica. Primero se ocultan todos los botones, luego se muestran los botones correspondientes al botón que se ha pulsado.
    // Además, dependiendo de la opacidad del botón de fecha, se generará un tipo de clave y, por lo tanto, una consulta que mostrará en la página web los registros con un orden determinado.
    buttonfecha.addEventListener('click', function () {
        if (fecha_down.style.opacity <= '0') {
            fecha_down.style.opacity = "1";
            fecha_up.style.opacity = "0";
            OrderByInvisible();
        } else {
            fecha_up.style.opacity = "1";
            fecha_down.style.opacity = "0";
            OrderByInvisible();
        }
        gas.reverse();
        contenedor = "contenedor_registros_dinamicos";
        pintarGastos(gas, contenedor);
    });
    buttonConcepto.addEventListener('click', function () {
        if (Concepto_up.style.opacity <= '0') {
            OrderByInvisible();
            Concepto_up.style.opacity = "1";
            if (fecha_down.style.opacity <= '0') {
                key = "c1";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                key = "c3";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        } else {
            Concepto_down.style.opacity = "1";
            Concepto_up.style.opacity = "0";
            if (fecha_down.style.opacity <= '0') {
                key = "c2";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                key = "c4";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        }
    });
    buttonImporte.addEventListener('click', function () {

        if (Importe_up.style.opacity <= '0') {
            OrderByInvisible();
            Importe_up.style.opacity = "1";
            if (fecha_down.style.opacity <= '0') {
                console.log("up");
                key = "i1";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                key = "i3";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        } else {
            Importe_down.style.opacity = "1";
            Importe_up.style.opacity = "0";
            if (fecha_down.style.opacity <= '0') {

                key = "i2";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                console.log("down");
                key = "i4";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        }
    });
    buttonSaldo.addEventListener('click', function () {

        if (Saldo_up.style.opacity <= '0') {
            OrderByInvisible();
            Saldo_up.style.opacity = "1";
            if (fecha_down.style.opacity <= '0') {
                key = "s1";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                key = "s3";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        } else {
            Saldo_up.style.opacity = "0";
            Saldo_down.style.opacity = "1";
            if (fecha_down.style.opacity <= '0') {
                key = "s2";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                key = "s4";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        }
    });
    buttonCategoria.addEventListener('click', function () {
        if (Categoria_up.style.opacity <= '0') {
            OrderByInvisible();
            Categoria_up.style.opacity = "1";
            if (fecha_down.style.opacity <= '0') {
                key = "n1";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                key = "n3";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        } else {
            Categoria_up.style.opacity = "0";
            Categoria_down.style.opacity = "1";
            if (fecha_down.style.opacity <= '0') {
                key = "n2";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                key = "n4";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        }
    });
    buttonAnotaciones.addEventListener('click', function () {
        if (Anotaciones_up.style.opacity <= '0') {
            OrderByInvisible();
            Anotaciones_up.style.opacity = "1";
            if (fecha_down.style.opacity <= '0') {
                key = "a1";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                key = "a3";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        } else {
            Anotaciones_up.style.opacity = "0";
            Anotaciones_down.style.opacity = "1";
            if (fecha_down.style.opacity <= '0') {
                key = "a2";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            } else {
                key = "a4";
                actualizarRegistros(fechaActualizada1, fechaActualizada2, key);
            }
        }
    });
    buttonTipoGasto.addEventListener('click', function () {
        if (TipoGasto_up.style.opacity <= '0') {
            TipoGasto_up.style.opacity = "1";
            OrderByInvisible();
        } else {
            TipoGasto_up.style.opacity = "0";
        }
    });
}

// Función que oculta todos los botones
function OrderByInvisible() {
    // up       
    Concepto_up.style.opacity = "0";
    Importe_up.style.opacity = "0";
    Saldo_up.style.opacity = "0";
    Categoria_up.style.opacity = "0";
    Anotaciones_up.style.opacity = "0";
    TipoGasto_up.style.opacity = "0";
    // Down        
    Concepto_down.style.opacity = "0";
    Importe_down.style.opacity = "0";
    Saldo_down.style.opacity = "0";
    Categoria_down.style.opacity = "0";
    Anotaciones_down.style.opacity = "0";
}

// Función que almacena unas serie de funciones que son necesarias en terminados momentos o cuando se vuelve a pintar un elemento. 
function funcionesWindowOnload() {
    fechasIniciales();
    OrderBy();
    OrderByInvisible();
}

// Función para inicializar las fechas por primera vez
function fechasIniciales() {
    unoFechaInput.setAttribute("value", fechaActual.toISOString().slice(0, 10));
    sessionStorage.setItem('fecha1', fechaActual.toISOString().slice(0, 10));
    console.log("Fecha Actual: " + fechaActual)
    fechaAntigua = new Date(fechaActual.setMonth(fechaActual.getMonth() - 2));
    console.log("Fecha Actual: " + fechaAntigua)
    dosFechaInput.setAttribute("value", fechaAntigua.toISOString().slice(0, 10));
    document.getElementById("Texto_rango_Fecha2").textContent = `${fechaActual.toLocaleDateString()} - ${fechaAntigua.toLocaleDateString()} `;
    sessionStorage.setItem('fecha2', fechaAntigua.toISOString().slice(0, 10));

}
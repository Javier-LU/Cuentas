// Script para validar el formulario de rango de fecha. 

var rangofechas = document.getElementById("rango_fecha_relative");
var nav = document.getElementById("r_nav");
var boton_rangofechas = document.getElementById("nav_boton_rango_fechas");
var aceptar = document.getElementById("rango_fechas_aceptar");
// var aceptar = document.getElementById("rango_fechas_aceptar");

// Oculta o muestra el div del rango de fechas
boton_rangofechas.addEventListener("click", function () {

    if (activado == 0) {
        rangofechas.style.opacity = '1';
        rangofechas.style.pointerEvents = "auto";
        rangofechas.disabled = false;
        nav.disabled = true;        
        boton_rangofechas.style.backgroundColor = "#1A83BA";        
        activado = 1;
    } else {
        activado = 0;
        rangofechas.style.opacity = '0';
        rangofechas.style.pointerEvents = "none";
        rangofechas.disabled = true;
        nav.disabled = false;
        boton_rangofechas.style.backgroundColor = "#38A8E4";
        
    }
});
// Es un evento de escucha para ver si se ha pulsado el boton de envio. 
aceptar.addEventListener("submit", function(event) {

  event.preventDefault();
  
  var fecha1 = new Date(document.getElementById("uno_fecha").value);
  var fecha2 = new Date(document.getElementById("dos_fecha").value);
  var fechaActual = new Date();
  // Valida el envio. 
  if (fecha1 < fechaActual && fecha2 < fecha1) {
    document.getElementById("Texto_rango_Fecha2").textContent = `${fecha1.toLocaleDateString()} - ${fecha2.toLocaleDateString()} `;
    activado = 0;
    rangofechas.style.opacity = '0';
    rangofechas.style.pointerEvents = "none";
    rangofechas.disabled = true;
    nav.disabled = false;
    boton_rangofechas.style.backgroundColor = "#38A8E4";
     // Almacena las variables que se necesitarán en otra script. 
    sessionStorage.setItem('fecha1', fecha1.toISOString().slice(0, 10));
    sessionStorage.setItem('fecha2', fecha2.toISOString().slice(0, 10));

  } else {
    // Advertencia. 
    document.getElementById("Texto_rango_Fecha").textContent = "Fechas equivocadas";
  }
});

boton_rangofechas.addEventListener('mouseover', function(event) {
  boton_rangofechas.style.backgroundColor = '#1A83BA';
});
boton_rangofechas.addEventListener('mouseout', function(event) {
  if (activado == 0){
    boton_rangofechas.style.backgroundColor = '';}
});

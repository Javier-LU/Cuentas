var boton_add = document.getElementById("naz_boton_add");
var move = document.getElementById("contenedor_fondo_registro_id");
var activado = 0;
boton_add.addEventListener('click', function(event) {
    // alert("Texto de la advertencia");
    if (activado == 0){
        activado = 1;
    move.style.transition = 'transform 1s ease-in-out';
    move.style.transform = 'translate(0, 0)';
    boton_add.style.backgroundColor = "#1A83BA";

    }else {
        activado = 0;
        move.style.transition = 'transform 1s ease-in-out';
        move.style.transform = 'translate(0, -200%)';
        boton_add.style.backgroundColor = "#38A8E4";

    }

});
boton_add.addEventListener('mouseover', function(event) {
    boton_add.style.backgroundColor = '#1A83BA';
  });
  boton_add.addEventListener('mouseout', function(event) {
    if (activado == 0){
        boton_add.style.backgroundColor = '';}
  });

var elimar = document.getElementById('eliminar_usuario');
var botonElimar = document.getElementById('eliminar_aceptar');

document.getElementById("eliminarCuenta").addEventListener("click", function() {
    elimar.style.opacity = '1';
    elimar.style.pointerEvents = "auto";
    elimar.disabled = false; 
    
 });

 document.getElementById("eliminar_cancelar").addEventListener("click", function() {
    elimar.style.opacity = '0';
    elimar.style.pointerEvents = "none"; 
    elimar.disabled = true;
 });


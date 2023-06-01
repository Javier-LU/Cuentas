// Posiblemente sea una prueba o un codigo descartado. 

document.querySelector('form_add_records').addEventListener('submit', function(event) {
    var fecha = document.getElementById('cr_fecha').value;
    var concepto = document.getElementById('cr_concepto').value;
    var importe = document.getElementById('cr_importe').value;
    var saldo = document.getElementById('cr_saldo').value;
    var categoria = document.getElementById('cr_categoria').value;
    var subcategoria = document.getElementById('cr_subcategoria').value;
    var fechaTarjeta = document.getElementById('cr_fecha_tarjeta').value;

    if (fecha === '' ) {
        event.preventDefault();
        alert('Por favor, completa todos los campos');
    }
});
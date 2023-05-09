var fecha_up = document.getElementById('up_Fecha');
var Concepto_up = document.getElementById('up_Concepto');
var Importe_up = document.getElementById('up_Importe');
var Saldo_up = document.getElementById('up_Saldo');
var Categoria_up = document.getElementById('up_Categoria');
var Anotaciones_up = document.getElementById('up_Anotaciones');
var TipoGasto_up = document.getElementById('up_gasto');

var fecha_down = document.getElementById('down_Fecha');
var Concepto_down = document.getElementById('down_Concepto');
var Importe_down = document.getElementById('down_Importe');
var Saldo_down = document.getElementById('down_Saldo');
var Categoria_down = document.getElementById('down_Categoria');
var Anotaciones_down = document.getElementById('down_Anotaciones');
var TipoGasto_down = document.getElementById('down_gasto');

var buttonfecha = document.getElementById('button_fecha');
var buttonConcepto = document.getElementById('button_concepto');
var buttonImporte = document.getElementById('button_importe');
var buttonSaldo = document.getElementById('button_saldo');
var buttonCategoria = document.getElementById('button_Categoria');
var buttonAnotaciones = document.getElementById('button_Anotaciones');
var buttonTipoGasto = document.getElementById('button_gasto');


buttonfecha.addEventListener('click', function() {
    // alert('Mensaje de alerta');
   if ( fecha_down.style.opacity <= '0'){
        fecha_down.style.opacity = "1";
        fecha_up.style.opacity = "0";
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
        TipoGasto_down.style.opacity = "0";   
    } else {
        fecha_up.style.opacity = "1";
        fecha_down.style.opacity = "0";
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
        TipoGasto_down.style.opacity = "0"; 
    }    
  });

  buttonConcepto.addEventListener('click', function(){
    // alert('Mensaje de alerta');
   if ( Concepto_up.style.opacity <= '0'){
        Concepto_down.style.opacity = "0";
        Concepto_up.style.opacity = "1";
        // up
        // fecha_up.style.opacity = "0";
        Importe_up.style.opacity = "0";
        Saldo_up.style.opacity = "0";
        Categoria_up.style.opacity = "0";
        Anotaciones_up.style.opacity = "0";
        TipoGasto_up.style.opacity = "0";
        // Down
        // fecha_up.style.opacity = "0";       
        Importe_down.style.opacity = "0";
        Saldo_down.style.opacity = "0";
        Categoria_down.style.opacity = "0";
        Anotaciones_down.style.opacity = "0";
        TipoGasto_down.style.opacity = "0";
    } else {
        Concepto_up.style.opacity = "0";
        Concepto_down.style.opacity = "1";
    }
  });

  buttonImporte.addEventListener('click', function(){
    // alert('Mensaje de alerta');
    if ( Importe_up.style.opacity <= '0'){
        Importe_down.style.opacity = "0";        
        Importe_up.style.opacity = "1";
        
        // up
        // fecha_up.style.opacity = "0";
        Concepto_up.style.opacity = "0";        
        Saldo_up.style.opacity = "0";
        Categoria_up.style.opacity = "0";
        Anotaciones_up.style.opacity = "0";
        TipoGasto_up.style.opacity = "0";
        // Down
        // fecha_up.style.opacity = "0";
        Concepto_down.style.opacity = "0";       
        Saldo_down.style.opacity = "0";
        Categoria_down.style.opacity = "0";
        Anotaciones_down.style.opacity = "0";
        TipoGasto_down.style.opacity = "0";
    } else {
        Importe_down.style.opacity = "1";        
        Importe_up.style.opacity = "0";
    }
  });
 

  buttonSaldo.addEventListener('click', function(){
    // alert('Mensaje de alerta');
    if ( Saldo_up.style.opacity <= '0'){
        Saldo_up.style.opacity = "1";
        Saldo_down.style.opacity = "0";       
        // up
        // fecha_up.style.opacity = "0";
        Concepto_up.style.opacity = "0"; 
        Importe_up.style.opacity = "0";        
        Categoria_up.style.opacity = "0";
        Anotaciones_up.style.opacity = "0";
        TipoGasto_up.style.opacity = "0";
        // Down
        // fecha_up.style.opacity = "0";
        Concepto_down.style.opacity = "0"; 
        Importe_down.style.opacity = "0";       
        Categoria_down.style.opacity = "0";
        Anotaciones_down.style.opacity = "0";
        TipoGasto_down.style.opacity = "0";
    } else {
        Saldo_up.style.opacity = "0";
        Saldo_down.style.opacity = "1";  
    }
  });
  buttonCategoria.addEventListener('click', function(){
    if ( Categoria_up.style.opacity <= '0'){
        Categoria_up.style.opacity = "1";
        Categoria_down.style.opacity = "0";      
        // up
        // fecha_up.style.opacity = "0";
        Concepto_up.style.opacity = "0"; 
        Importe_up.style.opacity = "0";      
        Saldo_up.style.opacity = "0";        
        Anotaciones_up.style.opacity = "0";
        TipoGasto_up.style.opacity = "0";
        // Down
        // fecha_up.style.opacity = "0";
        Concepto_down.style.opacity = "0"; 
        Importe_down.style.opacity = "0";        
        Saldo_down.style.opacity = "0";         
        Anotaciones_down.style.opacity = "0";
        TipoGasto_down.style.opacity = "0";
    } else {
        Categoria_up.style.opacity = "0";
        Categoria_down.style.opacity = "1";     
    }
  });
  buttonAnotaciones.addEventListener('click', function(){
    // alert('Mensaje de alerta');
    if ( Anotaciones_up.style.opacity <= '0'){
        Anotaciones_up.style.opacity = "1";
        Anotaciones_down.style.opacity = "0";
        // up
        // fecha_up.style.opacity = "0";
        Concepto_up.style.opacity = "0"; 
        Importe_up.style.opacity = "0";      
        Saldo_up.style.opacity = "0";
        Categoria_up.style.opacity = "0";        
        TipoGasto_up.style.opacity = "0";
        // Down
        // fecha_up.style.opacity = "0";
        Concepto_down.style.opacity = "0"; 
        Importe_down.style.opacity = "0";        
        Saldo_down.style.opacity = "0"; 
        Categoria_down.style.opacity = "0";         
        TipoGasto_down.style.opacity = "0";
    } else {
        Anotaciones_up.style.opacity = "0";
        Anotaciones_down.style.opacity = "1";  
    }
  });
  buttonTipoGasto.addEventListener('click', function(){
    // alert('Mensaje de alerta');
    if ( TipoGasto_up.style.opacity <= '0'){
        TipoGasto_up.style.opacity = "1";
        
        // up
        fecha_up.style.opacity = "0";
        Concepto_up.style.opacity = "0"; 
        Importe_up.style.opacity = "0";      
        Saldo_up.style.opacity = "0";
        Categoria_up.style.opacity = "0";
        Anotaciones_up.style.opacity = "0";        
        // Down
        fecha_up.style.opacity = "0";
        Concepto_down.style.opacity = "0"; 
        Importe_down.style.opacity = "0";        
        Saldo_down.style.opacity = "0"; 
        Categoria_down.style.opacity = "0"; 
        Anotaciones_down.style.opacity = "0";        
    } else {
        TipoGasto_up.style.opacity = "0";  
    }
  });
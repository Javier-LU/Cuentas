// Script que gestiona el despliegue del menu emergente del boton usuario. 

var boton = document.getElementById('boton_usuarios');
var contenedor = document.getElementById('CD_boton');
var despliegue = document.getElementById('boton_usuarios_despliege');

// Este evento listener controla la aparición y desaparición del menú emergente del botón de usuario. Si se hace clic en el botón, el menú emergente aparecerá si estaba oculto, y viceversa. Esto se realiza comprobando la opacidad del botón.
document.getElementById("boton_usuarios").addEventListener("click", function() {
    if (boton.style.opacity == '1') {
        boton.style.opacity = "0.6";
        contenedor.style.backgroundColor = "";
        despliegue.style.opacity = "0";
        despliegue.style.pointerEvents = "none";
      } else {
        boton.style.opacity = "1";
        contenedor.style.backgroundColor = "#0cc2f9";
        despliegue.style.opacity = "1";
        despliegue.style.pointerEvents = "auto";        
      }   
  });

  // Si el usuario deja de tener el foco de atención en este menu, desaparece. 
  despliegue.addEventListener("mouseleave", function() {
    boton.style.opacity = "0.6";
    contenedor.style.backgroundColor = "";
    despliegue.style.opacity = "0";
    despliegue.style.pointerEvents = "none";
  });


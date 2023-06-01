var r = document.querySelector(':root');
const color = document.getElementById('submit');
var texto = document.getElementById('cambiarTexto');
//var texto = document.querySelector('#cambiarTexto');
var text = texto.textContent;

var text1 = "Usuario no encontrado";
var text2 = "contraseña incorrecta";

// ╔══════════════════════════════════════════╗
// ║   Animación de eliminar y poner texto    ║
// ╚══════════════════════════════════════════╝

function cambiarColor(dato1, dato2, dato3) {
  for (let i = 1; i < dato2.length + 1; i++) {
    var newText = "";
    setTimeout(function () {
      newText = dato2.slice(0, -i);      
      dato1.textContent = newText;   
      if (i === dato2.length) {
        dato1.style.color = 'red';
        for (let j = 0; j < dato3.length; j++) {
          setTimeout(function () {
            newText += dato3[j];
            dato1.textContent = newText;
          }, j * 50);
        }
      }
    }, i * 50);
  }
  text= dato3
}

color.addEventListener('click', function () {
  if (text != text1 && text != text2) {    
    cambiarColor(texto, text, text1);    
  }
  r.style.setProperty('--color-1', '#ff0000');
  r.style.setProperty('--color-2', '#630606');
});
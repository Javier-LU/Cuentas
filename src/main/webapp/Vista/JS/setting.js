
    // Tipo de imagen
    const basura = document.getElementById('basura');
    var formImg = document.getElementById('formImg');
    const fileInput = document.getElementById('file');
    // Boton imagen usuario 
    var usuarioImg = document.getElementById("usuarioImg");
    // Variables del grupo A
    var VacioInvisible = document.getElementById("VacioInvisible");
    var ColorInvisible = document.getElementById("ColorInvisible");
    var SubcategoriaInvisible = document.getElementById("SubcategoriaInvisible");
    var CategoriaInvisible = document.getElementById("CategoriaInvisible");
    var AvatarInvisible = document.getElementById("AvatarInvisible");
    var masImagen = document.getElementById("masImagen");
    // variables del grupo B
    var bottonGurpoB = document.getElementById("bottonGurpoB");
    var RestriccionesContenedor = document.getElementById("RestriccionesContenedor");
    var TarjetaContenedor = document.getElementById("TarjetaContenedor");

    // Variables Json
    var sub = "";
    var cat = "";
    var color;

    //Variables from
    var formSub;

    // Variables para que funcione la selección 
    var pintarColores;
    var imagenesSeleccionar;
    var marcarCatSub;
    var marcarCatSubTex;
    var BotonImagenCatSub;
    var icono;
    var gotaB;
    var validar;

    //variables
    var numeroTexto;
    var numero;
    var valorAlmacenado;
    var primerElementoColor;
    var formulario


    // ╔══════════════════════════════════════════╗
    // ║               Fetch inicial              ║
    // ╚══════════════════════════════════════════╝

    // He necesitado crear esta función para solventar un error al cambiar de color y volver a pintar los elementos. 
    function actualizarJsonCatSub(res) {
      cat = JSON.parse(res.cat);
      sub = JSON.parse(res.sub);
      inicializar();
    }

    // Solo pinta las subcategorías
    function pintarSoloSub(res) {
      cat = JSON.parse(res.cat);
      sub = JSON.parse(res.sub);
      inicializar();
      // Las subcategoría depende de la categoría en una clave foranea. 
      // Para pintarlo necesito saber cual es la calve del la categoría y su color. 
      var caolor;
      var id = sessionStorage.getItem('id_cat');
      id = parseInt(id.replace(/\s/g, ''), 10);
      for (var i = 0; i < cat.length; i++) {
        if (cat[i].id === id) {
          color = cat[i].color;
        }
      }
      local = "subcategoria";
      pintarSub(sub, color, local, id);
    }

    // Cuando se modifican las categorías es necesario volver a pintarlas. 
    // Esto pinta categorías y subcategorías. 
    function pintarSoloSubCat(res) {
      cat = JSON.parse(res.cat);
      sub = JSON.parse(res.sub);
      inicializar();
      local = "categoria";
      pintarCat(cat, local)

      // Las subcategoría depende de la categoría en una clave foranea. 
      // Para pintarlo necesito saber cual es la calve del la categoría y su color. 
      var caolor;
      var id = sessionStorage.getItem('id_cat');
      id = parseInt(id.replace(/\s/g, ''), 10);
      for (var i = 0; i < cat.length; i++) {
        if (cat[i].id === id) {
          color = cat[i].color;
        }
      }
      local = "subcategoria";
      pintarSub(sub, color, local, id);
    }

    // Solo pinta las imagenes. 
    function pinterImagenes(res) {
      // Las variables
      const imgLogin = JSON.parse(res.imgLogin);
      const imgCat = JSON.parse(res.imgCat);
      const imgSub = JSON.parse(res.imgSub);
      let local, primerElementoColor, color, numeroTexto, numero, valorAlmacenado;

      // Pintamos las imagenes del usuario
      local = "imgAvatar";
      pintar(imgLogin, local);

      // Pintamos las imagenes de categorías
      local = "wrapModificar";
      pintar(imgCat, local);

      // Pintamos las imagenes de subcategorías
      local = "imgSubcagetoría";
      pintar(imgSub, local);

      // Llamamos a las funciones para iniciarlas
      inicializar();
      selecionarImagen();
      botonImagen();
    }

    // Funcion para pintar toda la pagina.
    function pinterTodo(res) {
      // Las variables
      const imgLogin = JSON.parse(res.imgLogin);
      const imgCat = JSON.parse(res.imgCat);
      const imgSub = JSON.parse(res.imgSub);
      const rest = JSON.parse(res.res);
      const tar = JSON.parse(res.tar);
      let local, primerElementoColor, color, numeroTexto, numero, valorAlmacenado;

      // Parseamos y asignamos los valores a las variables globales cat y sub
      // Las pongo en variables fuera de la función porque se usaran para comparar 
      // variables con su contenido.
      cat = JSON.parse(res.cat);
      sub = JSON.parse(res.sub);

      // Pintamos las imagenes del usuario
      local = "imgAvatar";
      pintar(imgLogin, local);

      // Pintamos las imagenes de categorías
      local = "wrapModificar";
      pintar(imgCat, local);

      // Pintamos las imagenes de subcategorías
      local = "imgSubcagetoría";
      pintar(imgSub, local);

      // Pintamos los valores de la subcategoría
      // Las subcategoría depende de la categoría en una clave foranea. 
      // Para pintarlo necesito saber cual es la calve del la categoría y su color. 
      // Como es la primera vez que se pinta. Los valores iniciales hacen referencia al primer elemento de categorías
      primerElementoColor = cat[0];
      color = primerElementoColor.color;
      numeroTexto = sessionStorage.getItem('id_cat');
      numero = parseInt(numeroTexto, 10);
      valorAlmacenado = numero;
      local = "subcategoria";
      pintarSub(sub, color, local, valorAlmacenado);

      // Pintamos los valores de la categoría
      local = "categoria";
      pintarCat(cat, local)

      // Pintamos restricciones
      local = "tabla";
      pintarRes(rest, local)

      // Pintamos tarjeta
      local = "tabla_tarjeta";
      pintarTar(tar, local)

      // Llamamos a las funciones para iniciarlas
      inicializar();
      selecionarColores(pintarColores);
      selecionarImagen();
      marcarCategorias();
      botonImagen();
      botonGota();
      ValidarInput();
      botonBasura();
      ValidarForm();
    }

    // ---------------------------------------------------------------------------------------

    // He considerado que una forma de optimizar sería que cuando tuviese que volver a pintar una página, 
    // se pinte solo la sección necesaria en lugar de renderizar toda la página nuevamente. 
    // Por ello, se utiliza una estructura switch para lograr esta optimización.
    function llamar(url, key) {
      fetch(url)
        .then(res => res.json())
        .then(res => {
          switch (key) {
            case 0:
              // Solo actualiza los json de cat y sub
              actualizarJsonCatSub(res);
              break;
            case 1:
              // Pinta subcategorías
              pintarSoloSub(res);
              break;
            case 2:
              // Pinta categorías
              pintarSoloSubCat(res);
              break;
            case 3:
              // Pinta imagenes
              pinterImagenes(res);
              break;
            case 4:
              // Pinta todo
              pinterTodo(res);
              break;
            default:
              console.log("Opción inválida");
              break;
          }
        })
        .catch(error => {
          console.log(error);
        });
    }

    // Funcion que se lanza al cargar la pagina. 
    window.onload = function () {
      // Al cargar la pagina necesitamos ocultar algunos divs
      TarjetaContenedor.style.display = "none";
      TarjetaContenedor.style.pointerEvents = "none";
      masImagen.style.opacity = 0;
      masImagen.style.pointerEvents = "none";
      VacioInvisible.style.display = "block";
      VacioInvisible.style.pointerEvents = "auto";
      sessionStorage.setItem('id_cat', "1");
      // El valor 4 pinta toda la pagina.
      var Key = 4;
      llamar("../GestionConfiguracion", Key);
    }



    // ╔══════════════════════════════════════════╗
    // ║           Reiniciar funciones            ║
    // ╚══════════════════════════════════════════╝

    // Cuando se repintan las categorías y subcategorías se debe de reiniciar ciertas funciones
    function inicializarFunciones() {
      marcarCategorias();
      botonImagen();
      botonBasura();
      botonGota()

    }
    // Esta función se emplea cuando es necesario actualizar las variables con los nuevos datos una ver repintado zonas de la web 
    function inicializar() {
      validar = document.querySelectorAll('.validadInput');
      marcarCatSub = document.querySelectorAll('.contendorCategoria');
      marcarCatSubTex = document.querySelectorAll('.contenedorTexto');
      BasuraCat = document.querySelectorAll('.botonBasura');
      gotaB = document.querySelectorAll('.botonGota');
      BotonImagenCatSub = document.querySelectorAll('.icono');
      imagenesSeleccionar = document.querySelectorAll('.contenedorImagen');
      pintarColores = document.querySelectorAll('.div-pastel');
      iconoCoger = document.querySelectorAll('.icono');
    }



    // ╔══════════════════════════════════════════╗
    // ║            Pintar la web                 ║
    // ╚══════════════════════════════════════════╝

    // Pintar Categorías      pinta las categorías. A esta función se le llamará en varias ocasiones
    function pintarCat(datos, contenedor) {
      let htm = "";
      for (let i = 0; i < datos.length; i++) {
        htm += `<div id="C_${datos[i].id}" class="contendorCategoria">
              <div class="contenedorIconoText" style="background-color: ${datos[i].color}">
                <img class="icono" src="${datos[i].imgString}" alt="basura">
                <div class="contenedorTexto">
                    <input class="validadInput" type="text" value="${datos[i].nombre}">
                </div>
              </div>
              <div class="contenedorBasuraGota">
                <button class="gota">
                  <img class="gotaImg botonGota" src="Photos/Iconos_aplicacion/Blancos/Negativo/gota.png" alt="Color">
                </button>
                <button class="gota">
                  <img class="gotaImg botonBasura" src="Photos/Iconos_aplicacion/Blancos/Negativo/basura.png" alt="Usuario">
                </button>
              </div>
            </div>`;
      }
      // Crea el formulario para añadir un elemento
      htm += `<form id="P"  class="contendorCategoria validadInput" action="../GestionConfiguracion" method="POST">
                <div id="cambiarColorForm" class="contenedorIconoText" style="background-color: #e4e4e4">
                    <img class="icono" src="Photos/Iconos_aplicacion/XX - copia.png" alt="formulario">
                    <div class="contenedorTexto">
                        <input id ="nombreCat" class="validadInput" type="text" name="subcategoria" value="">
                        <input id ="imputCAtImg" class="imputInvisible" type="text" name="imagenSub" value="">
                        <input id ="impIDCat" class="imputInvisible" type="text" name="IDCat" value="">
                        
                    </div>
                </div>
                <div class="contenedorBasuraGota adpatacionGota">
                <button class="gota">
                  <img class="gotaImg botonGota" src="Photos/Iconos_aplicacion/Blancos/Negativo/gota.png" alt="Color">
                </button>
              </div>
                <div class="ContenedorSubmit">

                  <input id="submitFromCat" type="submit" value="+" class="imputMasText">                                     
                </div>
            </form>`;
      document.getElementById(contenedor).innerHTML = htm;
      // Al llamar esta función, cambiar sus elementos y por tanto se deben de actualizar las funciones y los valores. 
      inicializar();
      inicializarFunciones();
    }

    // Pintar Subcategorías   pinta las subcategorías. A esta función se le llamará en varias ocasiones
    function pintarSub(datos, color, contenedor, id) {
      let htm = "";
      for (let i = 0; i < datos.length; i++) {
        if (datos[i].idCategoria === id) {
          htm += `<div id="S_${datos[i].id}" class="contendorCategoria">
              <div class="contenedorIconoText" style="background-color: ${color}">
                <img id="iconoIdImg" class="icono" src="${datos[i].img}" alt="basura">
                <div class="contenedorTexto">
                    <input class="validadInput" type="text" value="${datos[i].nombre}">
                </div>
              </div>
              <div class="contenedorBasuraGota">
                <button class="gota basuraAdaptacion">
                  <img class="gotaImg botonBasura" src="Photos/Iconos_aplicacion/Blancos/Negativo/basura.png" alt="Usuario">
                </button>
              </div>
            </div>`;
        }
      }
      // Crea el formulario para añadir un elemento
      htm += `<form id="X" class="contendorCategoria validadInput" action="../GestionConfiguracion" method="POST">
                <div class="contenedorIconoText" style="background-color: ${color}">
                    <img class="icono" src="Photos/Iconos_aplicacion/XX.png" alt="formulario">
                    <div class="contenedorTexto">
                        <input id ="nombreSub" class="validadInput" type="text" name="subcategoria" value="">
                        <input id ="imputSubImg" class="imputInvisible" type="text" name="imagenSub" value="">
                        <input id ="impID" class="imputInvisible" type="text" name="IDCat" value="1">
                        
                    </div>
                </div>
                <div class="contenedorBasuraGota imputMas  ">
                  <input id="submitFromSub" type="submit" value="+" class="imputMasText">                                     
                </div>
            </form>`;

      document.getElementById(contenedor).innerHTML = htm;
      // Al llamar esta función, cambiar sus elementos y por tanto se deben de actualizar las funciones y los valores. 
      inicializar();
      inicializarFunciones();
      ValidarForm();
    }

    // Pintar Restricciones   pinta los resultados de las restricciones
    function pintarRes(datos, contenedor) {
      let htm = `<table>
                      <tr>
                          <th>Eliminar</th>
                          <th>Concepto</th>
                          <th>Categoría</th>
                          <th>Subcategoría</th>
                       </tr>`;
      for (let i = 0; i < datos.length; i++) {
        htm += `<tr id="R_${datos[i].id}">
                    <td><img class="gotaImg" src="Photos/Iconos_aplicacion/Blancos/Negativo/basura.png" alt="Usuario">
                    </td>
                    <td>${datos[i].concepto}</td>
                    <td>${datos[i].categoria}</td>
                    <td>${datos[i].subcategoria}</td>
                  </tr>`;
      }
      htm += `</table>`;
      document.getElementById(contenedor).innerHTML = htm;
    }

    // Pintar Tarjeta:        pinta los resultados de la base de datos de tarjeta.
    function pintarTar(datos, contenedor) {
      let htm = `<table>
                      <tr>
                          <th>Eliminar </th>
                          <th>Nombre</th>
                          <th>Vencimiento</th>
                          <th>Limite</th>
                          <th>Descripción</th>
                       </tr>`;
      for (let i = 0; i < datos.length; i++) {
        htm += `<tr id="T_${datos[i].id}">
                    <td><img class="gotaImg" src="Photos/Iconos_aplicacion/Blancos/Negativo/basura.png" alt="Usuario"></td>
                    <td><input type="text" name="Tarjeta_nombre" value="${datos[i].nombre}"></td>
                    <td><input type="date" name="Tarjeta_vencimiento" value="${datos[i].vencimiento}"></td>
                    <td><input type="number" name="Tarjeta_limite" value="${datos[i].limite}"></td>
                    <td><input type="text" name="Tarjeta_descripcion" value="${datos[i].descripcion}"></td>                  
              </tr>`;
      }
      htm += `</table>`;
      document.getElementById(contenedor).innerHTML = htm;
    }

    // Pintar imágenes:       pinta todas las imágenes de los divs que servirán para cambiar los iconos   
    function pintar(datos, contenedor) {
      let htm = "";
      for (i = 0; i < datos.length; i++) {
        htm += "<div id=L_'" + datos[i].id + "' class='contenedorImagen'><img src='" + datos[i].img + "'></div>";
      }
      document.getElementById(contenedor).innerHTML = htm;
    }



    // ╔════════════════════════════════════════════════════════════════╗
    // ║    Funciones para dejar marcado las eleciones del usuario      ║
    // ╚════════════════════════════════════════════════════════════════╝

    // Marca los colores        y actualiza la base de datos con la nueva elección. 
    function selecionarColores(dato) {
      // Agrupacion de variables      
      const divs = dato;
      var cambiarColorForm, impIDCat, padre, hijo, cat, nombre, id_imagen, catID;

      // Para cada div en nuestra lista de divs
      divs.forEach((div) => {
        // Añadimos un listener de eventos de click
        div.addEventListener('click', function () {
          // 1º Parte dejar selecionado la eleción del usuario. 
          // Por cada click, eliminamos la sombra de todos los divs
          divs.forEach((otherDiv) => {
            otherDiv.style.boxShadow = 'none';
          });
          // Luego, añadimos sombra al div que ha sido clickeado
          div.style.boxShadow = 'inset 0 0 0 4px red';

          // 2º Parte  
          // Obtenemos el color del div que ha sido clickeado
          const backgroundColor = getComputedStyle(div).backgroundColor;
          // Convertimos el color a formato hexadecimal con una función. 
          const hexColor = rgbConvert(backgroundColor);

          // Obtenemos un item del sessionStorage
          let divCat = sessionStorage.getItem('id');

          // Actualizamos el valor del campo "impIDCat" con el color hexadecimal
          impIDCat = document.getElementById("impIDCat");
          impIDCat.value = hexColor;

          // Si el item no está vacío, obtenemos el div padre y el primer div hijo
          // Esto es porque no se estaba apuntando correctamente al div. 
          padre = document.getElementById(divCat);
          hijo = padre.querySelector('div');
          // Cambiamos el color de fondo del div hijo
          hijo.style.backgroundColor = hexColor;

          // Si estamos en el formulario para crear no envia el update. 
          // Solo tiene la función de cambiar de color la categoría. 
          if (!Condicional_idP()) {
            // Obtenemos más datos del sessionStorage
            cat = sessionStorage.getItem('id');
            nombre = "";
            id_imagen = 0;
            catID = sessionStorage.getItem('id_cat');

            // Actualizamos el grupo con los datos obtenidos
            UpdateGrupoA(cat, id_imagen, nombre, hexColor, catID);

            // Pintamos de nuevo la categoría y subcategoría
            var Key = 0;
            llamar("../GestionConfiguracion", Key);
            Key = 1;
            llamar("../GestionConfiguracion", Key);
          }
        });
      });
    }

    // Marcar las imagenes:     maneja el evento de hacer clic en las imágenes de configuración, y envía las modificaciones cuando sea necesario.
    // Valida si la imagen seleccionada esta ya elegida en otro apartado. 
    function selecionarImagen() {
      // Definimos las variables que utilizaremos en la función.
      const divs = imagenesSeleccionar;
      let sesion, id_imagen, imagen, src, comparacion, formSub2, formSub, id;
      const iconoCogerArray = Array.from(iconoCoger);

      // Para cada div en la colección "divs". 
      divs.forEach(function (div) {
        // Agregamos un manejador de eventos para el evento "click" en cada div
        div.addEventListener('click', function () {
          // 1º Parte
          // Para cada div, hacemos que su fondo sea transparente
          divs.forEach(function (otherDiv) {
            otherDiv.style.backgroundColor = 'transparent';
          });
          // Cambiamos el fondo del div que fue clickeado a rojo
          div.style.backgroundColor = 'red';

          // 2º Parte  ----------------------------------------------------------
          // Obtenemos el id de la imagen y el atributo src de la imagen
          id_imagen = div.id;
          imagen = div.querySelector('img');
          src = imagen.getAttribute('src');

          // Almacenamos el src en sessionStorage y obtenemos el valor actual almacenado bajo 'dir2'
          sessionStorage.setItem('dir', src);
          comparacion = sessionStorage.getItem('dir2');

          // Obtenemos el valor actual del input cuyo nombre es "imagenSub"
          formSub2 = document.querySelectorAll('input[name="imagenSub"]');
          formSub = formSub2.value;

          // Verificamos si el src de la imagen se encuentra en el array iconoCogerArray
          // Si es asi, el update no se puede llevar a cabo y se detendrá. 
          if (iconoCogerArray.some(icono => icono.getAttribute('src') === src)) {
            div.style.backgroundColor = 'green';
            return;
          } else {
            // Si no se encuentra en iconoCogerArray, obtenemos el id almacenado en sessionStorage            
            id = sessionStorage.getItem('id');
            // Si el usuario  esta en alguno de los formularios para crear nuevos registros, entrará en la condición.
            if (Condicional_idP() || Condicional_idX()) {
              formSub2.forEach(function (element) {
                element.setAttribute('value', id_imagen);
              });
            }
            // Para cada icono en la colección "iconoCoger", comparamos su src con el valor de comparacion.
            // Si no lo esta, modificamos de parte del cliente el incono. 
            iconoCoger.forEach(function (icono) {
              const src2 = icono.getAttribute('src');
              if (src2 === comparacion) {
                sessionStorage.setItem('dir2', src);
                icono.setAttribute('src', src);
                // Si el usuario no esta en alguno de los formularios para crear nuevos registros, entrará en la condición.
                if (!Condicional_idP() && !Condicional_idX()) {
                  let cat = sessionStorage.getItem('id');
                  let nombre = "";
                  let color = "";
                  let catID = sessionStorage.getItem('id_cat');
                  UpdateGrupoA(cat, id_imagen, nombre, color, catID);
                }
              } else {
                console.log("No ha entrado");
              }
            });
          }
        });
      });
    };

    // Adaptación de marcarCategorias que la uso al selecionar una categoría y volver a pintar la zona de subcategorías.
    // No lo he revisado desde su creación. Lo cree en respuesta a un problema. 
    function marcarImagenCategorias() {
      // Variables
      const divs = marcarCatSub;
      let primeraLetra, id, restoTexto, resto, numeroTexto, valorAlmacenado, local, color;

      // Para cada div, añade un controlador de eventos de clic
      divs.forEach(function (div) {
        div.addEventListener('click', function () {
          // Para cada div, elimina la sombra y reduce la opacidad
          divs.forEach(function (otherDiv) {
            otherDiv.style.boxShadow = 'none';
            otherDiv.style.opacity = '0.4';
          });

          // Añade sombra y aumenta opacidad al div clicado
          div.style.boxShadow = "0 0 10px rgba(0, 0, 0, 0.5), 0 0 20px rgba(0, 0, 0, 0.3), 0 0 30px rgba(0, 0, 0, 0.2), 0 0 40px rgba(0, 0, 0, 0.1)";
          div.style.opacity = '1';

          // Busca el contenedor de la categoría y obtiene su id
          const contenedor = event.target.closest('.contendorCategoria');
          if (contenedor) {
            id = contenedor.id;
            primeraLetra = id.charAt(0);
          }
          sessionStorage.setItem('id', id)

          // Extrae el número de id y lo guarda en sessionStorage
          restoTexto = id.substring(2);
          resto = parseInt(restoTexto, 10);
          numeroTexto = sessionStorage.getItem('id_cat')
          valorAlmacenado = parseInt(numeroTexto, 10);

          // Si la primera letra del id es 'C', actualiza la sesión y pinta de la subcategoría
          if (primeraLetra === "C") {
            var impID = document.getElementById("impID");
            impID.setAttribute('value', restoTexto);

            if (resto != valorAlmacenado) {
              sessionStorage.setItem('id_cat', resto);
              sessionStorage.setItem('id_cat2', id);
              for (let i = 0; i < cat.length; i++) {
                if (cat[i].id === resto) {
                  color = cat[i].color;
                  break;
                }
              }
              local = "subcategoria";
              pintarSub(sub, color, local, resto);
            }
          }
        });
      });
    }

    // Marcar las categorias.     Cuando el usario seleciona una categoría y subcategoría esta función lo marca visualmente. 
    function marcarCategorias() {
      // Agrupando las variables al comienzo
      const divs = marcarCatSubTex;
      let padres, id, primeraLetra, restoTexto, resto, numeroTexto, valorAlmacenado;
      let impIDCat3, impIDCat4, local, color;

      // Bucle que recorre todos los divs
      divs.forEach((div) => {
        // Asignando un eventListener a cada div
        div.addEventListener('click', function (event) {
          // Necesito modificar el div que esta por encima del div al que apunto.
          padres = this.parentElement.parentElement;

          // Bucle que recorre de nuevo todos los  divs
          divs.forEach((otherDiv) => {
            // Si el elemento div es diferente al seleccionado se le modifica el estilo de los demas divs
            const otherPadres = otherDiv.parentElement.parentElement;
            if (otherPadres !== padres) {
              otherPadres.style.boxShadow = 'none';
              otherPadres.style.opacity = '0.4';
            }
          });

          // Modifico el estilo del elemento seleccionado
          padres.style.boxShadow = "0 0 10px rgba(0, 0, 0, 0.5), 0 0 20px rgba(0, 0, 0, 0.3), 0 0 30px rgba(0, 0, 0, 0.2), 0 0 40px rgba(0, 0, 0, 0.1)";
          padres.style.opacity = '1';

          // Buscando el contenedor más cercano con clase '.contendorCategoria'
          const contenedor = event.target.closest('.contendorCategoria');
          if (contenedor) {
            id = contenedor.id;
            primeraLetra = id.charAt(0);

          }

          restoTexto = id.substring(2);
          resto = parseInt(restoTexto, 10);
          numeroTexto = sessionStorage.getItem('id_cat')
          valorAlmacenado = parseInt(numeroTexto, 10);

          // Si la condición es verdadera, se limpia el contenido del elemento con id 'subcategoria'
          if (id === "P") {
            local = "subcategoria";
            document.getElementById(local).innerHTML = "";
          }

          // Si la primera letra del id es 'C'
          if (primeraLetra === "C") {
            if (resto != valorAlmacenado) {
              sessionStorage.setItem('id_cat', resto);
              sessionStorage.setItem('id_cat2', id);
              // Buscando el color correspondiente
              for (let i = 0; i < cat.length; i++) {
                if (cat[i].id === resto) {
                  color = cat[i].color;
                  break;
                }
              }

              local = "subcategoria";
              pintarSub(sub, color, local, resto);

              // Ocultando todos los elementos y mostrando sólo los necesarios
              ocultarTodo();

              VacioInvisible.style.display = "block";
              VacioInvisible.style.pointerEvents = "auto";
              masImagen.style.opacity = 0;
              masImagen.style.pointerEvents = "none";
            }
            // Si la primera letra del id no es 'C'
          } else if (resto != valorAlmacenado) {
            // Ocultar todos los elementos
            ocultarTodo();

            // Permitir la interacción con masImagen y cambiar su opacidad a 1
            masImagen.style.opacity = 1;
            masImagen.style.pointerEvents = "auto";

          } else {
            // En caso de que las categorías sean iguales, se envía un mensaje de consola
            console.log("Las categorías son iguales");
          }
        });
      });
    }

    // Cambiar imagen usuario   Como el usuario no es un elemento dinamico, puedo utilizar un addEventListener
    // Debido a que no voy a poder desarrollar las funcionalidades de esta parte, las describo.
    // Además de esta función de mostrar el divs con las imágenes, se necesitaría otras funciones para modificar la imagen y el texto. 
    usuarioImg.addEventListener("click", function () {

      const ImagenesDinamicas = document.querySelectorAll('.contenedorImagen');

      // Recorrer cada elemento y obtener el color de fondo
      ImagenesDinamicas.forEach((div) => {
        var imagen2 = div.querySelector('img');

        var src2 = imagen2.getAttribute('src');
        var comp = document.getElementById('usuarioImg')
        var comparacion = comp.getAttribute('src');
        if (src2 === comparacion) {
          ImagenesDinamicas.forEach((otherDiv) => {
            otherDiv.style.backgroundColor = 'transparent';
          });
          div.style.backgroundColor = 'red'; // Cambia el borde del div en caso de coincidencia
        }
      });
      // Da un valor para, si carga una imagen el usuario, tenga una categoría en la base de datos.  
      tipoImagen.value = "login";
      ocultarTodo();
      masImagen.style.opacity = 1;
      masImagen.style.pointerEvents = "auto";
      AvatarInvisible.style.display = "block";
      AvatarInvisible.style.pointerEvents = "auto";
    });



    // ╔══════════════════════════════════════════╗
    // ║            Botones                       ║
    // ╚══════════════════════════════════════════╝

    // Boton imagen:     Reacciona con todas las imagenes de los div que tienen como titulo "cambia la imagen..."
    //  Maneja la interacción del usuario con el conjunto de imágenes de cada div, marcando la imagen seleccionada 
    // y si se cumplen ciertos parametros, actualizar la imagen de la base de datos. 
    function botonImagen() {
      // Agrupamos todas las variables al comienzo de la función
      const divs = BotonImagenCatSub;
      let contenedor, src, imagen, ImagenesDinamicas, id, primeraLetra, imagen2, src2, comparacion;
      // Buscamos los elementos del DOM por su id
      let tipoImagen = document.getElementById('tipoImagen');
      let masImagen = document.getElementById('masImagen');
      let SubcategoriaInvisible = document.getElementById('SubcategoriaInvisible');
      let CategoriaInvisible = document.getElementById('CategoriaInvisible');

      // Llamamos a la función para marcar las imágenes de las categorías
      marcarImagenCategorias();

      // Para cada div en nuestra lista de divs
      divs.forEach((div) => {
        // Añadimos un listener de eventos de click
        div.addEventListener('click', (event) => {
          // Buscamos el contenedor más cercano a nuestro elemento clickeado con la clase '.contendorCategoria'
          contenedor = event.target.closest('.contendorCategoria');

          // Si encontramos dicho contenedor
          if (contenedor) {
            // Obtenemos la imagen dentro de este contenedor y el src
            imagen = contenedor.querySelector('img');
            src = imagen.getAttribute('src');

            // Guardamos este atributo 'src' en el sessionStorage que nos servira para realizar comparaciones y cambiar la imagen
            sessionStorage.setItem('dir', src);
            sessionStorage.setItem('dir2', src);

            // Buscamos todos los elementos con la clase '.contenedorImagen' y para cada uno de estos elementos...
            ImagenesDinamicas = document.querySelectorAll('.contenedorImagen');
            ImagenesDinamicas.forEach((div) => {
              // Obtenemos la imagen dentro de este div el src e inicializamos la variables comparacion
              imagen2 = div.querySelector('img');
              src2 = imagen2.getAttribute('src');
              comparacion = sessionStorage.getItem('dir');

              // Estas lineas de codigo sirven para dejar marcadas la selección de la imagen 
              if (src2 === comparacion) {
                ImagenesDinamicas.forEach((otherDiv) => {
                  otherDiv.style.backgroundColor = 'transparent';
                });
                div.style.backgroundColor = 'red';
              }
            });

            // Si se cumple la condición que la "sessionStorage id" y "sessionStorage id_cat" es igual a C.

            id = contenedor.id;
            primeraLetra = id.charAt(0);
            // Unas series de condicionales dependientes de  primeraLetra
            if (primeraLetra === "S" || Condicional_idX()) {
              // Cambiamos el valor de 'tipoImagen' a 'subcategoria'
              tipoImagen.value = "subcategoria";
              // Llamamos a la función para ocultar todos los div y cambiar sus eventos de puntero a nule
              ocultarTodo();
              // Cambiamos la opacidad y los eventos de puntero de 'masImagen' y 'SubcategoriaInvisible'
              masImagen.style.opacity = 1;
              masImagen.style.pointerEvents = "auto";
              SubcategoriaInvisible.style.display = "block";
              SubcategoriaInvisible.style.pointerEvents = "auto";
            }

            else if (primeraLetra === "C" || Condicional_idP()) {
              tipoImagen.value = "categoria";
              ocultarTodo();
              masImagen.style.opacity = 1;
              masImagen.style.pointerEvents = "auto";
              CategoriaInvisible.style.display = "block";
              CategoriaInvisible.style.pointerEvents = "auto";
            }
          }
        });
      });
    };

    // Boton gota       muestra el divs para cambiar de color y seleciona el que esta en uso. 
    function botonGota() {
      // Variables 
      const divs = gotaB;
      let id, restoTexto, resto, color, r, g, b, backgroundColor;

      // Agregando manejador de evento de clic a cada div
      divs.forEach((div) => {
        div.addEventListener('click', (event) => {
          // Haciendo visibles los elementos y desactivando los demás
          ocultarTodo();
          masImagen.style.opacity = 1;
          masImagen.style.pointerEvents = "auto";
          ColorInvisible.style.display = "block";
          ColorInvisible.style.pointerEvents = "auto";

          // Selección de color basada en el ID de la categoría
          const contenedor = event.target.closest('.contendorCategoria');
          id = contenedor.id;
          restoTexto = id.substring(2);
          resto = parseInt(restoTexto, 10);

          // Buscando el color de la categoría basado en el ID
          for (let i = 0; i < cat.length; i++) {
            if (cat[i].id === resto) {
              color = cat[i].color;
              break;
            }
          }

          // Convirtiendo el color hexadecimal a RGB
          r = parseInt(color.slice(1, 3), 16);
          g = parseInt(color.slice(3, 5), 16);
          b = parseInt(color.slice(5, 7), 16);
          color = `rgb(${r}, ${g}, ${b})`;

          // Buscando el en div del color el div con el color de fondo correspondiente y cambiando su borde
          const divPasteles = document.querySelectorAll('.div-pastel');
          divPasteles.forEach((div) => {
            backgroundColor = getComputedStyle(div).backgroundColor;
            if (backgroundColor === color) {
              divPasteles.forEach((otherDiv) => {
                otherDiv.style.boxShadow = 'none';
              });
              div.style.boxShadow = 'inset 0 0 0 4px red'; // Cambia el borde del div en caso de coincidencia
            }
          });
        });
      });
    }

    // Boton basura     de las categorías y subcategorías. Manda la solicitud a la base de datos para eliminar. 
    function botonBasura() {
      const divs = BasuraCat;

      divs.forEach((div) => {
        div.addEventListener('click', (event) => {

          var cat = sessionStorage.getItem('id');
          var img = 0;
          var nombre = "";
          var color = "";
          var idCatSinLetra = 0;

          UpdateGrupoA(cat, img, nombre, color, idCatSinLetra);
          var Key = 0;
          llamar("../GestionConfiguracion", Key);
          Key = 2;
          llamar("../GestionConfiguracion", Key);
        });
      });
    }

    // Boton grupo B    Simplemente muestra un divs u otro. 
    bottonGurpoB.addEventListener("click", function () {
      var texto = bottonGurpoB.innerText;
      if (texto === "Tarjeta") {
        bottonGurpoB.innerText = "Restricción";
        RestriccionesContenedor.style.display = "none";
        RestriccionesContenedor.style.pointerEvents = "none";
        TarjetaContenedor.style.display = "block";
        TarjetaContenedor.style.pointerEvents = "auto";
      } else {
        bottonGurpoB.innerText = "Tarjeta";
        RestriccionesContenedor.style.display = "block";
        RestriccionesContenedor.style.pointerEvents = "auto";
        TarjetaContenedor.style.display = "none";
        TarjetaContenedor.style.pointerEvents = "none";
      }

    });

    // Botones para cargar y eliminar imagenes ---------------
    // Boton para eliminar
    basura.addEventListener('click', function (event) {

      let scr = sessionStorage.getItem('dir');
      fetch('../EliminarImagenes', {
        method: 'POST',
        body: scr,
      }).then(response => {
        console.log('eliminado');
        var Key = 3;
        llamar("../GestionConfiguracion", Key);
      }).catch(error => {
        console.error('Error en la subida:', error);

      });



    });

    // ¿Ha cambiado el input de la imagen?
    file.addEventListener('change', function (event) {
      const file = fileInput.files[0];
      if (file) {
        const formData = new FormData();
        formData.append('photo', file);
        // Puedes agregar más campos al objeto formData según tus necesidades
        const tipoImagen = document.getElementById('tipoImagen').value;
        formData.append('ima', tipoImagen);

        fetch('../GestionImagenes', {
          method: 'POST',
          body: formData
        }).then(response => {
          console.log('Subida completada');
          var Key = 3;
          llamar("../GestionConfiguracion", Key);
        }).catch(error => {
          console.error('Error en la subida:', error);
          // Aquí puedes manejar los errores de la solicitud
        });
      } else {
        console.log('No se seleccionó ningún archivo');
      }
    });


    // ╔══════════════════════════════════════════╗
    // ║            Validaciones                  ║
    // ╚══════════════════════════════════════════╝

    // Tanto los registros reflejados en los divs de categoría como subcategoría los trato con el mismo codigo. Sus formularios los hago igual
    // Para enviar la información de uno o de otro pergunto por cual es su id. 
    function ValidarForm() {
      // Selecciona todos los elementos a validar
      const divs = validar;

      // Variables
      let valorInicial, valorActual, nombreSub, imputSubImg, impID, colorSub, catSub;
      let salir = 0;
      let repeticion = 0;
      let Key = 0;

      // Recorre cada elemento en divs
      divs.forEach(function (input) {
        // Comprueba si el elemento es un formulario
        if (input.tagName === 'FORM') {
          // Agrega un evento de 'submit' a cada formulario.      
          input.addEventListener('submit', function (event) {
            // Previene la acción por defecto de envío del formulario
            event.preventDefault();

            // Resetea las variables colorSub y catSub
            colorSub = "";
            catSub = 0;

            // Comprueba si cumple las condiciones de Condicional_idP. Dará true si estamos en categoría 
            if (Condicional_idP()) {
              nombreSub = document.getElementById('nombreCat').value;
              imputSubImg = document.getElementById('imputCAtImg').value;
              impID = document.getElementById('impIDCat').value;
              colorSub = impID;
              impID = "";
              // Comprueba si cumple las condiciones de Condicional_idX. Dará true si estamos en subcategoría 
            } else if (Condicional_idX()) {
              nombreSub = document.getElementById('nombreSub').value;
              imputSubImg = document.getElementById('imputSubImg').value;
              impID = document.getElementById('impID').value;
            } else {
              // Si no se cumple ninguna de las condiciones, imprime un mensaje y termina la función.
              console.log("No ha habido cambios");
              return;
            }

            // Elimina los espacios al inicio y final de los valores
            var valor = imputSubImg.trim();
            var valor2 = nombreSub.trim();

            // Comprueba si los campos están vacíos o si el nombre ya existe en las categorías o subcategorías
            if ((valor === '' || valor2 === '') && (cat[i].nombre === nombreSub || sub[i].nombre === nombreSub)) {
              console.log('Campo  vacío');
              return;
            } else {
              // Si pasa las validaciones, prepara la información para enviar              
              UpdateGrupoA(catSub, imputSubImg, nombreSub, colorSub, impID);
              // Devido a un error que tuve con el color, utilizo esta combinación de llamadas. 
              llamar("../GestionConfiguracion", Key);
              Key = 2;
              llamar("../GestionConfiguracion", Key);
            }
          });
        }
      });
    }

    // Verifica si la entrada del usuario es idéntica a los datos existentes. Si hay alguna discrepancia, la entrada no se procesa.
    function ValidarInput() {
      // Se obtienen todos los elementos a validar
      const divs = validar;

      // Variables 
      let salir = 0;
      let repeticion = 0;
      let valorInicial, valorActual, nombreSub, imputSubImg, impID, colorSub, catSub;
      let Key = 0;

      // Se itera sobre cada elemento en 'divs'
      divs.forEach(function (input) {

        // Se agrega un evento 'click' a cada elemento.
        // Cuando se hace click en el elemento, se guarda su valor actual como 'valorInicial'
        input.addEventListener('click', function () {
          valorInicial = input.value;
        });

        // Se agrega un evento 'blur' a cada elemento. 
        // Este evento se activa cuando el elemento pierde el foco.
        input.addEventListener('blur', function () {
          // Se obtiene el valor del elemento después de perder el foco.
          valorActual = input.value;

          // Si el valor del elemento ha cambiado y no está vacío, y ninguna de las condiciones se cumple,
          // se verifica si el nuevo valor ya existe en las categorías o subcategorías.
          if ((valorActual !== valorInicial && valorActual !== '') && (!Condicional_idP() && !Condicional_idX())) {
            for (var i = 0; i < cat.length; i++) {
              // Si el nuevo valor coincide con algún nombre de categoría o subcategoría existente, 
              // se restaura el valor inicial y se muestra un mensaje.
              if (cat[i].nombre === valorActual || sub[i].nombre === valorActual) {
                input.value = valorInicial;
                console.log('El nombre coincide con el valor actual Categoria:', cat[i].nombre);
                return;
              } else {
                repeticion++;
                // Si el nuevo valor es único, se actualiza el elemento y se muestra un mensaje.
                if (repeticion === 1) {
                  input.value = valorActual;
                  let cat = sessionStorage.getItem('id');
                  let img = 0;
                  let color = "";
                  let catID = sessionStorage.getItem('id_cat');
                  UpdateGrupoA(cat, img, valorActual, color, catID);
                  console.log('valor unico')
                }
              }
            }
            // Si el valor del elemento no ha cambiado, se restaura el valor inicial y se muestra un mensaje.
          } else if (valorActual === '') {
            console.log('No ha cambiado ' + valorActual);
            input.value = valorInicial;
          }
        });
      });
    }


    // ╔══════════════════════════════════════════╗
    // ║               Envio                      ║
    // ╚══════════════════════════════════════════╝

    // Después de probar muchas formas de enviar el formulario de forma asíncrona, opté por esta.
    // Me ha parecido la forma más sencilla de enviar los formularios, las peticiones de actualización y las de eliminación.
    function UpdateGrupoA(cat, img, nombre, color, idCatSinLetra) {

      // Creamos un objeto FormData para enviar los datos del formulario
      var formData = new FormData();
      formData.append('idCat', cat);
      formData.append('idImg', img);
      formData.append('idNombre', nombre);
      formData.append('idcolor', color);
      formData.append('idCatSinLetra', idCatSinLetra);

      console.log('Datos enviados:', formData);

      // Enviamos la petición POST utilizando la función fetch
      fetch('../UpdateCategorias', {
        method: 'POST',
        body: formData,
      }).then(response => {
        console.log('Conseguido');
      }).catch(error => {
        console.error('Error en la subida:', error);
      });

    };



    // ╔══════════════════════════════════════════╗
    // ║               Miscelánea                 ║
    // ╚══════════════════════════════════════════╝

    // Función para convertir rgb a hexadecimal. El código no es mío
    function rgbConvert(rgb) {
      let sep = rgb.indexOf(",") > -1 ? "," : " ";
      rgb = rgb.substr(4).split(")")[0].split(sep);

      let r = (+rgb[0]).toString(16),
        g = (+rgb[1]).toString(16),
        b = (+rgb[2]).toString(16);

      if (r.length == 1)
        r = "0" + r;
      if (g.length == 1)
        g = "0" + g;
      if (b.length == 1)
        b = "0" + b;

      return "#" + r + g + b;
    }

    // Función para evaluar si estamos en los formularios de subcategoría o categoría 
    function Condicional_idP() {

      var id = sessionStorage.getItem('id');
      if ((id === "P")) {
        return true;
      } else {
        return false;
      }
    }
    function Condicional_idX() {

      var id = sessionStorage.getItem('id');
      if ((id === "X")) {
        return true;
      } else {
        return false;
      }
    }

    // Oculta todos los divs que se deben de ocultar. En cada función se monstrarán los oportunos. 
    function ocultarTodo() {
      VacioInvisible.style.display = "none";
      VacioInvisible.style.pointerEvents = "none";

      masImagen.style.opacity = 0;
      masImagen.style.pointerEvents = "none";

      ColorInvisible.style.display = "none";
      ColorInvisible.style.pointerEvents = "none";

      SubcategoriaInvisible.style.display = "none";
      SubcategoriaInvisible.style.pointerEvents = "none";

      CategoriaInvisible.style.display = "none";
      CategoriaInvisible.style.pointerEvents = "none";

      AvatarInvisible.style.display = "none";
      AvatarInvisible.style.pointerEvents = "none";
    }


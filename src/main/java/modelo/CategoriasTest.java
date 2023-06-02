package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoriasTest {

	 @Test
	    public void testConstructor() {
	        int id = 1;
	        String nombre = "Categoría";
	        int img = 2;
	        String color = "rojo";
	        int usuario = 3;

	        Categorias categorias = new Categorias(id, nombre, img, color, usuario);

	        // Verificar que los atributos se han asignado correctamente
	        Assertions.assertEquals(id, categorias.getId());
	        Assertions.assertEquals(nombre, categorias.getNombre());
	        Assertions.assertEquals(img, categorias.getImg());
	        Assertions.assertEquals(color, categorias.getColor());
	        Assertions.assertEquals(usuario, categorias.getUsuario());
	    }
	}
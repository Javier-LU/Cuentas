package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoriaSubTest {

	 @Test
	    public void testConstructor() {
	        int id = 1;
	        int idCategoria = 2;
	        String nombre = "Subcategoría";
	        String img = "imagen.png";
	        int usuario = 3;

	        CategoriaSub categoriaSub = new CategoriaSub(id, idCategoria, nombre, img, usuario);

	        // Verificar que los atributos se han asignado correctamente
	        Assertions.assertEquals(id, categoriaSub.getId());
	        Assertions.assertEquals(idCategoria, categoriaSub.getIdCategoria());
	        Assertions.assertEquals(nombre, categoriaSub.getNombre());
	        Assertions.assertEquals(img, categoriaSub.getImg());
	        Assertions.assertEquals(usuario, categoriaSub.getUsuario());
	    }
	}

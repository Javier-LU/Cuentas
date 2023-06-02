package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import dao.DaoUsuarios;


class UsuarioTest {

	 @Test
	    public void testInsertar() throws SQLException {
	        // Crear un objeto mock de DaoUsuarios
	        DaoUsuarios daoMock = Mockito.mock(DaoUsuarios.class);

	        // Crear una instancia de Usuario
	        Usuario usuario = new Usuario("165", "165", "165");

	        // Configurar el comportamiento esperado del objeto mock
	        Mockito.doNothing().when(daoMock).insertar(usuario);
	        System.out.println("Valor de usuario: " + usuario.getNombre());
	        System.out.println("Valor de imagen: " + usuario.getImg());
	        // Llamar al método insertar en Usuario
	        usuario.insertar();

	        // Verificar que el método insertar en DaoUsuarios se haya llamado con el usuario correcto
	        Mockito.verify(daoMock).insertar(usuario);
	    }
	    @Test
	    public void testConstructor() {
	        // Preparar los datos de prueba
	        String nombre = "usuario1";
	        String pass = "password1";
	        String img = "imagen1.jpg";

	        // Crear una instancia de Usuario utilizando el constructor
	        Usuario usuario = new Usuario(nombre, pass, img);

	        // Verificar que los atributos se hayan asignado correctamente
	        Assertions.assertEquals(nombre, usuario.getNombre());
	        Assertions.assertEquals(pass, usuario.getPass());
	        Assertions.assertEquals(img, usuario.getImg());
	    }
	}
	 


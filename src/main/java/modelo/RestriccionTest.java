package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import dao.DaoUsuarios;

class RestriccionTest {

    @Test
    public void testConstructor() {
        int id = 1;
        String concepto = "Restricción de prueba";
        String categoria = "Categoría de prueba";
        String subcategoria = "Subcategoría de prueba";
        int usuario = 123;

        Restriccion restriccion = new Restriccion(id, concepto, categoria, subcategoria, usuario);

        assertEquals(id, restriccion.getId());
        assertEquals(concepto, restriccion.getConcepto());
        assertEquals(categoria, restriccion.getCategoria());
        assertEquals(subcategoria, restriccion.getSubcategoria());
        assertEquals(usuario, restriccion.getUsuario());
    }
}



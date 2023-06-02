package modelo;
import java.math.BigDecimal;
import java.util.Date;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TarjetaTest {


    @Test
    public void testConstructor() {
        int id = 1;
        String nombre = "Tarjeta de Crédito";
        Date vencimiento = new Date();
        String descripcion = "Tarjeta para compras en línea";
        BigDecimal limite = new BigDecimal(1000);
        int usuario = 123;

        Tarjeta tarjeta = new Tarjeta(id, nombre, vencimiento, descripcion, limite, usuario);

        assertEquals(id, tarjeta.getId());
        assertEquals(nombre, tarjeta.getNombre());
        assertEquals(vencimiento, tarjeta.getVencimiento());
        assertEquals(descripcion, tarjeta.getDescripcion());
        assertEquals(limite, tarjeta.getLimite());
        assertEquals(usuario, tarjeta.getUsuario());
    }
}
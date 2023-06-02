package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GastosTest {

    @Test
    public void testConstructor() {
        String fechaString = "2023-06-01";
        String concepto = "Comida";
        int importe = 50;
        int saldo = 1000;
        String anotaciones = "Gasto de comida";
        String fechaTarjetaString = "2023-06-01";
        int tipoTarjeta = 1;
        int iD = 123;
        String imagen_categoria = "imagen_categoria.jpg";
        String imagen_subcategoria = "imagen_subcategoria.jpg";
        String nombre_categoria = "Alimentación";
        String nombre_subcategoria = "Restaurantes";
        String nombre_tarjeta = "Tarjeta de crédito";
        String color = "Azul";
        int IdSub = 456;
        int IdCatSub = 789;

        Gastos gastos = new Gastos(fechaString, concepto, importe, saldo, anotaciones, fechaTarjetaString,
                tipoTarjeta, iD, imagen_categoria, imagen_subcategoria, nombre_categoria, nombre_subcategoria,
                nombre_tarjeta, color, IdSub, IdCatSub);

      
        assertEquals(fechaString, gastos.getFechaString());
        assertEquals(concepto, gastos.getConcepto());
        assertEquals(importe, gastos.getImporte());
        assertEquals(saldo, gastos.getSaldo());
        assertEquals(anotaciones, gastos.getAnotaciones());
        assertEquals(fechaTarjetaString, gastos.getFechaTarjetaString());
        assertEquals(tipoTarjeta, gastos.getTipoTarjeta());
        assertEquals(iD, gastos.getID());
        assertEquals(imagen_categoria, gastos.getImagen_categoria());
        assertEquals(imagen_subcategoria, gastos.getImagen_subcategoria());
        assertEquals(nombre_categoria, gastos.getNombre_categoria());
        assertEquals(nombre_subcategoria, gastos.getNombre_subcategoria());
        assertEquals(nombre_tarjeta, gastos.getNombre_tarjeta());
        assertEquals(color, gastos.getColor());
        assertEquals(IdSub, gastos.getIdSub());
        assertEquals(IdCatSub, gastos.getIdCatSub());
    }
}
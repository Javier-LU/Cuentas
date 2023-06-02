package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import dao.DaoImgenes;
import dao.DaoUsuarios;


class ImagenesTest {


    @Test
    public void testConstructor() {
        String img = "imagen1.jpg";
        int id = 1;
        String tipo = "jpg";
        DaoImgenes dao = Mockito.mock(DaoImgenes.class);

        Imagenes imagenes = new Imagenes(img, id, tipo, dao);

        assertEquals(img, imagenes.getImg());
        assertEquals(id, imagenes.getId());
        assertEquals(tipo, imagenes.getTipo());
        assertEquals(dao, imagenes.getDao());
    }
}
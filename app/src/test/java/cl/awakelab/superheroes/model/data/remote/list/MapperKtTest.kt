package cl.awakelab.superheroes.model.data.remote.list

import org.junit.Assert.assertEquals
import org.junit.Test

class MapperKtTest {

    @Test
    fun transformToEntity() {
        //Given
        val hero = Hero(1, 1935, "www.prueba.cl", "Chapulin Colorado",
            "Chapultepec", "Encogerse")

        //When
        val resultTransform = hero.transformToEntity()

        //Then
        assertEquals(hero.id, resultTransform.id)
        assertEquals(hero.anioCreacion, resultTransform.anioCreacion)
        assertEquals(hero.imagenLink, resultTransform.imagenLink)
        assertEquals(hero.nombre, resultTransform.nombre)
        assertEquals(hero.origen, resultTransform.origen)
        assertEquals(hero.poder, resultTransform.poder)
    }


}
package cl.awakelab.superheroes.model.data.remote.list

import cl.awakelab.superheroes.model.data.local.detail.HeroDetailEntity
import cl.awakelab.superheroes.model.data.local.list.HeroEntity
import cl.awakelab.superheroes.model.data.remote.detail.HeroDetail

fun Hero.transformToEntity(): HeroEntity =
    HeroEntity(this.anioCreacion, this.id, this.imagenLink, this.nombre, this.origen, this.poder)

fun HeroDetail.transformToDetailEntity(): HeroDetailEntity =
    HeroDetailEntity(
        this.anioCreacion,
        this.id,
        this.imagenLink,
        this.nombre,
        this.origen,
        this.poder,
        this.color,
        this.traduccion

    )
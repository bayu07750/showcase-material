package com.bayu.transitionnavigation.data

import kotlin.random.Random

object Data {

    val photos: List<Photo> = listOf(
        Photo(
            "Abigail",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
        Photo(
            "Alexandra",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
        Photo(
            "Alison",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
        Photo(
            "Amanda",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
        Photo(
            "Amelia",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
        Photo(
            "Amy",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
        Photo(
            "Andrea",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
        Photo(
            "Angela",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
        Photo(
            "Anna",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
        Photo(
            "Anne",
            "https://source.unsplash.com/300x${randomHeight()}/",
        ),
    )

    private fun randomHeight(): Int {
        return Random.nextInt(from = 300, until = 550)
    }

}

data class Photo(
    val name: String,
    val url: String,
)
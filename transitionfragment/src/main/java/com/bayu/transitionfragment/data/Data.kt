package com.bayu.transitionfragment.data

import kotlin.random.Random

object Data {

    val photos = listOf(
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
        "https://source.unsplash.com/300x${randomHeight()}/",
    )

    private fun randomHeight(): Int {
        return Random.nextInt(from = 300, until = 550)
    }

}
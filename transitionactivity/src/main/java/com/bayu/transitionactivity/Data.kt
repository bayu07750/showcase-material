package com.bayu.transitionactivity

import kotlin.random.Random

object Data {

    val photos = listOf(
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
        "https://source.unsplash.com/200x${randomHeight()}/",
    )

    private fun randomHeight(): Int {
        return Random.nextInt(from = 200, until = 450)
    }

}
package com.example.drehbuch

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
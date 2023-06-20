package com.example.myapplication

class Magazine(override var price: Double?, override var wordCount: Int?) : Publication {

    override fun getType(): String {
        return "Magazine"
    }
}
package com.example.myapplication

interface Publication {

    var price: Double? // цена
    var wordCount: Int? // кол-во слов

    fun getType() : String
}
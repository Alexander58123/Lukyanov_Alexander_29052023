package com.example.myapplication

import java.text.DecimalFormat

fun main() {

    // книги
    val kniga1: Publication = Book(300.0, 8000)
    val kniga2 : Publication = Book(217.80, 5000)
    // val kniga3: Publication = Book(217.80, 5000);

    // магазин
    val magazine1: Publication = Magazine(580.25, 900)

    println("Тип книги ${kniga1.getType()}, кол-во слов ${kniga1.wordCount}, цена ${kniga1.price?.toPriceAmount()}")
    println("Тип книги ${kniga2.getType()}, кол-во слов ${kniga2.wordCount}, цена ${kniga2.price?.toPriceAmount()}")

    println("Тип ${magazine1.getType()}, кол-во слов ${magazine1.wordCount}, цена ${magazine1.price?.toPriceAmount()}")

    // второй пункт
    // сравнение на равенство по ссылке и через equals
    println(kniga1 === kniga2)
    println(kniga1.equals(kniga2))

    // третий пункт
    val kniga4: Publication? = null
    val kniga5: Publication = Book(318.40, 3500)
    kniga4?.let { buy(it) } // let здесь не выполнится т.к. null
    kniga5?.let { buy(it) }


    // четвертый пункт
    val summ = {a : Int, b : Int -> println(a + b)}
    summ(9, 3)

}


fun buy(publication: Publication) {
    println("The purchase is complete. The purchase amount was ${publication.price?.toPriceAmount()}")
}

// формат вывода Double с евро
fun Double.toPriceAmount(): String {
    val dec = DecimalFormat("€ ###,###,###.00")
    return dec.format(this)
}






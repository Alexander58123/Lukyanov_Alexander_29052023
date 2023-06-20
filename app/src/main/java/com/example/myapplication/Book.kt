package com.example.myapplication

class Book(override var price: Double?, override var wordCount: Int?) : Publication {

    override fun getType(): String {
        if (wordCount!! <= 1000) {
            return "Flash Fiction"
        } else if (wordCount!! > 1000 && wordCount!! <= 7500) {
            return "Short Story"
        } else {
            return "Novel"
        }
    }


    // переопределение сравнения объектов Book
    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (this === other) return true
        if (other !is Book) return false
        if (this.wordCount != other.wordCount || this.price != other.price) return false
        return true
    }


}
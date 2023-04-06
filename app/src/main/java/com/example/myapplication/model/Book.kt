package com.example.myapplication.model

class Book {
    var bookName:String ? = null
    var bookImage:Int ? = 0

    constructor(bookName: String?, bookImage: Int?) {
        this.bookName = bookName
        this.bookImage = bookImage
    }
}
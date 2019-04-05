package com.academy.fundamentals.kotchess

class Position(column: Int, row: Int) {

    fun convertIntToPos(pos : Int) : Position {
        val column : Int = pos % 8
        val row : Int = pos / 8
        return Position(column, row)
    }

}

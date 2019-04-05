package com.academy.fundamentals.kotchess

import java.util.ArrayList

abstract class Piece(val color: Int, var column: Int, var row: Int) {

    abstract fun getPieceIcon(): Int

    abstract fun getPotentialMoves(pieces: Array<Array<Piece>>): ArrayList<Position>


    fun getIntPosition() : Int{
        return row * 8 + column
    }

    fun column() {

    }


}


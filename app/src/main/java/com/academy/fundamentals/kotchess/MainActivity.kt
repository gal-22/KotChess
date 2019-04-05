package com.academy.fundamentals.kotchess

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // UI Elements
    val pieces = Array(8) { arrayOfNulls<Piece?>(8) }
    val adapter: ChessAdapter = ChessAdapter(pieces, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chess_rv.layoutManager = GridLayoutManager(this, 8)
        // Access the RecyclerView Adapter and load the data into it
        chess_rv.adapter = adapter
        adapter.setChessAdapterListener(chessAdapterListener)
        adapter.notifyDataSetChanged()
    }

    // Chess Adapter Implementation
    private val chessAdapterListener : ChessAdapter.ChessAdapterListener = object : ChessAdapter.ChessAdapterListener {
        override fun onBoardCellClick(boardCell: ChessAdapter.BoardCellViewHolder, view: View) {
            Toast.makeText(this@MainActivity, "Hello", Toast.LENGTH_SHORT).show()
        }
    }
}

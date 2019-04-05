package com.academy.fundamentals.kotchess

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.square.view.*


class ChessAdapter(val pieces: Array<Array<Piece?>>, val context: Context) : RecyclerView.Adapter<ChessAdapter.BoardCellViewHolder>() {

    // MARK: - Listener
    var listener: ChessAdapterListener? = null

    override fun onBindViewHolder(holder: BoardCellViewHolder, position: Int) {
        holder.bind()
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return 64
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardCellViewHolder {
        return BoardCellViewHolder(LayoutInflater.from(context).inflate(R.layout.square, parent, false))
    }

    fun setChessAdapterListener(listener: ChessAdapterListener) {
        this.listener = listener
    }

    inner class BoardCellViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        // MARK: - bind views
        val movieSquare = view.square_constraints
        val pieceIv = view.piece_iv
        val highLightView = view.highlight_view

        // MARK: - init functions
        fun bind() {
            movieSquare.setBackgroundResource(getSquareColor(adapterPosition))
            movieSquare.setOnClickListener { view -> this@ChessAdapter.listener?.onBoardCellClick(this, view) }
        }

        // MARK: - Private functions
        private fun getSquareColor(pos: Int): Int {
            val row = pos / 8
            val colorWhite: Int = R.color.boardWhite
            val colorBlack: Int = R.color.boardBlack
            return if (row % 2 == 0) { // even row
                if (pos % 2 == 0) colorWhite // even column
                else colorBlack // odd column
            } else { // odd column
                if (pos % 2 == 0) colorBlack // even column
                else colorWhite // odd column
            }
        }
    }

    // MARK: - BoardCellViewHolderListener
    interface ChessAdapterListener {
        fun onBoardCellClick(boardCell: BoardCellViewHolder, view: View) = Unit
    }
}






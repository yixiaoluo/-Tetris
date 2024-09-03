package graphicsExtension

import BoardOfCells
import korlibs.korge.view.*

fun Graphics.drawBoardOfCells(boardOfCells: BoardOfCells,
                              cellSize: Double) {
    graphics {
        (0 until boardOfCells.height).forEach { y ->
            (0 until boardOfCells.width).forEach { x ->
                val color = boardOfCells.boardOfCells[x, y].col
                fill(color) {
                    rect(10 + (1 + cellSize) * x, 15 + (1 + cellSize) * y, cellSize, cellSize)
                }
            }
        }
    }
}



package graphicsExtension

import BoardOfCells
import korlibs.korge.view.*

fun Graphics.drawBgBoardOfCells(bgBoardOfCells: BoardOfCells,
                                cellSize: Double,
                                leftIndent: Double,
                                topIndent: Double): Graphics {
    return graphics {
        (0 until bgBoardOfCells.height).forEach { y ->
            (0 until bgBoardOfCells.width).forEach { x ->
                fill(bgBoardOfCells.boardOfCells[x, y].col) {
                    rect(10 + (1 + cellSize) * x, 15 + (1 + cellSize) * y, cellSize, cellSize)
                }
            }
        }
    }.position(leftIndent, topIndent)
}

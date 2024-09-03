package graphicsExtension

import block.*
import korlibs.korge.view.*

fun Graphics.drawNextBlock(nextBlockItem: BlockItem,
                           cellSize: Double,
                           views: Views): Graphics {
    return graphics {
        fill(nextBlockItem.color) {
            nextBlockItem.shape.getPositionsWithValue(true).forEach { (x, y) ->
                rect(10 + (1 + cellSize) * x, 15 + (1 + cellSize) * y, cellSize, cellSize)
            }
        }
    }.position(views.virtualWidth * 0.7 , cellSize + 50.0)
}


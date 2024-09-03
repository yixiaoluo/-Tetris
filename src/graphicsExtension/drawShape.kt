package graphicsExtension

import block.*
import korlibs.korge.view.*

fun Graphics.drawShape(Shape: BlockItem, cellSize: Double) {
    graphics {
        fill(Shape.color) {
            Shape.shape.getPositionsWithValue(true).forEach { (x, y) ->
                rect(10 + (1 + cellSize) * x, 15 + (1 + cellSize) * y, cellSize, cellSize)
            }
        }
    }
}

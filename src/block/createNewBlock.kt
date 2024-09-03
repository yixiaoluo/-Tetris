package block

import korlibs.korge.view.*

fun Stage.createNewBlock(blockItem: BlockItem,
                         cellSize: Double,
                         leftIndent:Double,
                         topIndent: Double
                         ): Graphics {
    return graphics {
        fill(blockItem.color) {
            blockItem.shape.getPositionsWithValue(true).forEach { (x, y) ->
                rect(10 + (1 + cellSize) * x, 15 + (1 + cellSize) * y, cellSize, cellSize)
            }
        }
    }.position(
        leftIndent + blockItem.location.x * (1 + cellSize),
        topIndent + blockItem.location.y * (1 + cellSize)
    )
}



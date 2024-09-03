package stageExtensions

import block.*
import graphicsExtension.*
import korlibs.image.color.*
import korlibs.korge.view.*
import korlibs.korge.view.align.*
import korlibs.math.geom.*

fun Stage.renderNextBlockContainer(cellSize: Double,
                                   nextBlockItem: BlockItem) {

    val nextBlockWidth = views.virtualWidth * 0.7
    val nextBlockField = roundRect(
        Size(cellSize * 4 + 20, cellSize * 6),
        RectCorners(10.0,10.0,10.0,10.0),
        Colors.FLORALWHITE) {
        position(nextBlockWidth, 50.0)
    }

    text("NEXT", cellSize * 0.5, Colors.BLUE) {
        centerXOn(nextBlockField)
        centerYBetween(50.0, 50 + cellSize)
    }

    graphics {
        fill(Colors.LIGHTSTEELBLUE) {
            for (i in 0 until 4) {
                for (j in 0 until 4) {
                    roundRect(
                        (1 + cellSize) * i, cellSize + (1 + cellSize) * j,
                        cellSize,
                        cellSize,
                        2.0,
                        2.0)
                }
            }

        }
    }.position(nextBlockWidth+10, 60.0)

    graphics().drawNextBlock(nextBlockItem,cellSize,views)
}


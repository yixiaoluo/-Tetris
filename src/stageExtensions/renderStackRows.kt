package stageExtensions

import korlibs.image.color.*
import korlibs.korge.view.*
import korlibs.korge.view.align.*
import korlibs.math.geom.*
import stackCount


fun Stage.renderStackRows(cellSize: Double): Text {
    val stackRowsBlockField = roundRect(
        Size(cellSize * 4 + 2, cellSize * 2),
        RectCorners(5.0, 5.0, 5.0, 5.0),
        Colors.FLORALWHITE
    ) {
        position(views.virtualWidth * 0.7, 50 + cellSize * 12)
    }

    text("STACKROWS", cellSize * 0.5, Colors.BLUE) {
        centerXOn(stackRowsBlockField)
        centerYBetween(50 + cellSize * 12, 50 + cellSize * 13)
    }

    val stackCountText = text(stackCount.toString(), cellSize * 0.5, Colors.BLUE) {
        centerXOn(stackRowsBlockField)
        centerYBetween(50 + cellSize * 13, 50 + cellSize * 14)
    }

    return stackCountText
}

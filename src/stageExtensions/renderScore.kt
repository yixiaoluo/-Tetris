package stageExtensions

import gameScore
import korlibs.image.color.*
import korlibs.korge.view.*
import korlibs.korge.view.align.*
import korlibs.math.geom.*

fun Stage.renderScore(cellSize: Double): Text {
    val scoreBlockField = roundRect(
        Size(cellSize * 4 + 2, cellSize * 2),
        RectCorners(5.0, 5.0, 5.0, 5.0),
        Colors.FLORALWHITE
    ) {
        position(views.virtualWidth * 0.7, 50 + cellSize * 15)
    }

    text("SCORE", cellSize * 0.5, Colors.BLUE) {
        centerXOn(scoreBlockField)
        centerYBetween(50 + cellSize * 15, 50 + cellSize * 16)
    }

    //    SCORE Display
    var scoreDisplay = text(gameScore.toString(), cellSize * 0.5, Colors.BLUE) {
        centerXBetween(views.virtualWidth * 0.75, views.virtualWidth * 0.85)
        centerYBetween(65 + cellSize * 15, 65 + cellSize * 17)
        color = Colors.DARKGREEN
    }

    return scoreDisplay

}



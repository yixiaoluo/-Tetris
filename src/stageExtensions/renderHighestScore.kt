package stageExtensions

import gameScore
import getHighestScore
import korlibs.image.color.*
import korlibs.korge.view.*
import korlibs.korge.view.align.*
import korlibs.math.geom.*

fun Stage.renderHighestScore(cellSize: Double): Text {
    val highestScoreBlockField = roundRect(
        Size(cellSize * 4 + 2, cellSize * 2),
        RectCorners(5.0, 5.0, 5.0, 5.0),
        Colors.FLORALWHITE
    ) {
        position(views.virtualWidth * 0.7, 50 + cellSize * 18)
    }

    text("Highest Score", cellSize * 0.5, Colors.BLUE) {
        centerXOn(highestScoreBlockField)
        centerYBetween(50 + cellSize * 18, 50 + cellSize * 19)
    }

    // highest Display
    var highestScoreDisplay = text(getHighestScore(gameScore).toString(),
        cellSize * 0.5, Colors.BLUE) {
        centerXBetween(views.virtualWidth * 0.75, views.virtualWidth * 0.85)
        centerYBetween(50 + cellSize * 19, 50 + cellSize * 20)
        color = Colors.BLACK
    }

    return highestScoreDisplay

}



package stageExtensions

import isGamePause
import korlibs.image.color.*
import korlibs.korge.input.*
import korlibs.korge.view.*
import korlibs.korge.view.align.*
import korlibs.math.geom.*


fun Stage.renderPauseButton(cellSize: Double) {
    val pauseBlockField = roundRect(
        Size(cellSize * 2.0, cellSize),
        RectCorners(5.0, 5.0, 5.0, 5.0),
        Colors.ORANGE
    ) {
        position(views.virtualWidth * 0.7, 50 + cellSize * 20.5)
    }


    text("Pause", cellSize * 0.4, Colors.BLACK) {
        centerXOn(pauseBlockField)
        centerYBetween(50 + cellSize * 20.5, 50 + cellSize * 21.5)
        onClick {
            isGamePause = true
        }
    }
}

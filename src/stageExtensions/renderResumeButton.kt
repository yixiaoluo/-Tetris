package stageExtensions

import isGamePause
import korlibs.image.color.*
import korlibs.korge.input.*
import korlibs.korge.view.*
import korlibs.korge.view.align.*
import korlibs.math.geom.*

fun Stage.renderResumeButton(cellSize: Double) {
    val resumeBlockField = roundRect(
        Size(cellSize * 2.0, cellSize),
        RectCorners(5.0, 5.0, 5.0, 5.0),
        Colors.GREEN
    ) {
        position(views.virtualWidth * 0.82, 50 + cellSize * 20.5)
    }


    text("Resume", cellSize * 0.4, Colors.BLACK) {
        centerXOn(resumeBlockField)
        centerYBetween(50 + cellSize * 20.5, 50 + cellSize * 21.5)
        onClick {
            isGamePause = false
        }
    }
}

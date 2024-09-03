package stageExtensions

import korlibs.image.color.*
import korlibs.korge.input.*
import korlibs.korge.view.*
import korlibs.korge.view.align.*
import korlibs.math.geom.*
import startNewGame

fun Stage.showGameOver(cellSize: Double){
    val gameOverBanner = roundRect(
        Size(cellSize * 8, cellSize * 4),
        radius = RectCorners(10.0, 10.0, 10.0, 10.0),
        fill=Colors.FLORALWHITE){
        position(views.virtualWidth*0.12, 50 + cellSize*8)
    }

    val gameOverText = text("Game Over", cellSize * 0.7, Colors.RED) {
        centerXOn(gameOverBanner)
        centerYBetween( 50+ cellSize*8,  50+ cellSize*10)
    }

    val playAgainButton = roundRect(
        Size(cellSize * 5 , cellSize),
        radius = RectCorners(10.0, 10.0, 10.0, 10.0),
        fill= Colors.BLUE){
        position(views.virtualWidth * 0.21, 50 + cellSize * 10)
    }
    val playAgainText =  text("PLAY AGAIN", cellSize * 0.5, Colors.WHITE) {
        centerOn(playAgainButton)
        onClick {
            startNewGame = true
            gameOverBanner.removeFromParent()
            gameOverText.removeFromParent()
            playAgainButton.removeFromParent()
            this.removeFromParent()
        }
    }

}


package gameControl

import block.*
import BoardOfCells
import korlibs.event.*
import korlibs.korge.input.*
import korlibs.korge.view.*


fun Stage.controlCurrentBlock(newBlockItem: BlockItem,
                              input: Input,
                              cellSize:Double,
                              leftIndent: Double,
                              topIndent: Double,
                              isGamePause: Boolean,
                              bgBoardOfCells: BoardOfCells): Graphics {
    var counter = 0.0
    var rotationIndex = newBlockItem.rotationIndex
    val blockItemGraph = graphics {
        fill(newBlockItem.color) {
            newBlockItem.shape.getPositionsWithValue(true).forEach { (x, y) ->
                rect(10 + (1 + cellSize) * x, 15 + (1 + cellSize) * y, cellSize, cellSize)
            }
        }
    }.position(
        leftIndent + newBlockItem.location.x * (1 + cellSize),
        topIndent + newBlockItem.location.y * (1 + cellSize)
    )

    blockItemGraph.addFastUpdater { dt ->
        holdKeyMove(key = Key.LEFT, input=input, isGamePause=isGamePause,dt=dt)
        holdKeyMove(Key.RIGHT, input=input, isGamePause=isGamePause,dt=dt)
        holdKeyMove(Key.DOWN, input=input, isGamePause=isGamePause,dt=dt)

        pressKeyMoveBlock(Key.LEFT, input=input, currentBlockItem = newBlockItem, bgBoardOfCells=bgBoardOfCells,isGamePause=isGamePause)
        pressKeyMoveBlock(Key.RIGHT, input=input, currentBlockItem = newBlockItem, bgBoardOfCells=bgBoardOfCells, isGamePause=isGamePause)
        pressKeyMoveBlock(Key.DOWN, input=input, currentBlockItem = newBlockItem, bgBoardOfCells=bgBoardOfCells, isGamePause=isGamePause)
        pressKeyMoveBlock(Key.SPACE, input=input, currentBlockItem = newBlockItem, bgBoardOfCells=bgBoardOfCells, isGamePause=isGamePause)
        pressKeyMoveBlock(Key.Q, input=input, currentBlockItem = newBlockItem, bgBoardOfCells=bgBoardOfCells, isGamePause=isGamePause)
        pressKeyMoveBlock(Key.E, input=input, currentBlockItem = newBlockItem, bgBoardOfCells=bgBoardOfCells, isGamePause=isGamePause)

        blockItemGraph.position(
            leftIndent + newBlockItem.location.x * (1 + cellSize), topIndent + newBlockItem.location.y * (1 + cellSize)
        )
    }

    return blockItemGraph

}


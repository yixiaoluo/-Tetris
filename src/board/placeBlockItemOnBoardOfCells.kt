package board

import block.*
import BoardOfCells

fun placeBlockItemOnBoardOfCells(blockItem: BlockItem,
                                 bgBoardOfCells: BoardOfCells): BoardOfCells {
    val blockLocationX = (blockItem.location.x).toInt()
    val blockLocationY = (blockItem.location.y).toInt()
    val notEmptyBlockPositions = blockItem.positionsNotEmpty()
    val outBoardOfCells = bgBoardOfCells



    notEmptyBlockPositions.forEach {
        outBoardOfCells.boardOfCells[blockLocationX + it.first, blockLocationY + it.second].value = true
        outBoardOfCells.boardOfCells[blockLocationX + it.first, blockLocationY + it.second].col = blockItem.color
    }


    return outBoardOfCells
}


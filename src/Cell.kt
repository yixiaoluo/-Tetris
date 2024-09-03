import block.*
import korlibs.datastructure.*
import korlibs.image.color.*
import korlibs.math.geom.*


class Cell(var col: RGBA, var value:Boolean)

val emptyCellColor = Colors.LIGHTSTEELBLUE
fun createEmptyCell(): Cell = Cell(col = Colors.LIGHTSTEELBLUE, value = false)
//val newBoardNRow: Int = 20
//val newBoardNCol: Int = 10

fun blockItemToBlockCells(blockItem: BlockItem): BlockOfCells {
//    var rotationIndex = blockItem.rotationIndex
//    val shapeTransformations = blockItem.shapeTransformations
    val location = blockItem.location as Point
    val shape = blockItem.shape
    val shapeColor = blockItem.color
    val shapeWidth = shape.width
    val shapeHeight = shape.height
    var outputBlock = newBlockOfCells(shapeWidth,shapeHeight, createEmptyCell())

    outputBlock.location = location

    (0 until shapeWidth).forEach { x ->
        (0 until shapeHeight).forEach { y ->
            if(shape[x,y]){
                outputBlock.setCellFill(x,y,true)
                outputBlock.setCellColor(x,y,shapeColor)

            } else{
                outputBlock.setCellFill(x,y,false)
                outputBlock.setCellColor(x,y,emptyCellColor)
            }
        }
    }


    return outputBlock
}




class BlockOfCells(var blockOfCells: Array2<Cell>){
    var location = Point()
    var width = blockOfCells.width
    var height = blockOfCells.height

    fun getCellFill( x: Int, y: Int): Boolean = blockOfCells[x, y].value
    fun getCellColor(x: Int, y: Int): RGBA  = blockOfCells[x, y].col
    fun setCellFill(x: Int, y: Int, value: Boolean): Unit = run { blockOfCells[x, y].value = value }
    fun setCellColor(x: Int, y: Int, color: RGBA): Unit = run { blockOfCells[x, y].col = color }

}

fun newBlockOfCells(width: Int, height: Int, data: Cell): BlockOfCells {
    return BlockOfCells(Array2<Cell>(width,height,data))
}


class BoardOfCells(var boardOfCells: Array2<Cell>) {
    private val boardIn get() = boardOfCells
    val width:Int = boardIn.width
    val height:Int = boardIn.height

    fun getCellFill(x: Int, y: Int): Boolean  =  boardIn[x, y].value
    fun getCellColor(x: Int, y: Int): RGBA  = boardIn[x, y].col

    fun setCellFill(x: Int, y: Int, value: Boolean): Unit = run { boardIn[x, y].value = value }
    fun setCellColor(x: Int, y: Int, color: RGBA): Unit = run { boardIn[x, y].col = color }



    fun convertToBooleanBoard(): Array2<Boolean> {
        val width:Int = boardOfCells.width
        val height:Int = boardOfCells.height
        var boardValue = Array2<Boolean>(width = width, height = height, fill = false)
        (0 until height).forEach { y ->
            (0 until width).forEach { x ->
                boardValue[x,y] = boardOfCells[x,y].value
            }
        }
        return boardValue

    }
     }





fun createBoardOfCells( width: Int, height:Int ): BoardOfCells {
    val newBoardNRow: Int = 20
    val newBoardNCol: Int = 10
    return BoardOfCells(Array2<Cell>(width = newBoardNCol,height = newBoardNRow){createEmptyCell()})
}

//var newBoardOfCells = BoardOfCells(newBoardOfCells1)
//val newBoardOfCells1: Array2<Cell> = Array2<Cell>(width = newBoardNCol,height = newBoardNRow){getEmptyCell()}



package block

import korlibs.datastructure.*
import korlibs.image.color.*

data class BlockItem(var rotationIndex: Int,
                     val shapeTransformations: List<Array2<Boolean>>,
                     var location: PointVar,
                     val color: RGBA
) {

    val shape get() = shapeTransformations[rotationIndex]
    fun rotateClockwise() {
        rotationIndex++
        if (rotationIndex >= shapeTransformations.size)
            rotationIndex -= shapeTransformations.size
    }

    fun rotateCounterClockwise() {
        rotationIndex--
        if (rotationIndex < 0)
            rotationIndex += shapeTransformations.size
    }

    fun positionsNotEmpty(): List<Pair<Int, Int>> {
        return shape.getPositionsWithValue(true)
    }

}

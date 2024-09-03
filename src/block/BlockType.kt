package block

import korlibs.datastructure.*

fun shape(shape: String): Array2<Boolean> {
    return Array2.Companion.invoke(shape) { char, x, y -> char == '#' }
}


enum class BlockType(val shapes: List<Array2<Boolean>>) {
    I(listOf(
        shape("####"),
        shape("""
				#
				#
				#
				#
			""".trimIndent())
    )),
    O(listOf(shape("""
        ##
        ##
    """.trimIndent()))),
    T(listOf(shape("""
        .#.
        ###
    """.trimIndent()),
        shape("""
        #.
        ##
        #.
    """.trimIndent()),
        shape("""
        ###
        .#.
    """.trimIndent()),
        shape("""
                .#
                ##
                .#
            """.trimIndent())
    )),
    Z(listOf(
        shape("""
                ##.
                .##
            """.trimIndent()),
        shape("""
        .#
        ##
        #.
    """.trimIndent())
    )),

    S(listOf(
        shape("""
                .##
                ##.
            """.trimIndent()),
        shape("""
        #.
        ##
        .#
    """.trimIndent())
    )),

    J(listOf(shape("""
        .#
        .#
        ##
    """.trimIndent()),
        shape("""
        #..
        ###
    """.trimIndent()),
        shape("""
        ##
        #.
        #.
    """.trimIndent()),
        shape("""
        ###
        ..#
    """.trimIndent())
    )),
    L(listOf(shape("""
        #.
        #.
        ##
    """.trimIndent()),
        shape("""
        ###
        #..
    """.trimIndent()),
        shape("""
        ##
        .#
        .#
    """.trimIndent()),
        shape("""
        ..#
        ###
    """.trimIndent())))
}

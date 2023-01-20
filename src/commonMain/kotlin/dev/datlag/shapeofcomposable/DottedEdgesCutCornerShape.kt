package dev.datlag.shapeofcomposable

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

data class DottedEdgesCutCornerShape constructor(
    val startTopCutSize: CornerSize = CornerSize(0F),
    val endTopCutSize: CornerSize = CornerSize(0F),
    val startBottomCutSize: CornerSize = CornerSize(0F),
    val endBottomCutSize: CornerSize = CornerSize(0F),
    val dotPositions: Collection<POSITION>,
    val dotRadius: Float = 0F,
    val dotSpacing: Float = 0F
) : ShapeOfComposable, CornerBasedShape(startTopCutSize, endTopCutSize, endBottomCutSize, startBottomCutSize) {

    constructor(
        cutSize: CornerSize = CornerSize(0F),
        dotPositions: Collection<POSITION>,
        dotRadius: Float = 0F,
        dotSpacing: Float = 0F
    ) : this(cutSize, cutSize, cutSize, cutSize, dotPositions, dotRadius, dotSpacing)

    internal constructor(
        cutSize: Float = 0F,
        dotPositions: Collection<POSITION>,
        dotRadius: Float = 0F,
        dotSpacing: Float = 0F
    ) : this(CornerSize(cutSize), CornerSize(cutSize), CornerSize(cutSize), CornerSize(cutSize), dotPositions, dotRadius, dotSpacing)

    override fun createOutline(
        size: Size,
        topStart: Float,
        topEnd: Float,
        bottomEnd: Float,
        bottomStart: Float,
        layoutDirection: LayoutDirection
    ): Outline {
        return Outline.Generic(Path().apply {
            val startTopDiameter = if (topStart < 0F) 0F else topStart
            val endTopDiameter = if (topEnd < 0F) 0F else topEnd
            val startBottomDiameter = if (bottomStart < 0F) 0F else bottomStart
            val endBottomDiameter = if (bottomEnd < 0F) 0F else bottomEnd

            this.moveTo(startTopDiameter, 0F)
            if (containsFlag(POSITION.TOP)) {
                var count = 1
                var x = startTopDiameter + dotSpacing * count + dotRadius * 2 * 0
                while (x + dotSpacing + dotRadius * 2 <= size.width - endTopDiameter) {
                    x = startTopDiameter + dotSpacing * count + dotRadius * 2 * (count - 1)
                    this.lineTo(x, 0F)
                    this.quadraticBezierTo(x + dotRadius, dotRadius, x + dotRadius * 2, 0F)
                    count++
                }
                this.lineTo(size.width - endTopDiameter, 0F)
            } else {
                this.lineTo(size.width - endTopDiameter, 0F)
            }

            this.lineTo(size.width, endTopDiameter)
            if (containsFlag(POSITION.END)) {
                this.lineTo(size.width - dotRadius, endTopDiameter)
                this.lineTo(size.width - dotRadius, size.height - endBottomDiameter)
                this.lineTo(size.width, size.height - endBottomDiameter)

                var count = 1
                var y = size.height - endBottomDiameter - dotSpacing * count - dotRadius * 2 * 0
                while (y - dotSpacing - dotRadius * 2 >= endTopDiameter) {
                    y = size.height - endBottomDiameter - dotSpacing * count - dotRadius * 2 * (count - 1)
                    this.lineTo(size.width, y)
                    this.quadraticBezierTo(size.width - dotRadius, y - dotRadius, size.width, y - dotRadius * 2)
                    count++
                }
                this.lineTo(size.width, endTopDiameter)
                this.lineTo(size.width - dotRadius, endTopDiameter)
                this.lineTo(size.width - dotRadius, size.height - endBottomDiameter)
                this.lineTo(size.width, size.height - endBottomDiameter)
            } else {
                this.lineTo(size.width, size.height - endBottomDiameter)
            }

            this.lineTo(size.width - endBottomDiameter, size.height)
            if (containsFlag(POSITION.BOTTOM)) {
                var count = 1
                var x = size.width - endBottomDiameter - dotSpacing * count - dotRadius * 2 * 0
                while (x - dotSpacing - dotRadius * 2 >= startBottomDiameter) {
                    x = size.width - endBottomDiameter - dotSpacing * count - dotRadius * 2 * (count - 1)
                    this.lineTo(x, size.height)
                    this.quadraticBezierTo(x - dotRadius, size.height - dotRadius, x - dotRadius * 2, size.height)
                    count++
                }
                this.lineTo(startBottomDiameter, size.height)
            } else {
                this.lineTo(startBottomDiameter, size.height)
            }

            this.lineTo(0F, size.height - startBottomDiameter)
            if (containsFlag(POSITION.START)) {
                var count = 1
                var y = size.height - startBottomDiameter - dotRadius * count - dotRadius * 2 * 0
                while (y - dotSpacing - dotRadius * 2 >= startTopDiameter) {
                    y = size.height - startBottomDiameter - dotSpacing * count - dotRadius * 2 * (count - 1)
                    this.lineTo(0F, y)
                    this.quadraticBezierTo(dotRadius, y - dotRadius, 0F, y - dotRadius * 2)
                    count++
                }
                this.lineTo(0F, startTopDiameter)
            } else {
                this.lineTo(0F, startTopDiameter)
            }
            this.lineTo(startTopDiameter, 0F)
            this.close()
        })
    }

    private fun containsFlag(position: POSITION): Boolean {
        if (dotPositions.any { it is POSITION.NONE }) {
            return false
        }

        return dotPositions.contains(position)
    }

    override fun copy(
        topStart: CornerSize,
        topEnd: CornerSize,
        bottomEnd: CornerSize,
        bottomStart: CornerSize
    ): CornerBasedShape = DottedEdgesCutCornerShape(
        topStart,
        topEnd,
        bottomStart,
        bottomEnd,
        dotPositions,
        dotRadius,
        dotSpacing
    )

    sealed interface POSITION {
        object NONE : POSITION
        object TOP : POSITION
        object BOTTOM : POSITION
        object START : POSITION
        object END : POSITION
    }
}
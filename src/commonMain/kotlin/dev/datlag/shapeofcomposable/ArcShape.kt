package dev.datlag.shapeofcomposable

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.abs

/**
 * A shape with an inside or outside arc on one side.
 *
 * @param arcSizePx the size of the arc in pixel
 * @property position the position of the arc, either start (left) / top / end (right) / bottom
 * @property direction the direction of the arc either inside or outside
 */
data class ArcShape(
    internal val arcSizePx: Float,
    val position: POSITION = POSITION.BOTTOM,
    val direction: DIRECTION = DIRECTION.OUTSIDE
) : ShapeOfComposable {

    val sizePx: Float = abs(arcSizePx)

    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(Path().apply {
            when (position) {
                is POSITION.START -> {
                    when (direction) {
                        is DIRECTION.INSIDE -> {
                            this.moveTo(size.width, 0F)
                            this.lineTo(0F, 0F)
                            this.quadraticBezierTo(sizePx * 2, size.height / 2, 0F, size.height)
                            this.lineTo(size.width, size.height)
                        }
                        is DIRECTION.OUTSIDE -> {
                            this.moveTo(size.width, 0F)
                            this.lineTo(sizePx, 0F)
                            this.quadraticBezierTo(-sizePx, size.height / 2, sizePx, size.height)
                            this.lineTo(size.width, size.height)
                        }
                    }
                }
                is POSITION.TOP -> {
                    when (direction) {
                        is DIRECTION.INSIDE -> {
                            this.moveTo(0F, size.height)
                            this.lineTo(0F, 0F)
                            this.quadraticBezierTo(size.width / 2, 2 * sizePx, size.width, 0F)
                            this.lineTo(size.width, size.height)
                        }
                        is DIRECTION.OUTSIDE -> {
                            this.moveTo(0F, sizePx)
                            this.quadraticBezierTo(size.width / 2, -sizePx, size.width, sizePx)
                            this.lineTo(size.width, size.height)
                            this.lineTo(0F, size.height)
                        }
                    }
                }
                is POSITION.END -> {
                    when (direction) {
                        is DIRECTION.INSIDE -> {
                            this.moveTo(0F, 0F)
                            this.lineTo(size.width, 0F)
                            this.quadraticBezierTo(size.width - sizePx * 2, size.height / 2, size.width, size.height)
                            this.lineTo(0F, size.height)
                        }
                        is DIRECTION.OUTSIDE -> {
                            this.moveTo(0F, 0F)
                            this.lineTo(size.width - sizePx, 0F)
                            this.quadraticBezierTo(size.width + sizePx, size.height / 2, size.width - sizePx, size.height)
                            this.lineTo(0F, size.height)
                        }
                    }
                }
                is POSITION.BOTTOM -> {
                    when (direction) {
                        is DIRECTION.INSIDE -> {
                            this.moveTo(0F, 0F)
                            this.lineTo(0F, size.height)
                            this.quadraticBezierTo(size.width / 2, size.height - 2 * sizePx, size.width, size.height)
                            this.lineTo(size.width, 0F)
                        }
                        is DIRECTION.OUTSIDE -> {
                            this.moveTo(0F, 0F)
                            this.lineTo(0F, size.height - sizePx)
                            this.quadraticBezierTo(size.width / 2, size.height + sizePx, size.width, size.height - sizePx)
                            this.lineTo(size.width, 0F)
                        }
                    }
                }
            }

            this.close()
        })
    }

    sealed interface POSITION {
        object START : POSITION
        object TOP : POSITION
        object END : POSITION
        object BOTTOM : POSITION
    }

    sealed interface DIRECTION {
        object INSIDE : DIRECTION
        object OUTSIDE : DIRECTION
    }
}

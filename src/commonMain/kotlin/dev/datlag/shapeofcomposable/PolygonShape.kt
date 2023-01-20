package dev.datlag.shapeofcomposable

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.min
import kotlin.math.max
import kotlin.math.sin

data class PolygonShape(
    val sides: Int
) : ShapeOfComposable {

    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(Path().apply {
            val sides = max(this@PolygonShape.sides, 4)
            val section = (2F * PI / sides).toFloat()
            val polygonSize = min(size.width, size.height)
            val radius = polygonSize / 2F
            val centerX = size.width / 2F
            val centerY = size.height / 2F

            this.moveTo((centerX + radius * cos(0F)), (centerY + radius * sin(0F)))

            for (i in 1 until sides) {
                this.lineTo((centerX + radius * cos(section * i)), (centerY + radius * sin(section * i)))
            }

            this.close()
        })
    }
}

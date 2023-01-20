package dev.datlag.shapeofcomposable

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.PI
import kotlin.math.max
import kotlin.math.sin
import kotlin.math.cos

data class StarShape(
    val points: Int
) : ShapeOfComposable {

    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(Path().apply {
            val points = max(this@StarShape.points, 4)
            val vertices = points * 2
            val alpha = (2F * PI).toFloat() / vertices
            val radius = max(size.width, size.height) / 2F
            val centerX = size.width / 2F
            val centerY = size.height / 2F

            for (i in vertices + 1 downTo 1) {
                val r = radius * (i % 2 + 1) / 2
                val omega = alpha * i
                this.lineTo((r * sin(omega)) + centerX, (r * cos(omega)) + centerY)
            }

            this.close()
        })
    }
}

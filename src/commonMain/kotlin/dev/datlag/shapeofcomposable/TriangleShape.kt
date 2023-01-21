package dev.datlag.shapeofcomposable

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

data class TriangleShape(
    internal val start: Float,
    internal val end: Float,
    internal val bottom: Float,
): ShapeOfComposable {

    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(Path().apply {
            this.moveTo(0F, start * size.height)
            this.lineTo(bottom * size.width, size.height)
            this.lineTo(size.width, end * size.height)

            this.close()
        })
    }
}

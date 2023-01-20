package dev.datlag.shapeofcomposable

import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection

data class BubbleShape(
    val radiusStartTopPx: Float,
    val radiusEndTopPx: Float,
    val radiusStartBottomPx: Float,
    val radiusEndBottomPx: Float,
    val arrowWidthPx: Float,
    val arrowHeightPx: Float,
    val position: POSITION = POSITION.BOTTOM,
    val placement: Float = 0.5F
) : ShapeOfComposable {

    constructor(
        radiusPx: Float,
        arrowWidthPx: Float,
        arrowHeightPx: Float,
        position: POSITION = POSITION.BOTTOM,
        placement: Float = 0.5F
    ) : this(radiusPx, radiusPx, radiusPx, radiusPx, arrowWidthPx, arrowHeightPx, position, placement)

    override fun createOutline(size: Size, layoutDirection: LayoutDirection, density: Density): Outline {
        return Outline.Generic(Path().apply {
            val startTopDiameter = if (radiusStartTopPx < 0) 0F else radiusStartTopPx
            val endTopDiameter = if (radiusEndTopPx < 0) 0F else radiusEndTopPx
            val startBottomDiameter = if (radiusStartBottomPx < 0) 0F else radiusStartBottomPx
            val endBottomDiameter = if (radiusEndBottomPx < 0) 0F else radiusEndBottomPx

            val spacingStart = if (position is POSITION.START) arrowHeightPx else 0F
            val spacingTop = if (position is POSITION.TOP) arrowHeightPx else 0F
            val spacingEnd = if (position is POSITION.END) arrowHeightPx else 0F
            val spacingBottom = if (position is POSITION.BOTTOM) arrowHeightPx else 0F

            val end = size.width - spacingEnd
            val bottom = size.height - spacingBottom

            val centerX = size.width * placement

            this.moveTo(spacingStart + startTopDiameter / 2F, spacingTop)

            if (position is POSITION.TOP) {
                this.lineTo(centerX - arrowWidthPx, spacingTop)
                this.lineTo(centerX, 0F)
                this.lineTo(centerX + arrowWidthPx, spacingTop)
            }
            this.lineTo(end - endTopDiameter / 2F, spacingTop)

            this.quadraticBezierTo(end, spacingTop, end, spacingTop + endTopDiameter / 2F)

            if (position is POSITION.END) {
                this.lineTo(end, bottom - (bottom * (1 - placement)) - arrowWidthPx)
                this.lineTo(size.width, bottom - (bottom * (1 - placement)))
                this.lineTo(end, bottom - (bottom * (1 - placement)) + arrowWidthPx)
            }
            this.lineTo(end, bottom - endBottomDiameter / 2F)

            this.quadraticBezierTo(end, bottom, end - endBottomDiameter / 2F, bottom)

            if (position is POSITION.BOTTOM) {
                this.lineTo(centerX + arrowWidthPx, bottom)
                this.lineTo(centerX, size.height)
                this.lineTo(centerX - arrowWidthPx, bottom)
            }
            this.lineTo(spacingStart + startBottomDiameter / 2F, bottom)

            this.quadraticBezierTo(spacingStart, bottom, spacingStart, bottom - startBottomDiameter / 2F)

            if (position is POSITION.START) {
                this.lineTo(spacingStart, bottom - (bottom * (1 - placement)) + arrowWidthPx)
                this.lineTo(0F, bottom - (bottom * (1 - placement)))
                this.lineTo(spacingStart, bottom - (bottom * (1 - placement)) - arrowWidthPx)
            }
            this.lineTo(spacingStart, spacingTop + startTopDiameter / 2F)

            this.quadraticBezierTo(spacingStart, spacingTop, spacingStart + startTopDiameter / 2F, spacingTop)

            this.close()
        })
    }

    sealed interface POSITION {
        object START : POSITION
        object TOP : POSITION
        object END : POSITION
        object BOTTOM : POSITION
    }
}

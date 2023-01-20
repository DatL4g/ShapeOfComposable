package dev.datlag.shapeofcomposable

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape as Circle

sealed interface ShapeOfComposable : Shape {
    companion object {
        val CircleShape = Circle
    }
}

@Composable
fun ArcShape(
    arcSize: Dp,
    position: ArcShape.POSITION = ArcShape.POSITION.BOTTOM,
    direction: ArcShape.DIRECTION = ArcShape.DIRECTION.OUTSIDE,
    density: Density = LocalDensity.current
) = with(density) {
    ArcShape(arcSize.toPx(), position, direction)
}

@Composable
fun BubbleShape(
    radius: Dp = 0.dp,
    arrowWidth: Dp,
    arrowHeight: Dp,
    position: BubbleShape.POSITION = BubbleShape.POSITION.BOTTOM,
    placement: Float = 0.5F,
    density: Density = LocalDensity.current
) = with(density) {
    BubbleShape(
        radius.toPx(),
        arrowWidth.toPx(),
        arrowHeight.toPx(),
        position,
        placement
    )
}

@Composable
fun BubbleShape(
    radiusStartTop: Dp = 0.dp,
    radiusEndTop: Dp = 0.dp,
    radiusStartBottom: Dp = 0.dp,
    radiusEndBottom: Dp = 0.dp,
    arrowWidth: Dp,
    arrowHeight: Dp,
    position: BubbleShape.POSITION = BubbleShape.POSITION.BOTTOM,
    placement: Float = 0.5F,
    density: Density = LocalDensity.current
) = with(density) {
    BubbleShape(
        radiusStartTop.toPx(),
        radiusEndTop.toPx(),
        radiusStartBottom.toPx(),
        radiusEndBottom.toPx(),
        arrowWidth.toPx(),
        arrowHeight.toPx(),
        position,
        placement
    )
}

@Composable
fun DottedEdgesCutCornerShape(
    startTopCutSize: Dp = 0.dp,
    endTopCutSize: Dp = 0.dp,
    startBottomCutSize: Dp = 0.dp,
    endBottomCutSize: Dp = 0.dp,
    dotPositions: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Dp = 0.dp,
    dotSpacing: Dp = 0.dp,
    density: Density = LocalDensity.current
) = with(density) {
    DottedEdgesCutCornerShape(
        CornerSize(startTopCutSize),
        CornerSize(endTopCutSize),
        CornerSize(startBottomCutSize),
        CornerSize(endBottomCutSize),
        dotPositions,
        dotRadius.toPx(),
        dotSpacing.toPx()
    )
}

@Composable
fun DottedEdgesCutCornerShape(
    cutSize: Dp = 0.dp,
    dotPositions: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Dp = 0.dp,
    dotSpacing: Dp = 0.dp,
    density: Density = LocalDensity.current
) = with(density) {
    DottedEdgesCutCornerShape(
        CornerSize(cutSize),
        dotPositions,
        dotRadius.toPx(),
        dotSpacing.toPx()
    )
}

@Composable
fun DottedEdgesCutCornerShape(
    startTopCutSize: CornerSize = CornerSize(0F),
    endTopCutSize: CornerSize = CornerSize(0F),
    startBottomCutSize: CornerSize = CornerSize(0F),
    endBottomCutSize: CornerSize = CornerSize(0F),
    dotPositions: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Dp = 0.dp,
    dotSpacing: Dp = 0.dp,
    density: Density = LocalDensity.current
) = with(density) {
    DottedEdgesCutCornerShape(
        startTopCutSize,
        endTopCutSize,
        startBottomCutSize,
        endBottomCutSize,
        dotPositions,
        dotRadius.toPx(),
        dotSpacing.toPx()
    )
}

@Composable
fun DottedEdgesCutCornerShape(
    cutSize: CornerSize = CornerSize(0F),
    dotPositions: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Dp = 0.dp,
    dotSpacing: Dp = 0.dp,
    density: Density = LocalDensity.current
) = with(density) {
    DottedEdgesCutCornerShape(
        cutSize,
        dotPositions,
        dotRadius.toPx(),
        dotSpacing.toPx()
    )
}
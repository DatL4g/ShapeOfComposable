package dev.datlag.shapeofcomposable.common

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.datlag.shapeofcomposable.*

@Composable
fun Modifier.arcShape(
    arcSize: Dp,
    position: ArcShape.POSITION = ArcShape.POSITION.BOTTOM,
    direction: ArcShape.DIRECTION = ArcShape.DIRECTION.OUTSIDE,
    density: Density = LocalDensity.current
) = this.clip(ArcShape(arcSize, position, direction, density))

@Composable
fun Modifier.arcShape(
    arcSize: Float,
    position: ArcShape.POSITION = ArcShape.POSITION.BOTTOM,
    direction: ArcShape.DIRECTION = ArcShape.DIRECTION.OUTSIDE
) = this.clip(ArcShape(arcSize, position, direction))

@Composable
fun Modifier.bubbleShape(
    radius: Dp = 0.dp,
    arrowWidth: Dp,
    arrowHeight: Dp,
    position: BubbleShape.POSITION = BubbleShape.POSITION.BOTTOM,
    placement: Float = 0.5F,
    density: Density = LocalDensity.current
) = this.clip(BubbleShape(radius, arrowWidth, arrowHeight, position, placement, density))

@Composable
fun Modifier.bubbleShape(
    radiusStartTop: Dp = 0.dp,
    radiusEndTop: Dp = 0.dp,
    radiusStartBottom: Dp = 0.dp,
    radiusEndBottom: Dp = 0.dp,
    arrowWidth: Dp,
    arrowHeight: Dp,
    position: BubbleShape.POSITION = BubbleShape.POSITION.BOTTOM,
    placement: Float = 0.5F,
    density: Density = LocalDensity.current
) = this.clip(BubbleShape(radiusStartTop, radiusEndTop, radiusStartBottom, radiusEndBottom, arrowWidth, arrowHeight, position, placement, density))

@Composable
fun Modifier.bubbleShape(
    radiusPx: Float,
    arrowWidthPx: Float,
    arrowHeightPx: Float,
    position: BubbleShape.POSITION = BubbleShape.POSITION.BOTTOM,
    placement: Float = 0.5F
) = this.clip(BubbleShape(radiusPx, arrowWidthPx, arrowHeightPx, position, placement))

@Composable
fun Modifier.bubbleShape(
    radiusStartTopPx: Float,
    radiusEndTopPx: Float,
    radiusStartBottomPx: Float,
    radiusEndBottomPx: Float,
    arrowWidthPx: Float,
    arrowHeightPx: Float,
    position: BubbleShape.POSITION = BubbleShape.POSITION.BOTTOM,
    placement: Float = 0.5F
) = this.clip(BubbleShape(radiusStartTopPx, radiusEndTopPx, radiusStartBottomPx, radiusEndBottomPx, arrowWidthPx, arrowHeightPx, position, placement))

@Composable
fun Modifier.diagonalShape(
    angle: Float,
    position: DiagonalShape.POSITION = DiagonalShape.POSITION.TOP
) = this.clip(DiagonalShape(angle, position))

@Composable
fun Modifier.polygonShape(
    sides: Int
) = this.clip(PolygonShape(sides))

@Composable
fun Modifier.starShape(
    points: Int
) = this.clip(StarShape(points))

@Composable
fun Modifier.triangleShape(
    start: Float,
    end: Float,
    bottom: Float
) = this.clip(TriangleShape(start, end, bottom))

@Composable
fun Modifier.dottedEdgesShape(
    startTopCutSize: CornerSize = CornerSize(0F),
    endTopCutSize: CornerSize = CornerSize(0F),
    startBottomCutSize: CornerSize = CornerSize(0F),
    endBottomCutSize: CornerSize = CornerSize(0F),
    dotPositions: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Float = 0F,
    dotSpacing: Float = 0F
) = this.clip(
    DottedEdgesCutCornerShape(
        startTopCutSize,
        endTopCutSize,
        startBottomCutSize,
        endBottomCutSize,
        dotPositions,
        dotRadius,
        dotSpacing
    )
)

@Composable
fun Modifier.dottedEdgesShape(
    cutSize: CornerSize = CornerSize(0F),
    dotPositions: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Float = 0F,
    dotSpacing: Float = 0F
) = this.clip(DottedEdgesCutCornerShape(cutSize, dotPositions, dotRadius, dotSpacing))

@Composable
fun Modifier.dottedEdgesShape(
    startTopCutSize: CornerSize = CornerSize(0F),
    endTopCutSize: CornerSize = CornerSize(0F),
    startBottomCutSize: CornerSize = CornerSize(0F),
    endBottomCutSize: CornerSize = CornerSize(0F),
    dotPosition: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Dp = 0.dp,
    dotSpacing: Dp = 0.dp
) = this.clip(
    DottedEdgesCutCornerShape(
        startTopCutSize,
        endTopCutSize,
        startBottomCutSize,
        endBottomCutSize,
        dotPosition, dotRadius, dotSpacing
    )
)

@Composable
fun Modifier.dottedEdgesShape(
    cutSize: CornerSize = CornerSize(0F),
    dotPosition: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Dp = 0.dp,
    dotSpacing: Dp = 0.dp
) = this.clip(DottedEdgesCutCornerShape(cutSize, dotPosition, dotRadius, dotSpacing))

@Composable
fun Modifier.dottedEdgesShape(
    startTopCutSize: Dp = 0.dp,
    endTopCutSize: Dp = 0.dp,
    startBottomCutSize: Dp = 0.dp,
    endBottomCutSize: Dp = 0.dp,
    dotPosition: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Dp = 0.dp,
    dotSpacing: Dp = 0.dp,
) = this.clip(DottedEdgesCutCornerShape(startTopCutSize, endTopCutSize, startBottomCutSize, endBottomCutSize, dotPosition, dotRadius, dotSpacing))

@Composable
fun Modifier.dottedEdgesShape(
    cutSize: Dp = 0.dp,
    dotPosition: Collection<DottedEdgesCutCornerShape.POSITION>,
    dotRadius: Dp = 0.dp,
    dotSpacing: Dp = 0.dp,
) = this.clip(DottedEdgesCutCornerShape(cutSize, dotPosition, dotRadius, dotSpacing))


@Composable
fun Modifier.cutCornerShape(
    cutSize: CornerSize = CornerSize(0F)
) = this.clip(CutCornerShape(cutSize))

@Composable
fun Modifier.cutCornerShape(
    cutSize: Dp = 0.dp
) = this.clip(CutCornerShape(cutSize))

@Composable
fun Modifier.cutCornerShape(
    cutSize: Float = 0F
) = this.clip(CutCornerShape(cutSize))

@Composable
fun Modifier.cutCornerShape(
    startTopCutSize: CornerSize = CornerSize(0F),
    endTopCutSize: CornerSize = CornerSize(0F),
    startBottomCutSize: CornerSize = CornerSize(0F),
    endBottomCutSize: CornerSize = CornerSize(0F),
) = this.clip(CutCornerShape(startTopCutSize, endTopCutSize, endBottomCutSize, startBottomCutSize))

@Composable
fun Modifier.cutCornerShape(
    startTopCutSize: Dp = 0.dp,
    endTopCutSize: Dp = 0.dp,
    startBottomCutSize: Dp = 0.dp,
    endBottomCutSize: Dp = 0.dp,
) = this.clip(CutCornerShape(startTopCutSize, endTopCutSize, endBottomCutSize, startBottomCutSize))

@Composable
fun Modifier.cutCornerShape(
    startTopCutSize: Float = 0F,
    endTopCutSize: Float = 0F,
    startBottomCutSize: Float = 0F,
    endBottomCutSize: Float = 0F,
) = this.clip(CutCornerShape(startTopCutSize, endTopCutSize, endBottomCutSize, startBottomCutSize))

@Composable
fun Modifier.circleShape() = this.clip(ShapeOfComposable.CircleShape)

@Composable
fun Modifier.roundedCornerShape(
    cutSize: CornerSize = CornerSize(0F)
) = this.clip(RoundedCornerShape(cutSize))

@Composable
fun Modifier.roundedCornerShape(
    cutSize: Dp = 0.dp
) = this.clip(RoundedCornerShape(cutSize))

@Composable
fun Modifier.roundedCornerShape(
    cutSize: Float = 0F
) = this.clip(RoundedCornerShape(cutSize))

@Composable
fun Modifier.roundedCornerShape(
    startTopCutSize: CornerSize = CornerSize(0F),
    endTopCutSize: CornerSize = CornerSize(0F),
    startBottomCutSize: CornerSize = CornerSize(0F),
    endBottomCutSize: CornerSize = CornerSize(0F),
) = this.clip(RoundedCornerShape(startTopCutSize, endTopCutSize, endBottomCutSize, startBottomCutSize))

@Composable
fun Modifier.roundedCornerShape(
    startTopCutSize: Dp = 0.dp,
    endTopCutSize: Dp = 0.dp,
    startBottomCutSize: Dp = 0.dp,
    endBottomCutSize: Dp = 0.dp,
) = this.clip(RoundedCornerShape(startTopCutSize, endTopCutSize, endBottomCutSize, startBottomCutSize))

@Composable
fun Modifier.roundedCornerShape(
    startTopCutSize: Float = 0F,
    endTopCutSize: Float = 0F,
    startBottomCutSize: Float = 0F,
    endBottomCutSize: Float = 0F,
) = this.clip(RoundedCornerShape(startTopCutSize, endTopCutSize, endBottomCutSize, startBottomCutSize))
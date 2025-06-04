package com.carousel.compose

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.fontscaling.MathUtils.lerp
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CarouselEffect(
    onClick: (index: Int) -> Unit,
    listSize: Int = 5,
    scale: Float=0.95f,
    alpha: Float=0.5f,
    content: @Composable (index: Int) -> Unit
) {
    val virtualPages = listSize * 1000
    val startIndex = virtualPages / 2

    val pagerState = rememberPagerState(
        initialPage = startIndex,
        pageCount = { virtualPages }
    )

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentPadding = PaddingValues(horizontal = 50.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) { page ->
        val actualPage = page % listSize
        val pageOffset = (
                pagerState.currentPage - page +
                        pagerState.currentPageOffsetFraction
                )

        val clampedOffset = pageOffset.absoluteValue.coerceIn(0f, 1f)
        val scale = lerp(scale, 1f, 1f - clampedOffset)
        val alpha = lerp(alpha, 1f, 1f - clampedOffset)

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    this.alpha = alpha
                }
                .fillMaxWidth(1f)
                .aspectRatio(1.8f)
                .clickable { onClick(actualPage) }
        ) {
            content(actualPage)
        }
    }
}


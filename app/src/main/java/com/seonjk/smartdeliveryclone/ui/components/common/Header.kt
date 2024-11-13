package com.seonjk.smartdeliveryclone.ui.components.common

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun Header(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    contentColor: Color = SmartDeliveryCloneTheme.colors.background,
    actionButtons: @Composable () -> Unit = {}
) {
//    TopAppBar(
//        title = {
//            Text(
//                text = title,
//                color = SmartDeliveryCloneTheme.colors.titleColor,
//                style = MaterialTheme.typography.titleLarge
//            )
//        },
//        colors = TopAppBarDefaults.smallTopAppBarColors(
//            containerColor = SmartDeliveryCloneTheme.colors.background
//        ),
//        navigationIcon = navigationIcons
//    )

    CompositionLocalProvider(LocalContentColor provides contentColor) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(contentColor)
                .pointerInput(Unit) { /* no-op */}
                .then(modifier)
        ) {
            Text(
                text = stringResource(title),
                color = SmartDeliveryCloneTheme.colors.titleColor,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.align(Alignment.CenterStart)
                    .padding(start = 10.dp)
            )
            Row(Modifier.align(Alignment.CenterEnd)) {
                actionButtons()
            }
        }
    }
}

@Composable
@Preview
fun HeaderPreview() {
    SmartDeliveryCloneTheme {
        Header(title = R.string.app_name)
    }
}
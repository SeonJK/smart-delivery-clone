package com.seonjk.smartdeliveryclone.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun SDCPermissionDialog(
    onClickPositive: () -> Unit,
    onDismissRequest: () -> Unit
) {
    SDCDialog(
        modifier = Modifier,
        title = stringResource(R.string.permission_title),
        description = stringResource(R.string.permission_description),
        positiveText = stringResource(R.string.permission_positive_text),
        onClickPositive = onClickPositive,
        onDismissRequest = onDismissRequest
    )
}

@Preview
@Composable
fun SDCPermissionDialogTest() {
    SmartDeliveryCloneTheme {
        SDCPermissionDialog(onClickPositive = { }) { }
    }
}
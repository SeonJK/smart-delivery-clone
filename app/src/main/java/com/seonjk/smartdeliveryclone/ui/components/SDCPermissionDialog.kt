package com.seonjk.smartdeliveryclone.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.seonjk.smartdeliveryclone.R

@Composable
fun SDCPermissionDialog(
    onClickPositive: () -> Unit,
) {
    val showDialog = remember { mutableStateOf(true) }

    SDCDialog(
        modifier = Modifier,
        title = stringResource(R.string.permission_title),
        description = stringResource(R.string.permission_description),
        positiveText = stringResource(R.string.permission_positive_text),
        onClickPositive = onClickPositive,
        setShowDialog = { showDialog.value = it }
    )
}
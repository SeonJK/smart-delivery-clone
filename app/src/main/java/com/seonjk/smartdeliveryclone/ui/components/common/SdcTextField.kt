package com.seonjk.smartdeliveryclone.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SdcTextField(
    modifier: Modifier,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    maxLines: Int = 1,
    inputText: String,
    onValueChanged: (String) -> Unit
) {
    TextField(
        modifier = modifier.background(Color.Transparent),
        value = inputText,
        onValueChange = {
            onValueChanged(it)
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        placeholder = { Text(text = placeholder) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = SmartDeliveryCloneTheme.colors.primary,
            focusedIndicatorColor = SmartDeliveryCloneTheme.colors.primary,
            unfocusedIndicatorColor = SmartDeliveryCloneTheme.colors.descriptionColor,
            disabledIndicatorColor = SmartDeliveryCloneTheme.colors.descriptionColor,
            cursorColor = SmartDeliveryCloneTheme.colors.primary,
            placeholderColor = SmartDeliveryCloneTheme.colors.descriptionColor,
            containerColor = Color.Transparent,
        ),
        maxLines = maxLines
    )
}

@Preview
@Composable
fun SdcTextFieldTest() {
    SmartDeliveryCloneTheme {
        SdcTextField(
            modifier = Modifier,
            placeholder = "테스트",
            inputText = "",
            onValueChanged = {}
        )
    }
}
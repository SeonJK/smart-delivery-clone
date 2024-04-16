package com.seonjk.smartdeliveryclone.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SdcTextField(
    placeholder: String,
    maxLines: Int = 1
) {
    var text by remember { mutableStateOf("") }
    
    TextField(
        modifier = Modifier.background(Color.Transparent),
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(text = placeholder) },
        colors = TextFieldDefaults.textFieldColors(
            textColor = SmartDeliveryCloneTheme.colors.primary,
            focusedIndicatorColor = SmartDeliveryCloneTheme.colors.primary,
            placeholderColor = SmartDeliveryCloneTheme.colors.descriptionColor,
        ),
        maxLines = maxLines
    )
}

@Preview
@Composable
fun SdcTextFieldTest() {
    SmartDeliveryCloneTheme {
        SdcTextField(placeholder = "테스트")
    }
}
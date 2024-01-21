package com.seonjk.smartdeliveryclone.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun SDCDialog(
    title: String = "",
    description: String = "",
    positiveText: String,
    negativeText: AnnotatedString = AnnotatedString(""),
    onClickPositive: () -> Unit,
    onClickNegative: (Int) -> Unit,
    onCheckedChange: (Boolean) -> Unit = { },
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = com.seonjk.smartdeliveryclone.ui.theme.DimBlack)
            .padding(50.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .background(
                    color = SmartDeliveryCloneTheme.colors.onBackground,
                    shape = RoundedCornerShape(
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
                .padding(12.dp, 12.dp, 12.dp, 0.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = SmartDeliveryCloneTheme.colors.titleColor,
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = SmartDeliveryCloneTheme.colors.descriptionColor,
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        Button(
            onClick = onClickPositive,
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = SmartDeliveryCloneTheme.colors.primary
            ),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                text = positiveText,
                color = Color.White,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(SmartDeliveryCloneTheme.colors.onBackground)
                .padding(6.dp, 0.dp, 12.dp, 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
            ) {
                Checkbox(
                    modifier = Modifier
                        .size(30.dp),
                    checked = false,
                    onCheckedChange = onCheckedChange,
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.LightGray,
                        uncheckedColor = Color.LightGray,
                    ),
                )
                Text(
                    text = "다시 보지 않기",
                    color = Color.LightGray,
                    fontSize = 10.sp,
                )
            }

            ClickableText(
                modifier = Modifier,
                onClick = onClickNegative,
                text = negativeText,
                style = TextStyle(
                    color = Color.LightGray,
                    fontSize = 10.sp,
                )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0x04000000,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(showBackground = true)
@Composable
fun SDCDialogPreview() {
    SmartDeliveryCloneTheme {
        SDCDialog(
            title = "타이틀 텍스트",
            description = "설명 텍스트",
            positiveText = "확인",
            negativeText = AnnotatedString("닫기"),
            onClickPositive = { },
            onClickNegative = { }
        )
    }
}
package com.seonjk.smartdeliveryclone.ui.landing

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme

@Composable
fun ServiceAgreementScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Header()
        Body()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .background(SmartDeliveryCloneTheme.colors.background)
            .statusBarsPadding()
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.service_agreement),
            color = SmartDeliveryCloneTheme.colors.titleColor,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
fun Body() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(SmartDeliveryCloneTheme.colors.background)
            .padding(16.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row (
            modifier = Modifier.fillMaxWidth()
                .background(SmartDeliveryCloneTheme.colors.onBackground)
                .clickable { /* 전체동의 클릭 처리 */ }
                .padding(16.dp),
        ) {
            Icon(
                modifier = Modifier.toggleable(
                    value = false,
                    onValueChange = { value -> /* 전체 동의 처리 */ },
                ),
                imageVector = Icons.Rounded.CheckCircle,
                contentDescription = stringResource(R.string.agree_all),
                tint = SmartDeliveryCloneTheme.colors.descriptionColor
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(R.string.agree_all),
                style = MaterialTheme.typography.titleMedium,
                color = SmartDeliveryCloneTheme.colors.titleColor
            )
            Spacer(modifier = Modifier.weight(2f))
        }

        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = stringResource(R.string.agree_description),
            color = SmartDeliveryCloneTheme.colors.descriptionColor,
            style = MaterialTheme.typography.bodySmall,
        )

        Spacer(modifier = Modifier.height(20.dp))
        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = SmartDeliveryCloneTheme.colors.titleColor
        )

        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
            Icon(
                modifier = Modifier.toggleable(
                    value = false,
                    onValueChange = { value -> /* 서비스 이용약관 동의 처리 */ },
                ),
                imageVector = Icons.Rounded.CheckCircle,
                contentDescription = stringResource(R.string.service_agree),
                tint = SmartDeliveryCloneTheme.colors.descriptionColor
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row(modifier = Modifier.weight(2f)) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(R.string.service_agree),
                    style = MaterialTheme.typography.titleSmall,
                    color = SmartDeliveryCloneTheme.colors.titleColor
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = SmartDeliveryCloneTheme.colors.descriptionColor
                )
            }
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = SmartDeliveryCloneTheme.colors.titleColor
        )

        Row(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
            Icon(
                modifier = Modifier.toggleable(
                    value = false,
                    onValueChange = { value -> /* 개인정보 이용약관 동의 처리 */ },
                ),
                imageVector = Icons.Rounded.CheckCircle,
                contentDescription = stringResource(R.string.private_info_agree),
                tint = SmartDeliveryCloneTheme.colors.descriptionColor
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row(modifier = Modifier.weight(2f)) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = stringResource(R.string.private_info_agree),
                    style = MaterialTheme.typography.titleSmall,
                    color = SmartDeliveryCloneTheme.colors.titleColor
                )
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = SmartDeliveryCloneTheme.colors.descriptionColor
                )
            }
        }

        Divider(
            modifier = Modifier.fillMaxWidth(),
            thickness = 1.dp,
            color = SmartDeliveryCloneTheme.colors.titleColor
        )
    }
}

@Preview(name = "service_agreement", showBackground = true)
@Preview(name = "service_agreement_dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true, backgroundColor = 0xFF2C2C2C
)
@Composable
fun HeaderPreview() {
    SmartDeliveryCloneTheme {
        ServiceAgreementScreen()
    }
}

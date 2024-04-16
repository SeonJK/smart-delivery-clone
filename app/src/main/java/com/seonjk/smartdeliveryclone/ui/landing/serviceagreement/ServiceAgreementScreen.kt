package com.seonjk.smartdeliveryclone.ui.landing.serviceagreement

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.components.common.Header
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import kotlinx.coroutines.coroutineScope
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceAgreementScreen(
    viewModel: ServiceAgreementViewModel = koinViewModel(),
    navigateToPhoneAuthentication: () -> Unit
) {
    Scaffold(
        topBar = {
            Header(
                title = stringResource(R.string.service_agreement)
            )
        },
    ) {
        ServiceAgreementContents(
            padding = it,
            viewModel = viewModel,
            navigateToPhoneAuthentication = navigateToPhoneAuthentication
        )
    }
}

@Composable
fun ServiceAgreementContents(
    padding: PaddingValues,
    viewModel: ServiceAgreementViewModel,
    navigateToPhoneAuthentication: () -> Unit
) {

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
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(SmartDeliveryCloneTheme.colors.onBackground)
                .clickable { viewModel.setServiceAgreementAll(!viewModel.serviceAgreementAll.value) }
                .padding(16.dp),
        ) {
            Icon(
                modifier = Modifier.toggleable(
                    value = false,
                    onValueChange = { value -> /* 전체 동의 처리 */
                        viewModel.setServiceAgreementAll(value)
                        // TODO: 프리퍼런스에 저장 완료되면 폰 인증으로 가도록 구현 필요. join? await?
                        navigateToPhoneAuthentication()
                    },
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Icon(
                modifier = Modifier.toggleable(
                    value = false,
                    onValueChange = { value -> /* 서비스 이용약관 동의 처리 */
                        viewModel.setServiceAgreement(value)
                    },
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        ) {
            Icon(
                modifier = Modifier.toggleable(
                    value = false,
                    onValueChange = { value ->
                        viewModel.setServiceAgreementAll(value)
                    },
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
@Preview(
    name = "service_agreement_dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true, backgroundColor = 0xFF2C2C2C
)
@Composable
fun HeaderPreview() {
    SmartDeliveryCloneTheme {
        ServiceAgreementScreen(
            viewModel = koinViewModel<ServiceAgreementViewModel>(),
            navigateToPhoneAuthentication = {}
        )
    }
}

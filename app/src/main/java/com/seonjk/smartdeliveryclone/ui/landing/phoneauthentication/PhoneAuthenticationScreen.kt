package com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.ui.components.common.Header
import com.seonjk.smartdeliveryclone.ui.components.common.SdcTextField
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneAuthenticationScreen(
    viewModel: PhoneAuthenticationViewModel = viewModel(),
    navigateToMain: () -> Unit
) {
    Scaffold(
        topBar = {
            Header(title = stringResource(R.string.phone_authentication))
        },
    ) {
        PhoneAuthenticationContents(
            padding = it,
            viewModel = viewModel,
            navigateToMain = navigateToMain
        )
    }
}

@Composable
fun PhoneAuthenticationContents(
    padding: PaddingValues,
    viewModel: PhoneAuthenticationViewModel,
    navigateToMain: () -> Unit
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
            modifier = Modifier.fillMaxWidth()
        ) {
            SdcTextField(placeholder = stringResource(id = R.string.phone_num_hint))
            Button(
                modifier = Modifier.weight(1.0f),
                onClick = { /*TODO*/ }
            ) {
                Text(text = stringResource(id = R.string.send_auth_number))
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            SdcTextField(placeholder = stringResource(id = R.string.auth_num_hint))
            Button(
                modifier = Modifier.weight(1.0f),
                onClick = navigateToMain
            ) {
                Text(text = stringResource(id = R.string.confirm))
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = stringResource(id = R.string.phone_auth_description),
            fontSize = 12.sp,
            softWrap = true,
            color = SmartDeliveryCloneTheme.colors.descriptionColor
        )
    }
}

@Preview
@Composable
fun PhoneAuthenticationPreview() {
    SmartDeliveryCloneTheme {
        PhoneAuthenticationScreen(
            viewModel = koinViewModel<PhoneAuthenticationViewModel>(),
            navigateToMain = {}
        )
    }
}
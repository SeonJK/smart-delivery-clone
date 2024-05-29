package com.seonjk.smartdeliveryclone.ui.landing.phoneauthentication

import android.annotation.SuppressLint
import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.seonjk.smartdeliveryclone.R
import com.seonjk.smartdeliveryclone.data.Response
import com.seonjk.smartdeliveryclone.ui.components.common.Header
import com.seonjk.smartdeliveryclone.ui.components.common.SdcTextField
import com.seonjk.smartdeliveryclone.ui.theme.SmartDeliveryCloneTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneAuthenticationScreen(
    viewModel: PhoneAuthenticationViewModel = koinViewModel(),
    navigateToMain: () -> Unit
) {
    Scaffold(
        containerColor = SmartDeliveryCloneTheme.colors.background,
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

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun PhoneAuthenticationContents(
    padding: PaddingValues,
    viewModel: PhoneAuthenticationViewModel,
    navigateToMain: () -> Unit
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    var isSendAuthEnable by remember { mutableStateOf(true) }
    lifecycleOwner.lifecycleScope.launch {
        lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.sendMessageState.collect { res ->
                isSendAuthEnable = when (res) {
                    Response.Unspecified -> true
                    Response.Loading -> false
                    is Response.Success<*> -> false
                    is Response.Error<*> -> true
                }
            }
        }
    }

    val INITIAL_TIMER_VALUE = 30
    var timer by remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = viewModel.sendMessageState) {
        when (viewModel.sendMessageState) {
            is Response.Success<*> -> {
                isSendAuthEnable = false
                if (res.data == true) {
                    timer = INITIAL_TIMER_VALUE
                    while (timer > 0) {
                        delay(1000L)
                        timer--
                    }
                }
            }

            else -> timer = 0
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(SmartDeliveryCloneTheme.colors.background)
            .padding(paddingValues = padding)
            .padding(16.dp, 0.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        val context = LocalContext.current

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {

            var phoneNum by remember { mutableStateOf("") }

            SdcTextField(
                modifier = Modifier.weight(1.5f),
                placeholder = stringResource(id = R.string.phone_num_hint),
                keyboardType = KeyboardType.Number,
                inputText = phoneNum,
            ) {
                phoneNum = it
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                modifier = Modifier.weight(1.0f),
                onClick = { viewModel.sendAuthMessage(phoneNum, context as Activity) },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = SmartDeliveryCloneTheme.colors.primary,
                    disabledContainerColor = SmartDeliveryCloneTheme.colors.onBackground,
                    contentColor = SmartDeliveryCloneTheme.colors.titleColor,
                    disabledContentColor = SmartDeliveryCloneTheme.colors.titleColor
                ),
                enabled = phoneNum != "" && isSendAuthEnable
            ) {
                Text(
                    text = if (timer > 0) timer.toString()
                    else stringResource(id = R.string.send_auth_number),
                    maxLines = 1
                )
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {

            var authNum by remember { mutableStateOf("") }
            lifecycleOwner.lifecycleScope.launch {
                lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.verificationState.collect { res ->
                        when (res) {
                            Response.Unspecified -> Unit
                            Response.Loading -> Unit
                            is Response.Success<*> -> {
                                if (res.data == true)
                                    navigateToMain()
                            }

                            is Response.Error<*> -> {
                                authNum = ""
                                Toast.makeText(context, "인증번호가 일치하지 않습니다. 다시 시도해주세요.", Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }
            }

            SdcTextField(
                modifier = Modifier.weight(1.5f),
                placeholder = stringResource(id = R.string.auth_num_hint),
                keyboardType = KeyboardType.Number,
                inputText = authNum
            ) {
                authNum = it
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                modifier = Modifier.weight(1.0f),
                onClick = {
                    runBlocking {
                        // TODO: 인증번호 일치 확인
                        viewModel.verifyAuthCode(authNum)
                    }
                },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = SmartDeliveryCloneTheme.colors.primary,
                    disabledContainerColor = SmartDeliveryCloneTheme.colors.onBackground,
                    contentColor = SmartDeliveryCloneTheme.colors.titleColor,
                    disabledContentColor = SmartDeliveryCloneTheme.colors.titleColor
                ),
                enabled = authNum != ""
            ) {
                Text(text = stringResource(id = R.string.confirm))
            }
        }

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = stringResource(id = R.string.phone_auth_description),
            fontSize = 11.sp,
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
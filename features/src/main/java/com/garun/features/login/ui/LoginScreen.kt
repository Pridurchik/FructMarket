package com.garun.features.login.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.garun.base.theme.GreenButtonAndText
import com.garun.base.theme.GreyColor
import com.garun.base.theme.GreyHintColor
import com.garun.features.R

@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier
            .padding(
                top = 20.dp,
                start = 20.dp,
                end = 30.dp
            )
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Image(
                modifier = Modifier
                    .size(30.dp)
                    .fillMaxWidth()
                ,
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = null
            )

        }


        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ) {

            Image(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(top = 20.dp),
                painter = painterResource(R.drawable.icon_man),
                contentDescription = null,
                contentScale = ContentScale.FillHeight
            )

            Text(
                modifier = Modifier.padding(top = 70.dp),
                text = "Login",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                color = GreenButtonAndText

            )

        }

        TextFieldLoginScreen(
            hintText = "yourmail@mailcom",
            topText = "email"
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        TextFieldLoginScreen(
            hintText = "your password",
            topText = "password",
            passwordMode = true,
            isForgotPass = true
        ) { }

        ButtonChoosingScreen(
            modifier = Modifier.padding(top = 50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = GreenButtonAndText),
            textButton = "Login",
            textPadding = 8.dp,
            shapeButton = RoundedCornerShape(10.dp),
            textColor = Color.White
        ) { }

        Row(
            modifier = Modifier.fillMaxWidth().padding(30.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Not have an account? ",
                color = GreenButtonAndText,
                fontSize = 14.sp
            )

            Text(
                text = "Register",
                color = GreenButtonAndText,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun PreviewLoginScreen() {
    LoginScreen()
}

@Composable
private fun ButtonChoosingScreen(
    modifier: Modifier,
    colors: ButtonColors,
    textButton: String,
    textPadding: Dp,
    borderStroke: BorderStroke? = null,
    textColor: Color? = null,
    shapeButton: Shape? = null,
    icon: Painter? = null,
    onClick: () -> Unit,
) {

    Button(
        modifier = modifier,
        onClick = {
            onClick.invoke()
        },
        colors = colors,
        border = borderStroke,
        shape = shapeButton ?: ButtonDefaults.shape

    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            if (icon != null) {
                Icon(
                    painter = icon,
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .align(Alignment.CenterStart) // Иконка слева
                        .padding(start = 16.dp)
                        .size(24.dp)
                )
            }

            Text(
                modifier = Modifier.align(Alignment.Center).padding(vertical = textPadding),
                text = textButton,
                fontWeight = FontWeight.Medium,
                color = textColor ?: Color.Unspecified,
                fontSize = 17.sp

            )

        }

    }

}

@Composable
private fun TextFieldLoginScreen(
    hintText: String = "",
    topText: String = "",
    passwordMode: Boolean = false,
    isForgotPass: Boolean = false,
    onClickForgotPass: () -> Unit = {}
) {
    val textFieldState = remember {
        mutableStateOf("")
    }

    val passwordHiddenState = remember {
        mutableStateOf(passwordMode)
    }

    Column {
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = topText,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )

        TextField(
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
            value = textFieldState.value,
            onValueChange = { newString ->
                textFieldState.value = newString
            },
            placeholder = {
                Text(text = hintText)
            },
            visualTransformation = if(passwordHiddenState.value)
                PasswordVisualTransformation()
            else VisualTransformation.None,
            trailingIcon = {
                if (passwordMode) {
                    val icon = if (passwordHiddenState.value) {
                        painterResource(R.drawable.icon_visibility_off)
                    } else {
                        painterResource(R.drawable.icon_visibility)
                    }

                    IconButton (
                        onClick = {
                            passwordHiddenState.value = !passwordHiddenState.value
                        }
                    ) {
                       Icon(
                           modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, end = 10.dp),
                           painter = icon,
                           contentDescription = null
                       )
                    }
                } else {

                }
            },
            shape = RoundedCornerShape(12.dp),
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,

                focusedContainerColor = GreyColor,
                unfocusedContainerColor = GreyColor,
                disabledContainerColor = GreyColor,

                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                disabledTextColor = Color.Black,

                disabledPlaceholderColor = GreyHintColor,
                focusedPlaceholderColor = GreyHintColor,
                unfocusedPlaceholderColor = GreyHintColor,
            )
        )

        if(isForgotPass) {
            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp, end = 2.dp),
                 horizontalArrangement = Arrangement.End
            ) {
                Text(
                    modifier = Modifier
                        .clickable {
                        onClickForgotPass.invoke()
                    },
                    color = GreenButtonAndText,
                    text = "Forgot password",
                    fontSize = 12.sp
                )
            }
        }

    }

}


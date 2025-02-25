package com.garun.features.choosing_enter.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.garun.base.theme.BlueButton
import com.garun.base.theme.GreenButtonAndText
import com.garun.features.R


@Composable
fun ChoosingScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(top = 50.dp),
            painter = painterResource(R.drawable.icon_logo),
            contentDescription = null,
        )

        Image(
            modifier = Modifier
                .padding(top = 55.dp)
                .fillMaxWidth()
                .padding(horizontal = 60.dp),
            painter = painterResource(R.drawable.icon_two_people),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        ButtonChoosingScreen(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp, start = 25.dp, end = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = GreenButtonAndText
            ),
            textColor = Color.White,
            textButton = "Login",
            shapeButton = RoundedCornerShape(10.dp),
            textPadding = 8.dp
        ) { }


        ButtonChoosingScreen(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 25.dp, end = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            borderStroke = BorderStroke(2.dp, GreenButtonAndText),
            textColor = GreenButtonAndText,
            textButton = "Register",
            shapeButton = RoundedCornerShape(10.dp),
            textPadding = 8.dp
        ) { }


        Row(
            modifier = Modifier
                .padding(top = 35.dp, start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .weight(1f)
                    .padding(end = 10.dp)
                    .background(Color(0xFF828282))
            )

            Text(
                text = "Or login with",
            )

            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .weight(1f)
                    .padding(start = 10.dp)
                    .background(Color(0xFF828282))
            )
        }



        ButtonChoosingScreen(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 25.dp, end = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            ),
            borderStroke = BorderStroke(2.dp, GreenButtonAndText),
            textColor = GreenButtonAndText,
            textButton = "Google",
            shapeButton = RoundedCornerShape(10.dp),
            icon = painterResource(R.drawable.icon_google),
            textPadding = 5.dp
        ) { }


        ButtonChoosingScreen(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 25.dp, end = 25.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = BlueButton
            ),
            textColor = Color.White,
            textButton = "Facebook",
            shapeButton = RoundedCornerShape(10.dp),
            icon = painterResource(R.drawable.icon_facebook),
            textPadding = 5.dp
        ) { }
    }
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

@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
private fun PreviewTest() {
    ChoosingScreen()
}

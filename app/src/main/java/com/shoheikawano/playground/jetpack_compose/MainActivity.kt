package com.shoheikawano.playground.jetpack_compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.core.sp
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.HeightSpacer
import androidx.ui.layout.Spacing
import androidx.ui.material.AlertDialog
import androidx.ui.material.MaterialTheme
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                dialog()
                mainContent()
            }
        }
    }
}

@Composable
fun dialog() {
    val openDialog = +state { true }

    MaterialTheme {
        if (openDialog.value) {
            AlertDialog(
                text = {},
                onCloseRequest = { openDialog.value = false }
            ) {
                MaterialTheme {
                    Text(
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 24.sp
                        ),
                        text = "Dialog"
                    )
                }
            }
        }
    }
}

@Composable
fun greetings() {
    for (i in 0..10) {
        Text(
            text = "Android$i",
            style = TextStyle(fontSize = 24.sp)
        )
    }
}

@Composable
fun cardImage() {
    Container(
        modifier = Spacing(16.dp),
        expanded = true,
        height = 180.dp
    ) {
        imageResource(R.drawable.ic_header)
    }
}

@Composable
fun mainContent() {
    Column {
        cardImage()
        greetings()
        HeightSpacer(16.dp)
    }
}

// Note: @Preview has to be placed on top, and the preview compose function can't be private.
@Preview
@Composable
fun MainContentPreviewPreview() {
    MaterialTheme {
        mainContent()
    }
}

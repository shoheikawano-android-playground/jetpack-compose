package com.shoheikawano.playground.jetpack_compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.compose.unaryPlus
import androidx.ui.core.*
import androidx.ui.foundation.Dialog
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
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
            Dialog(onCloseRequest = { openDialog.value = false }) {
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
        Clip(shape = RoundedCornerShape(8.dp)) {
            DrawImage(image = +imageResource(R.drawable.ic_header))
        }
    }
}

@Composable
fun mainContent() {
    VerticalScroller {
        Column(crossAxisSize = LayoutSize.Expand) {
            cardImage()
            greetings()
            HeightSpacer(16.dp)
        }
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

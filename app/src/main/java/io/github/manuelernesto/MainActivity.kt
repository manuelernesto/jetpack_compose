package io.github.manuelernesto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.Column
import androidx.ui.layout.Container
import androidx.ui.layout.FlexColumn
import androidx.ui.layout.Padding
import androidx.ui.material.MaterialTheme
import androidx.ui.material.TopAppBar
import androidx.ui.material.surface.Card
import androidx.ui.material.themeColor
import androidx.ui.material.themeTextStyle
import androidx.ui.res.imageResource
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            app()
        }
    }
}

@Preview
@Composable
fun app() {
    MaterialTheme(
    ) {
        FlexColumn {
            inflexible {
                appBar()
            }
            expanded(flex = 1f) {
                VerticalScroller() {
                    Column {
                        for (i in 1..5)
                            appBody()
                    }
                }
            }
        }
    }
}


@Composable
fun appBar() {
    TopAppBar(
        title = { Text(text = "JetPack Compose") },
        color = +themeColor { secondary }
    )
}

@Composable
fun appBody() {
    Padding(padding = 8.dp) {
        Card(shape = RoundedCornerShape(size = 8.dp)) {
            val img = +imageResource(R.drawable.addev)
            Column {
                Container(expanded = true, height = 200.dp) {
                    DrawImage(image = img)
                }
                Padding(left = 8.dp, right = 8.dp, top = 8.dp) {
                    Text(text = "Manuel Ernesto", style = +themeTextStyle { h6 })
                }
                Padding(left = 8.dp, right = 8.dp) {
                    Text(text = "Software Engineer", style = +themeTextStyle { body2 })
                }
                Padding(left = 8.dp, right = 8.dp, bottom = 8.dp) {
                    Text(text = "Disruption Lab", style = +themeTextStyle { body2 })
                }
            }

        }
    }

}


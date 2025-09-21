package net.jsbase.android2025

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.jsbase.android2025.ui.theme.Android2025Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Android2025Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArticlePreview(
                        modifier = Modifier.fillMaxSize()
                    )
//                    GreetingImage(
//                        message = stringResource(R.string.hello_android_2025),
//                        from = stringResource(R.string.from_2apps),
//                        modifier = Modifier
//                            .fillMaxSize()
//                    )
                    // Greeting(message = "Hello, Android 2025!", from = "From 2apps")
                }
            }
        }
    }
}

@Composable
fun Greeting(message: String, from: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 60.sp,
            lineHeight = 86.sp,
            textAlign = TextAlign.Center,
        )
        Text(
            text=from,
            fontSize = 26.sp,
            modifier = Modifier
                .padding(8.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
    }

}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Greeting(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)

        )
    }
}

@Composable
fun ArticlePreview(modifier: Modifier) {
    var isShow = false
    // layer 1: image, article
    // layer 2: menu icon
    val image = painterResource(R.drawable.androidparty)
    Box( modifier=modifier.padding(16.dp) ){
        Column(Modifier
            .fillMaxHeight()) {
            Box(Modifier.fillMaxHeight(0.2f)){
                Image(
                    painter = image,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                )
            }
            Column(){
                Text(
                    text= stringResource(R.string.article_title),
                    fontSize = 24.sp,
                    lineHeight = 30.sp,
                    modifier = Modifier
                        .padding(bottom = 16.dp, top = 16.dp)
                )
                Text(
                    text= stringResource(R.string.article_content),
                    textAlign = TextAlign.Justify,
                )
            }
        }
        Button(
            onClick = {

            },
            colors = ButtonDefaults.textButtonColors(),
            contentPadding = PaddingValues(
                start = 4.dp,
                top = 4.dp,
                end = 4.dp,
                bottom = 4.dp
            ),
            modifier = Modifier
                .width(36.dp)
                .height(36.dp)
            ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                modifier = Modifier.fillMaxSize()
            )
        }
        MarkAsDone(modifier, isShow=isShow)
    }
}

@Composable
fun MarkAsDone(modifier: Modifier, isShow: Boolean){
    AnimatedVisibility(visible = isShow) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = "All task completed!",
            )
            Text(
                text = "Nice work",
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = false,
    name = "My Preview"
)
@Composable
fun GreetingPreview() {
    Android2025Theme {
        ArticlePreview(
            modifier = Modifier.fillMaxSize()
        )
        // Greeting(message = "Hello, Android 2025!", from = "From 2apps")
//        GreetingImage(
//            message = stringResource(R.string.hello_android_2025),
//            from = stringResource(R.string.from_2apps),
//            modifier = Modifier
//                .fillMaxSize()
//        )
    }
}
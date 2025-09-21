package net.jsbase.android2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
                    GreetingImage(
                        message = stringResource(R.string.hello_android_2025),
                        from = stringResource(R.string.from_2apps),
                        modifier = Modifier
                            .fillMaxSize()
                    )
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
//    Row {
//        Text(text="column1")
//        Text(text="column2")
//        Text(text=from, fontSize = 32.sp)
//        Text(
//            text = message,
//            fontSize = 100.sp,
//            lineHeight = 116.sp,
//        )
//    }
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

@Preview(
    showBackground = true,
    showSystemUi = false,
    name = "My Preview"
)
@Composable
fun GreetingPreview() {
    Android2025Theme {
        // Greeting(message = "Hello, Android 2025!", from = "From 2apps")
        GreetingImage(
            message = stringResource(R.string.hello_android_2025),
            from = stringResource(R.string.from_2apps),
            modifier = Modifier
                .fillMaxSize()
        )
    }
}
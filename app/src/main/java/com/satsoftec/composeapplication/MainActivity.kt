package com.satsoftec.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satsoftec.composeapplication.ui.theme.composeApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val typography = MaterialTheme.typography
            composeApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(
                        modifier = Modifier.padding(12.dp, 15.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.mipmap.header),
                            contentDescription = null,
                            modifier = Modifier
                                .height(180.dp)
                                .fillMaxWidth()
                                .clip(shape = RoundedCornerShape(6.dp)),
                            contentScale = ContentScale.FillBounds

                        )
                        Spacer(Modifier.height(16.dp))
                        Greeting("Google")
                        Text(
                            text = "Hello Android! ",
                            style = typography.h3
                        )
                        Text(
                            text = "A day wandering through the a few sandhills " +
                                    "in Shark Fin Cove, and a few of the " +
                                    "sights I saw",
                            style = typography.h5,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                        Text(
                            text = "Android Hello Google!",
                            style = typography.body2
                        )
                        val nameList = mutableListOf("adb", "shell", "push", "root")
                        NewStory(nameList)
                        ListWithBug(nameList)
                    }

                }
            }
        }
    }
}

@Composable
fun ClickCounter(clicks: Int, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "I've been clicked $clicks times")
    }
}

@Composable
fun Greeting(name: String) {
    val typography = MaterialTheme.typography
    Row(horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = Modifier.padding(15.dp)) {
            Text(
                text = "Hello $name!",
                style = typography.h6,
                color = Color.White,
            )
            Text(
                text = "Hello  ${"$name  $name"}!,",
                style = typography.h6,
                color = Color.White
            )
        }
        Text(
            text = "$name Hello $name!",
            style = typography.h6,
            color = Color.White
        )
    }

}


private var items: Int = 0
@Composable
fun ListWithBug(myList: List<String>) {

    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier = Modifier.padding(6.dp)) {
            for (item in myList) {
                Text("Item: $item")
                items++
            }
        }
        Column(modifier = Modifier.padding(6.dp)) {
            Text("Count: $items")
        }
    }
}

@Composable
fun RowText() {

}

@Composable
fun NewStory(nameList: List<String>) {
    for (name in nameList) {
        Text(text = "this is $name", style = MaterialTheme.typography.h6,
            color = Color.White)
    }
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFF000000)
@Composable
fun PreviewGreeting() {
    composeApplicationTheme {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Image(
                painter = painterResource(id = R.mipmap.header),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(6.dp)),
                contentScale = ContentScale.FillBounds
            )
            Text(text = "A day wandering through the a few sandhills " +
                    "in Shark Fin Cove, and a few of the " +
                    "sights I saw",
                style = MaterialTheme.typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Red)
            Greeting("Google")
            val nameList = mutableListOf("adb", "shell", "push", "root")
            NewStory(nameList)
        }
    }
}
//@Preview(showBackground = true)
//@Composable
//fun DefaultForPreview() {
//    composeApplicationTheme {
//        Greeting("Google!!!")
//    }
//}
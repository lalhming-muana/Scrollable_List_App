package com.example.scollable_list_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.model.Topic
import com.example.scollable_list_app.ui.theme.Scollable_list_appTheme
import com.example.scrollable_list_app.R

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scollable_list_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun TopicCard(topic: com.example.model.Topic, modifier: Modifier = Modifier ){

    Row(){

        Image(
            painter = painterResource(topic.imageRes),
            contentDescription = null,
            modifier = Modifier.height(68.dp)
                               .width(68.dp)
        )
        Column(){
            Text(
                text = stringResource(topic.name),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom =8.dp )
            )

            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center){
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(start = 16.dp)
                    )

                    Text(
                        text = topic.availableCourses.toString(),
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)

                    )
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Scollable_list_appTheme {
        Greeting("Android")
    }
}

@Preview
@Composable
fun CardPreview(){
    Scollable_list_appTheme {

        TopicCard(Topic(R.string.architecture,12, R.drawable.architecture))
    }
    }
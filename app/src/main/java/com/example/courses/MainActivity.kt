package com.example.courses

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.card.Topic
import com.example.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
//                    TopicItem()
                }
            }
        }
    }
}

@Composable
fun TopicItem(topic: Topic, modifier: Modifier = Modifier) {
    Card {
        Row {
            Image(
                painter = painterResource(id = topic.imageId), contentDescription = stringResource(
                    id = topic.nameId
                ), modifier = Modifier
                    .height(68.dp)
                    .width(68.dp), contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(
                    start = 16.dp, top = 16.dp, end = 16.dp
                )
            ) {
                Text(
                    text = stringResource(id = topic.nameId),
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Row (verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = topic.numberOfClasses.toString(),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }

    }
}

@Composable
fun CoursesGrid(topics: List<Topic>, modifier: Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        items(topics) { topic ->
            TopicItem(topic)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoursesPreview() {
    DataSource.topics
    CoursesTheme {
//        TopicItem(topic = Topic(R.string.business, 24, R.drawable.business))
        CoursesGrid(topics = DataSource.topics, modifier = Modifier)
    }
}
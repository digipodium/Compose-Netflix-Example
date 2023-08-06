package com.example.netflixexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.netflixexample.datasource.FakeDateSource
import com.example.netflixexample.model.Item
import com.example.netflixexample.ui.theme.NetflixExampleTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        containerColor = Color.Black,
                        contentColor = Color.White,
                        topBar = {
                            TopAppBar(
                                title = {
                                    Image(
                                        painter = painterResource(id = R.drawable.netflix),
                                        contentDescription = "logo",
                                        modifier = Modifier.width(35.dp)
                                    )
                                },
                                actions = {
                                    IconButton(onClick = { }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "menu"
                                        )
                                    }
                                    IconButton(onClick = { }) {
                                        Icon(
                                            imageVector = Icons.Default.Search,
                                            contentDescription = "menu"
                                        )
                                    }
                                    IconButton(onClick = {}) {
                                        Image(
                                            painter = painterResource(id = R.drawable.profile_icon),
                                            contentDescription = "profile icon",
                                            modifier = Modifier.width(30.dp)
                                        )
                                    }

                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = Color.Transparent,
                                    actionIconContentColor = Color.White
                                ),
                                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
                            )
                        }
                    ) { padding ->
                        val movies = FakeDateSource().loadMovies()
                        val scrollState = rememberScrollState()
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding)
                                .verticalScroll(
                                    state = scrollState,
                                    enabled = true
                                )
                        ) {
                            for (i in 1..10) {
                                Row {
                                    movieRow(movies = movies, modifier = Modifier.padding(8.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun movieRow(movies: List<Item>, modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "International Movies",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White
        )
        LazyRow() {
            items(movies) { movie ->
                movieCard(
                    movie = movie,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun movieCard(movie: Item, modifier: Modifier) {
    Card(modifier = modifier) {
        Image(
            painter = painterResource(id = movie.imgResId),
            contentDescription = "movie image",
            modifier = Modifier
                .height(150.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun preview() {
    NetflixExampleTheme {
        movieCard(movie = Item(R.drawable.openheimer), modifier = Modifier.padding(8.dp))
    }
}


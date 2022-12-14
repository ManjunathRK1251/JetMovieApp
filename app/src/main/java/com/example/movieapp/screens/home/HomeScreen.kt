package com.example.movieapp.screens.home



import android.util.Log
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bawp.movieapp.widgets.MovieRow
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies
import com.example.movieapp.screens.MovieScreens


@Composable
fun HomeScreen(navController: NavController){
    //we are navController , because it  allows us to navigate to whatever screen we want
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                elevation = 5.dp
            ) {
                Text(text = "Movies")
            }
        }
    ) {
        MainContent(navController = navController)
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
){
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn{
            items(items = movieList){
                MovieRow(movie = it){ movie ->
//                    Log.d("TAG", "Maincontent: $movie")
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }
            }
        }
    }

}
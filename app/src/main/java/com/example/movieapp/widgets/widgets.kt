package com.example.movieapp.widgets


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
//import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.transform.CircleCropTransformation
import coil.transform.Transformation
//import coil.compose.rememberImagePainter
//import coil.request.ImageRequest
import com.example.movieapp.model.Movie
import com.example.movieapp.model.getMovies

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick: (String) -> Unit = {}){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable {
            onItemClick(movie.id)
        },
        elevation = 6.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp),
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape,
                elevation = 4.dp,
            ) {
//                Image(
//                    // on below line we are adding the image url
//                    // from which we will  be loading our image.
//                    painter = rememberAsyncImagePainter(movie.images[0]),
//
//                    // on below line we are adding content
//                    // description for our image.
//                    contentDescription = "gfg image",
//                )

                Image(

                    // on below line we are adding the image url
                    // from which we will  be loading our image.
//                    painter = rememberAsyncImagePainter("https://media.geeksforgeeks.org/wp-content/uploads/20210101144014/gfglogo.png"),
                    painter = rememberAsyncImagePainter(
                        model = movie.images[0],
                    ),
                    // on below line we are adding content
                    // description for our image.
                    contentDescription = "gfg image",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,

                    // on below line we are adding modifier for our
                    // image as wrap content for height and width.
                )
            }
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Text(text = movie.title, style = MaterialTheme.typography.h6)
                Text(text = "Director: ${movie.director}", style = MaterialTheme.typography.caption)
                Text(text = "Released: ${movie.year}", style = MaterialTheme.typography.caption)
            }

        }

    }
}

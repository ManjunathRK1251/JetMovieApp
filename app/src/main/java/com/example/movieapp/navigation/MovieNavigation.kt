package com.example.movieapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.screens.MovieScreens
import com.example.movieapp.screens.home.HomeScreen
import com.example.movieapp.screens.details.DetailsScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()

    //instead of passing 'graph' parameter to the NavHost, we'll pass startDestination
    //NavHost - this is where we're going to host all of our destinations, our composables to our screens
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){
        //we use MovieScreens.HomeScreen.name to get the string equivalent of the enum MovieScreens.HomeScreen
        //we are basically building a graph here by specifying the set of composables
        composable(MovieScreens.HomeScreen.name){
            //next line indicates where the navigation should take us for MovieScreens.HomeScreen.name
            HomeScreen(navController = navController)
        }

        //to pass data , in web we'll be doing this by appeding the data to the end, www.google.com/detail-screen/id=34
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie") {type = NavType.StringType},)
        ){
            //to access the values of these parameters, we can use the NavBackStackEntry variable which is by default available in the it variable
                backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}


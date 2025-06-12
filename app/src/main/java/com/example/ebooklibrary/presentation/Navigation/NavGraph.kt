package com.example.ebooklibrary.presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.ebooklibrary.presentation.Screens.BooksByCategoryScreen
import com.example.ebooklibrary.presentation.Screens.HomeScreen
import com.example.ebooklibrary.presentation.Screens.PdfViewScreen


@Composable
fun NavGraph(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination = Routes.HomeScreen){
        composable<Routes.HomeScreen>{
            HomeScreen(navHostController = navHostController)
        }

        composable<Routes.ShowPdfScreen>{ backStackEntry ->

            val data : Routes.ShowPdfScreen = backStackEntry.toRoute()
            PdfViewScreen(url = data.url)

        }

        composable<Routes.BooksByCategory> { backStackEntry ->
            val data : Routes.BooksByCategory = backStackEntry.toRoute()
            BooksByCategoryScreen(category = data.category, navHostController = navHostController)
        }


    }

}

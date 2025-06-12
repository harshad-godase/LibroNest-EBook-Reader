package com.example.ebooklibrary.presentation.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.ebooklibrary.presentation.Effects.AnimateShimmer
import com.example.ebooklibrary.presentation.UIcomponent.Bookcart

@Composable
fun AllBooksScreen(
    modifier: Modifier = Modifier,
    viewModel: ViewModel = hiltViewModel(),
    navHostController: NavHostController){


    LaunchedEffect(Unit) {
        viewModel.BringAllBooks()
    }
    val res = viewModel.state.value
    when{
        res.isLoading ->{
            Column (
                modifier= Modifier.fillMaxSize()
            ) {
                LazyColumn {
                    items (30){
                        AnimateShimmer()
                    }
                }
            }
        }
        res.error.isNotEmpty()->{
            Text(text = res.error,modifier=modifier)
        }
        res.items.isNotEmpty()->{
            Column (
                modifier= Modifier.fillMaxSize()
            ){
                LazyColumn (modifier= Modifier.fillMaxSize()){
                    items(res.items) {
                        Bookcart(
                            image = it.image,
                            title = it.bookName,
                            author = it.bookAuthor,
                            description = it.bookDescription,
                            bookUrl = it.pdfUrl,
                            navHostController = navHostController
                        )

                    }
                }
            }
        }else-> Text(text = "No books Available",modifier= Modifier)
    }


}
package com.example.ebooklibrary.domain.repo

import com.example.ebooklibrary.common.BookCategoryModel
import com.example.ebooklibrary.common.BookModel
import com.example.ebooklibrary.common.ResultState
import kotlinx.coroutines.flow.Flow

interface AllBookRepo {

    fun getAllBooks(): Flow<ResultState<List<BookModel>>>
    fun getAllCategories(): Flow<ResultState<List<BookCategoryModel>>>
    fun getAllBooksByCategory(category: String): Flow<ResultState<List<BookModel>>>

}
package com.example.ebooklibrary.data.di

import com.example.ebooklibrary.data.repoImpl.AllBookRepoImpl
import com.example.ebooklibrary.domain.repo.AllBookRepo
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object HiltModule{

    @Provides
    @Singleton
    fun provideRealtimeDatabase():FirebaseDatabase{
        return FirebaseDatabase.getInstance()

    }

    @Provides
    @Singleton
    fun provideFirebaseStorage():FirebaseStorage{
        return FirebaseStorage.getInstance()
    }


    @Provides
    @Singleton
    fun provideAllBookRepo(firebaseDatabase: FirebaseDatabase): AllBookRepo{
        return AllBookRepoImpl(firebaseDatabase)
    }






}
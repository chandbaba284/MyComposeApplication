package com.example.mycomposeapplication

import javax.inject.Inject

class PhotosRepository @Inject constructor(val apiService: ApiService) {

     suspend fun getAllPhotos(): List<Photos> {
        return apiService.getPhotos()
    }
}
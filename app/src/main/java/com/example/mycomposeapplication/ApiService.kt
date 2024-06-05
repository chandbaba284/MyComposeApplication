package com.example.mycomposeapplication


import retrofit2.http.GET

interface ApiService {
    @GET("photos")
    suspend fun getPhotos() : List<Photos>
}
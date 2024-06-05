package com.example.mycomposeapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(val photosRepository: PhotosRepository) : ViewModel() {
    private var _photosList : MutableStateFlow<List<Photos>> = MutableStateFlow(emptyList())
    val photosList : StateFlow<List<Photos>> = _photosList

     fun getAllPhotos(){
        viewModelScope.launch {
            val response = photosRepository.getAllPhotos()
            _photosList.value = response
        }
    }
}
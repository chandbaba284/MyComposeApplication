package com.example.mycomposeapplication

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.gson.Gson


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {

    val photosViewModel = hiltViewModel<PhotosViewModel>()
    val dataState by photosViewModel.photosList.collectAsState()
    LaunchedEffect(true) {
        photosViewModel.getAllPhotos()
    }
    LazyColumn(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(top = 70.dp)) {
        items(dataState) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(top = 15.dp)
            ) {
                GlideImage(
                    model = item.thumbnailUrl, contentDescription = item.thumbnailUrl,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                )
                ClickableText(AnnotatedString(item.title), onClick = {
                    val jsonData = Gson().toJson(item)
                    navController.navigate("HomeDetailsScreen/${jsonData}")
                }, modifier = Modifier.padding(20.dp))
            }

        }
    }
}

@Preview
@Composable
fun callScreen() {
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "Phone Screen")
    }
}

@Preview
@Composable
fun MusicScreen() {
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "Music Screen")
    }
}

@Preview
@Composable
fun DriveScreen() {
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "Drive Screen")
    }
}

package com.example.mycomposeapplication

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.google.gson.Gson

@OptIn(ExperimentalGlideComposeApi::class)
@Preview
@Composable
fun HomeDetailsScreen(navController: NavHostController) {
    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val dataList = navBackStackEntry?.arguments?.getString("item")
    val parsedResponse = Gson().fromJson(dataList, Photos::class.java)
    Column(
        modifier = Modifier.padding(top = 70.dp),
        verticalArrangement = Arrangement.Center


    ) {
        GlideImage(
            model = parsedResponse.thumbnailUrl,
            contentDescription = parsedResponse.title,
            modifier = Modifier
                .height(150.dp)
                .width(150.dp)
        )
        Text(text = parsedResponse.title, style = TextStyle(color = Color.Green))
    }
}
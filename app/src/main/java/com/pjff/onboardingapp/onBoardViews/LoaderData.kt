package com.pjff.onboardingapp.onBoardViews

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
//V-98,paso 1.1 Tenemos dos parámetros: Modifier y una imagen
fun LoaderData(modifier: Modifier, image: Int) {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(image))

    //Mandamos a llamar las imágenes.
    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier
    )

}
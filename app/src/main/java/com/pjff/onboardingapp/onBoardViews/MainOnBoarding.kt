package com.pjff.onboardingapp.onBoardViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.pjff.onboardingapp.R
import com.pjff.onboardingapp.data.PageData
import com.pjff.onboardingapp.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
// V-103, Paso 2.5
fun MainOnBoarding(
    // Paso 4.3, agregamos el navController: NavController
    navController: NavController,
    // Paso 5.6
    store: StoreBoarding
) {
    // Paso 2.6
    val items = ArrayList<PageData>()

    items.add(
        // Page data ,para que nos traiga los datos.
        PageData(
            // Llamamos nuestras imagánes que descargamos.
            R.raw.page1,
            "Title 1",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"
        )
    )

    items.add(
        PageData(
            R.raw.page2,
            "Title 2",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"
        )
    )

    items.add(
        PageData(
            R.raw.page3,
            "Title 3",
            "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod"
        )
    )

    //Paso 2.7
    val pagerState = rememberPagerState(
        // Sacamos el numero de páginas del array que son 3
        pageCount = items.size,
        // 0,1,2,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    // Mandamos a llamar a la página
    OnBoardingPager(
        item = items, pagerState = pagerState, modifier = Modifier
            .fillMaxWidth()
            // Paso 3.6, al crear un navmanager nos empuja  a la mitad , con esto lo arreglamos
            .fillMaxHeight()
            .background(Color.White),
        // Paso 4.4
        navController,
        // Paso 5.7
        store
    )


}
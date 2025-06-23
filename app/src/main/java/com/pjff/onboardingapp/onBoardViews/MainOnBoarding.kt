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
//Vid 103,Vid 105, agregamos el navController: NavController
fun MainOnBoarding(navController: NavController, store: StoreBoarding) {
    val items = ArrayList<PageData>()

    items.add(
        //Page data ,para que nos traiga los datos.
        PageData(
            //Llamamos nuestras imagánes que descargamos.
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

    val pagerState = rememberPagerState(
        //sacamos el numero de paginas
        pageCount = items.size,
        //0,1,2,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    //Mandamos a llamar a la pagina
    OnBoardingPager(
        item = items, pagerState = pagerState, modifier = Modifier
            .fillMaxWidth()
            //Vid 104, al crear un navmanager nos empuja  a la mitad , con esto lo arreglamos
            .fillMaxHeight()
            .background(Color.White),
        //Vid 105
        navController,
        //Vid 107
        store
    )


}
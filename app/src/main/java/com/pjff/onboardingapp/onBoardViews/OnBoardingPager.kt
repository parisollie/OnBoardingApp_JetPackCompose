package com.pjff.onboardingapp.onBoardViews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pjff.onboardingapp.data.PageData
import com.pjff.onboardingapp.dataStore.StoreBoarding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

//V-101,Paso 2.0
@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingPager(
    //Ponemos sus parametros , traemos el page data
    item: List<PageData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    //Paso 4.1 agregamos el navController
    navController: NavController,
    //Paso 5.4 agregamos el store
    store: StoreBoarding
) {
    // Paso 2.1
    Box(modifier = modifier) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            HorizontalPager(state = pagerState) { page ->
                // V-102, Paso 2.4 Ponemos lo que correspondera a cada imágen.
                Column(
                    modifier = Modifier
                        .padding(60.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // La imágen que descargamos.
                    LoaderData(
                        modifier = Modifier
                            .size(200.dp)
                            .fillMaxWidth()
                            // Ponemos el indice que necesitamos item[page]
                            .align(alignment = Alignment.CenterHorizontally), item[page].image
                    )
                    Text(
                        text = item[page].title,
                        modifier = Modifier.padding(top = 50.dp),
                        color = Color.Black,
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = item[page].desc,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Light,
                        fontSize = 20.sp
                    )
                } //Column
            }
            // Paso 2.2,le daremos el numero de páginas que creamos.
            PagerIndicator(item.size, pagerState.currentPage)
        }
        // Paso 2.3
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {

            ButtonFinish(
                pagerState.currentPage,
                //Paso 4.2, agregamos el navController.
                navController,
                //Paso 5.5 agregamos el store
                store
            )
        }
    }
}















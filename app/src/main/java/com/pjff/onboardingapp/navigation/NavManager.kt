package com.pjff.onboardingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pjff.onboardingapp.dataStore.StoreBoarding
import com.pjff.onboardingapp.onBoardViews.MainOnBoarding
import com.pjff.onboardingapp.views.HomeView
import com.pjff.onboardingapp.views.SplashScreen


@Composable
//Vid 104
fun NavManager(){
    //Vid 107
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = false)

    //vid 104
    val navController = rememberNavController()
    //Vid 105 agregamos el nav controller
    //Vid 106,si es true vaos al home y sino a splash
    NavHost(navController, startDestination = if(store.value) "Home" else "Splash" ){
        composable("OnBoarding"){
            //Vid 107,ponemos dataStore
            MainOnBoarding(navController, dataStore)
        }
        composable("Home"){
            HomeView(navController)
        }

        //Vid 108
        composable("Splash"){
            SplashScreen(navController, store.value)
        }

    }
}


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
// Paso 3.1, creamos el nav manager
fun NavManager(){
    // V-107, paso 5.1, implementacion del dataStore
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = false)

    // Paso 3.2
    val navController = rememberNavController()

    NavHost(
        // Paso 3.3 agregamos el nav controller
        navController,
        // Paso 5.2,si es true vamos al home y Paso 6.2,sino a splash.
        startDestination = if(store.value) "Home" else "Splash"
    ){
        // Paso 3.4
        composable("OnBoarding"){

            MainOnBoarding(
                // Paso 4.5
                navController,
                // Paso 5.8,ponemos dataStore
                dataStore)
        }

        composable("Home"){
            // Paso 4.7
            HomeView(navController)
        }

        //Paso 6.1
        composable("Splash"){
            SplashScreen(navController, store.value)
        }

    }
}


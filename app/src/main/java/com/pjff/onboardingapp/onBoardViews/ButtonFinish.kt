package com.pjff.onboardingapp.onBoardViews

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pjff.onboardingapp.dataStore.StoreBoarding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
//Paso 1.3
fun ButtonFinish(
    //current page ,página en la que encontramos.
    currentPage: Int,
    //V-105,paso 4.0 agregamos el nav controller
    navController: NavController,
    // Paso 5.3, ponemos store : StoreBoarding
    store : StoreBoarding
){
        //Paso 1.4
        Row(modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
            //Si la última página se nuestra  aparecera el botón.
            horizontalArrangement = if (currentPage != 2) Arrangement.SpaceBetween else Arrangement.Center
        ) {
            if (currentPage == 2){
                OutlinedButton(onClick = {
                    //Paso 5.10
                    CoroutineScope(Dispatchers.IO).launch {
                        store.saveBoarding(true)
                    }
                    // Paso 4.8 agregamos el nav controller
                    navController.navigate("Home"){
                        //Para que ya no nos regrese al onboarding.
                        popUpTo(0)
                    }
                }) {
                    Text(text = "Entrar", modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 40.dp),
                        color = Color.Gray
                    )
                }
            }
        }
}
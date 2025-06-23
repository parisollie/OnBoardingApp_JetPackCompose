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
//Vid 99, current page ,página en la que encontramos.
//Vid 107, ponemos store : StoreBoarding
fun ButtonFinish(currentPage: Int, navController: NavController, store : StoreBoarding){
        Row(modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
            //Si la uiltima pagna se nuestra  aparecera el botón
            horizontalArrangement = if (currentPage != 2) Arrangement.SpaceBetween else Arrangement.Center
        ) {
            if (currentPage == 2){
                OutlinedButton(onClick = {
                    //Vd 107
                    CoroutineScope(Dispatchers.IO).launch {
                        store.saveBoarding(true)
                    }
                    //Vid 105 agregamos el nav controller
                    navController.navigate("Home"){
                        //atras de nosotros no hay nada ,ya no nos regresar menu
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
package com.example.proyectocasas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectocasas.ui.pantallas.PantallaGaleria
import com.example.proyectocasas.ui.pantallas.PantallaInfo
import com.example.proyectocasas.ui.pantallas.PantallaInicio

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CasasApp()
        }
    }
}

@Composable
fun CasasApp(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "inicio"){
        composable("inicio") { PantallaInicio(navController) }
        composable("info") { PantallaInfo(navController) }
        composable("galeria") { PantallaGaleria(navController) }
    }
}
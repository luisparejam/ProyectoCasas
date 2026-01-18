package com.example.proyectocasas.ui.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectocasas.data.RepositorioCasas
import kotlin.random.Random

@Composable
fun PantallaDetalleCasa(navController: NavController, id:Int){

    val casa = RepositorioCasas.getCasaPorId(id) ?: return

    var offset by remember{ mutableStateOf(Offset.Zero) }

    var colorFondo by remember{ mutableStateOf(Color.White) }

    Column(modifier = Modifier.fillMaxSize().background(colorFondo).padding(16.dp))
    {
        // Boton de volver atras
        Button(onClick = { navController.popBackStack() }, modifier = Modifier.align(Alignment.Start)){
            Text("Volver")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(casa.nombre, fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally))

        Spacer(modifier = Modifier.height(12.dp))

        Box(modifier = Modifier.fillMaxWidth().height(300.dp).pointerInput(Unit){
            detectTransformGestures { _, pan, zoom, rotationDelta -> offset+=pan }
        }, contentAlignment = Alignment.Center){
            Image(
                painter = painterResource(id=casa.imagenId),
                contentDescription = casa.nombre,
                modifier = Modifier.graphicsLayer(translationX = offset.x, translationY = offset.y)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(casa.descripcion)

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = {
            colorFondo = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat(), 1f)
        }) {
            Text("Cambia color fondo")
        }
    }

}
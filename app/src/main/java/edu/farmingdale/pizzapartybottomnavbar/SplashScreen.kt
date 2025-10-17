package edu.farmingdale.pizzapartybottomnavbar

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.JdkConstants


// ToDo 1: The splash screen should have the image displayed in the center of the screen. FINISHED

@Composable
fun SplashScreen(navController: NavHostController) {

    val scale= remember {
        Animatable(0f, 1f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(durationMillis = 1000,0, easing = {
                OvershootInterpolator(2f).getInterpolation(it)
            }
            ))
        delay(3000)
        navController.navigate(BottomNavigationItems.PizzaScreen.route)
    }

    //TODO 1 is FINISHED, took the inovation from the previous splash
    //screen in the nav demo assignment. then use fillMaxSize() to ensure
    //the logo is in the middle of the screen
    Box (contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.fsclogo), contentDescription ="" )
    }
}




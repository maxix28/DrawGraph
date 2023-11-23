package com.example.drawgraph

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.drawgraph.ui.theme.DrawGraphTheme
import com.example.drawgraph.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawGraphTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
               MyApp()
                }
            }
        }
    }
}



@Composable
fun MyApp()
{
    Graph()
}



@Composable
fun Graph(){


Box(
    modifier = Modifier.fillMaxSize()
        .background(Purple80)
){


    Canvas(
        modifier = Modifier
            .padding(8.dp,)
            .aspectRatio(3/2f)
            .fillMaxSize()

    ){
        val barWidthPx = 2.dp.toPx()
        drawRect(Color.White, style = Stroke(barWidthPx))



        val verticalLines = 4
        val verticalSize = size.width / (verticalLines+1)
        repeat(verticalLines){ i->
            val startX = verticalSize* ( i +1)
            drawLine(
                Color.White,
                start = Offset(startX,0f),
                end = Offset(startX, size.height),
                strokeWidth = barWidthPx
            )

        }
        val horizontallLnes = 3
        val horizontalSize = size.height / (horizontallLnes+1)
        repeat(horizontallLnes){ i->
            val startY = horizontalSize* ( i +1)
            drawLine(
                Color.White,
                start = Offset(0f,startY),
                end = Offset( size.width,startY,),
                strokeWidth = barWidthPx
            )

        }




    }

}




}





@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DrawGraphTheme {
      MyApp()
    }
}
package br.com.matheusvirgolino.nutrilife

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriLifeTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),

                )
                {

                    Toolbar(title = "NutriLife")
                    GridWithRoundedBorders()
                }
            }
        }
    }
}

@Composable
fun NutriLifeTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(title: String) {
    TopAppBar(
        {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(10.dp)
            )

        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color(0xFF41855C),
            titleContentColor = Color.White
        ),


    )
}

@Composable
fun GridWithRoundedBorders() {
    val iconTexts = listOf(
        "Perfil", "Dieta", "Recompensas",
        "Plano Alimentar", "Ajuda", "Configurações"
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        repeat(3) { rowIndex ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(2) { colIndex ->
                    val icon = when (rowIndex * 2 + colIndex) {
                        0 -> painterResource(id = R.drawable.icon_perfil)
                        1 -> painterResource(id = R.drawable.icondieta)
                        2 -> painterResource(id = R.drawable.icon_recompensas)
                        3 -> painterResource(id = R.drawable.icon_planalimentar)
                        4 -> painterResource(id = R.drawable.icon_ajuda)
                        5 -> painterResource(id = R.drawable.icon_configuracoes)
                        else -> painterResource(id = R.drawable.icondieta)
                    }
                    val text = iconTexts[rowIndex * 2 + colIndex]
                    RoundedSquare(icon = icon, text = text)
                }
            }
        }
    }
}

@Composable
fun RoundedSquare(icon: Painter, text: String) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = Color(0xFF41855C))
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(108.dp)
                    .padding(top = 20.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = text,
                textAlign = TextAlign.Center,
                color = Color.White,
                style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.Bold),
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Preview() {
    NutriLifeTheme {

        Scaffold(
            topBar = {
                Toolbar(title = "NutriLife")

            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                GridWithRoundedBorders()
            }
        }


    }
}
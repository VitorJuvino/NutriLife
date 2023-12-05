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


class PlanoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NutriLifeTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp),
                ) {
                    Toolbar(title = "NutriLife")

                    PlanoButtonsScreen()
                }
            }
        }
    }
}

@Composable
fun PlanoButtonsScreen() {
    val descricaoCampos = listOf(
        "SEGUNDA", "TERÇA",
        "QUARTA", "QUINTA",
        "SEXTA", "SÁBADO",
        "DOMINGO", "ANOTAÇÕES"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .padding(15.dp),
            text = "Plano Alimentar",
            style = TextStyle(
                fontSize = 25.sp,
            ),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color(0xFF41855C), RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column {
                repeat(4) { rowIndex ->
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        repeat(2) { columnIndex ->
                            Box(
                                modifier = Modifier
                                    .width(120.dp)
                                    .height(100.dp)
                                    .background(Color.White, RoundedCornerShape(16.dp))
                                    .padding(5.dp),
                                contentAlignment = Alignment.TopCenter
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .padding(8.dp),
                                    verticalArrangement = Arrangement.Top
                                ) {

                                    Text(
                                        text = descricaoCampos[rowIndex * 2 + columnIndex],
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            color = (Color(0xFF41855C))
                                        )
                                    )
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PlanoPreview() {
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
                PlanoButtonsScreen()
            }
        }
    }
}

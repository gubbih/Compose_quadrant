package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Cyan
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AllCom()
                }
            }
        }
    }
}

@Composable
fun AllCom(){
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            SingleCom(
                stringResource(R.string.titleG),
                stringResource(R.string.descriptionG),
                Green, modifier = Modifier.weight(1f))      //top-left

            SingleCom(stringResource(R.string.titleY),
                            stringResource(R.string.descriptionY),
                Yellow, modifier = Modifier.weight(1f))     //top-right
        }
        Row(Modifier.weight(1f)) {
            SingleCom(
                            stringResource(R.string.titleC),
                            stringResource(R.string.descriptionC),
                Cyan, modifier = Modifier.weight(1f))       //bottom-left

            SingleCom(
                            stringResource(R.string.titleLG),
                            stringResource(R.string.descriptionLG),
                LightGray, modifier = Modifier.weight(1f))  //bottom-right
        }

        
    }
    
}

@Composable
private fun SingleCom(title: String, description: String, BGColor: Color, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
            .background(BGColor)
            .padding(16.dp)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = modifier
                .padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeQuadrantTheme {
        AllCom()
    }
}
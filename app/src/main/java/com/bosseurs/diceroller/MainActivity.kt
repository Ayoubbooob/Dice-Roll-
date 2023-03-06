package com.bosseurs.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bosseurs.diceroller.ui.theme.DiceRollerTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true )
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun DiceWithButtonAndImage(modifier : Modifier = Modifier){
    var randomNumber1 by remember { mutableStateOf(1) }
    var randomNumber2 by remember { mutableStateOf(1) }

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Row(Modifier.fillMaxWidth()) {
            Image(painter = painterResource(id = WhichImage(randomNumber1)), contentDescription = null )
            Image(painter = painterResource(id = WhichImage(randomNumber2)), contentDescription = null )
        }

        Button(onClick = {
            randomNumber1 = Random.nextInt(1, 7)
            randomNumber2 = Random.nextInt(1, 7)
        },
            modifier = Modifier.width(150.dp)
        ) {
            Text(stringResource(id = R.string.roll))
        }
    }
}

fun WhichImage(number : Int) : Int{
    var result : Int = 1
    when(number){
        1 ->  result = R.drawable.dice_1
        2 -> result = R.drawable.dice_2
        3 -> result = R.drawable.dice_3
        4 -> result = R.drawable.dice_4
        5 -> result = R.drawable.dice_5
        6 -> result = R.drawable.dice_6
    }
    return result
}
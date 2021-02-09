package com.kagire.match

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var score = 0
    private val colors = arrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW)
    private var currentColor = Color.BLACK
    private var buttonColors = arrayOf(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
            Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
            Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
            Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK)
    private var buttonStatus = arrayOf(false, false, false, false,
            false, false, false, false,
            false, false, false, false,
            false, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateMainColor()
    }


    /**
     * content management
     */
    private fun increaseScore(){
        val textField = findViewById<TextView>(R.id.scoreText)
        score++
        textField.setText("Score: " + score)
    }

    private fun updateMainColor(){
        val button = findViewById<Button>(R.id.mainButton)
        currentColor = colors.random()
        button.setBackgroundColor(currentColor)
    }

    private fun checkMatch(){
        val match = getMatch()
        if (match[0] != -1) {
            buttonColors[match[0]] = Color.BLACK
            buttonColors[match[1]] = Color.BLACK
            buttonColors[match[2]] = Color.BLACK
            buttonColors[match[3]] = Color.BLACK
            resetAll(false)
            increaseScore()
        }
    }


    /**
     * onClick events
     */
    fun tableButtonClick(view: View) {
        val b = view as Button
        val buttonInt = b.text.toString().toInt()
        if (buttonColors[buttonInt - 1] == Color.BLACK) {
            buttonColors[buttonInt - 1] = currentColor
            buttonStatus[buttonInt - 1] = true
            b.setBackgroundColor(currentColor)
            updateMainColor()
            checkMatch()
        }
    }

    fun restartGame(view: View){
        score = 0
        for (i in 0..15){
            buttonColors[i] = Color.BLACK
            buttonStatus[i] = false
        }
        resetAll(true)
    }


    /**
     * big trash
     */
    private fun resetAll(action: Boolean){
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val button10 = findViewById<Button>(R.id.button10)
        val button11 = findViewById<Button>(R.id.button11)
        val button12 = findViewById<Button>(R.id.button12)
        val button13 = findViewById<Button>(R.id.button13)
        val button14 = findViewById<Button>(R.id.button14)
        val button15 = findViewById<Button>(R.id.button15)
        val button16 = findViewById<Button>(R.id.button16)

        button1.setBackgroundColor(buttonColors[0])
        button2.setBackgroundColor(buttonColors[1])
        button3.setBackgroundColor(buttonColors[2])
        button4.setBackgroundColor(buttonColors[3])
        button5.setBackgroundColor(buttonColors[4])
        button6.setBackgroundColor(buttonColors[5])
        button7.setBackgroundColor(buttonColors[6])
        button8.setBackgroundColor(buttonColors[7])
        button9.setBackgroundColor(buttonColors[8])
        button10.setBackgroundColor(buttonColors[9])
        button11.setBackgroundColor(buttonColors[10])
        button12.setBackgroundColor(buttonColors[11])
        button13.setBackgroundColor(buttonColors[12])
        button14.setBackgroundColor(buttonColors[13])
        button15.setBackgroundColor(buttonColors[14])
        button16.setBackgroundColor(buttonColors[15])

        if (action) {
            val textField = findViewById<TextView>(R.id.scoreText)
            textField.setText("Score: " + score)
        }
    }

    private fun getMatch(): Array<Int>{
        if(buttonColors[0] == buttonColors[1] && buttonColors[2] == buttonColors[3] && buttonColors[2] == buttonColors[1]
                && buttonStatus[0] && buttonStatus[1] && buttonStatus[2] && buttonStatus[3])
            return arrayOf(0, 1, 2, 3)
        else if(buttonColors[4] == buttonColors[5] && buttonColors[6] == buttonColors[7] && buttonColors[5] == buttonColors[6]
                && buttonStatus[4] && buttonStatus[5] && buttonStatus[6] && buttonStatus[7])
            return arrayOf(4, 5, 6, 7)
        else  if(buttonColors[8] == buttonColors[9] && buttonColors[10] == buttonColors[11] && buttonColors[11] == buttonColors[9]
                && buttonStatus[8] && buttonStatus[9] && buttonStatus[10] && buttonStatus[11])
            return arrayOf(8, 9, 10, 11)
        else  if(buttonColors[12] == buttonColors[13] && buttonColors[14] == buttonColors[15] && buttonColors[13] == buttonColors[14]
                && buttonStatus[12] && buttonStatus[13] && buttonStatus[14] && buttonStatus[15])
            return arrayOf(12, 13, 14, 15)
        else  if(buttonColors[0] == buttonColors[4] && buttonColors[8] == buttonColors[12] && buttonColors[4] == buttonColors[8]
                && buttonStatus[0] && buttonStatus[4] && buttonStatus[8] && buttonStatus[12])
            return arrayOf(0, 4, 8, 12)
        else  if(buttonColors[1] == buttonColors[5] && buttonColors[9] == buttonColors[13] && buttonColors[5] == buttonColors[9]
                && buttonStatus[1] && buttonStatus[5] && buttonStatus[9] && buttonStatus[13])
            return arrayOf(1, 5, 9, 13)
        else  if(buttonColors[2] == buttonColors[6] && buttonColors[10] == buttonColors[14] && buttonColors[6] == buttonColors[10]
                && buttonStatus[2] && buttonStatus[6] && buttonStatus[10] && buttonStatus[14])
            return arrayOf(2, 6, 10, 14)
        else  if(buttonColors[3] == buttonColors[7] && buttonColors[11] == buttonColors[15] && buttonColors[7] == buttonColors[11]
                && buttonStatus[3] && buttonStatus[7] && buttonStatus[11] && buttonStatus[15])
            return arrayOf(3, 7, 11 ,15)
        else return arrayOf(-1, 0, 0, 0)
    }
}
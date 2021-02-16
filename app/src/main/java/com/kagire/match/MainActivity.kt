package com.kagire.match

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var score = 0
    private var bestScore = 0;
    private val colors = arrayOf(Color.RED, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.YELLOW)
    private var currentColor = Color.BLACK
    private var buttonColors = arrayOf(Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
            Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
            Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK,
            Color.BLACK, Color.BLACK, Color.BLACK, Color.BLACK)

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
        var match = getMatchHorizontal()
        println(match[0] + match[1] + match[2] + match[3])
        if (match[0] != -1) {
            buttonColors[match[0]] = Color.BLACK
            buttonColors[match[1]] = Color.BLACK
            buttonColors[match[2]] = Color.BLACK
            buttonColors[match[3]] = Color.BLACK
            resetAll(false)
            increaseScore()
        }
        match = getMatchVertical()
        println(match[0] + match[1] + match[2] + match[3])
        if (match[0] != -1) {
            buttonColors[match[0]] = Color.BLACK
            buttonColors[match[1]] = Color.BLACK
            buttonColors[match[2]] = Color.BLACK
            buttonColors[match[3]] = Color.BLACK
            resetAll(false)
            increaseScore()
        }
    }

    private fun checkLoose(): Boolean{
        var isLost = true
        for (i in 0..15){
            if(buttonColors[i] == Color.BLACK) isLost = false
        }
        return isLost
    }


    /**
     * onClick events
     */
    fun tableButtonClick(view: View) {
        val b = view as Button
        val buttonInt = b.text.toString().toInt()
        if (buttonColors[buttonInt - 1] == Color.BLACK) {
            buttonColors[buttonInt - 1] = currentColor
            b.setBackgroundColor(currentColor)
            updateMainColor()
        }
        checkMatch()
        if(checkLoose()) {
            val textField = findViewById<TextView>(R.id.scoreText)
            textField.setText("Game over. \nScore: " + score)
        }
    }

    fun restartGame(view: View){
        if(bestScore < score){
            bestScore = score
            val bestScoreTab = findViewById<TextView>(R.id.bestScore)
            bestScoreTab.setText("Best: " + bestScore)
        }
        score = 0
        for (i in 0..15){
            buttonColors[i] = Color.BLACK
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

    private fun getMatchHorizontal(): Array<Int> {
        for (i in 0..3) {
            if (buttonColors[i * 4] == buttonColors[(i * 4) + 1] && buttonColors[(i * 4) + 2] == buttonColors[(i * 4) + 3]
                    && buttonColors[(i * 4) + 2] == buttonColors[(i * 4) + 1] && buttonColors[i * 4] != Color.BLACK)
                return arrayOf(i * 4, (i * 4) + 1, (i * 4) + 2, (i * 4) + 3)
        }
        return arrayOf(-1, 0, 0, 0)
    }

    private fun getMatchVertical(): Array<Int> {
        for (i in 0..3) {
            if (buttonColors[i] == buttonColors[i + 4] && buttonColors[i + 8] == buttonColors[i + 12]
                    && buttonColors[i] == buttonColors[i + 8] && buttonColors[i] != Color.BLACK)
                return arrayOf(i, i + 4, i + 8, i + 12)
        }
        return arrayOf(-1, 0, 0, 0)
    }
}
package com.example.lightsout

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1= findViewById<Button>(R.id.button1)
        val button2= findViewById<Button>(R.id.button2)
        val button3= findViewById<Button>(R.id.button3)
        val button4= findViewById<Button>(R.id.button4)
        val button5= findViewById<Button>(R.id.button5)
        val button6= findViewById<Button>(R.id.button6)
        val button7= findViewById<Button>(R.id.button7)
        val button8= findViewById<Button>(R.id.button8)
        val button9= findViewById<Button>(R.id.button9)
        val button10= findViewById<Button>(R.id.button10)
        val button11= findViewById<Button>(R.id.button11)
        val button12= findViewById<Button>(R.id.button12)
        val button13= findViewById<Button>(R.id.button13)
        val button14= findViewById<Button>(R.id.button14)
        val button15= findViewById<Button>(R.id.button15)
        val button16= findViewById<Button>(R.id.button16)
        val button17= findViewById<Button>(R.id.button17)
        val button18= findViewById<Button>(R.id.button18)
        val button19= findViewById<Button>(R.id.button19)
        val button20= findViewById<Button>(R.id.button20)
        val button21= findViewById<Button>(R.id.button21)
        val button22= findViewById<Button>(R.id.button22)
        val button23= findViewById<Button>(R.id.button23)
        val button24= findViewById<Button>(R.id.button24)
        val button25= findViewById<Button>(R.id.button25)
        val clickCount= findViewById<TextView>(R.id.counter_text)
        var counter= 0

        val setArr1= arrayOf(button1, button2, button3, button4, button5)
        val setArr2= arrayOf(button6, button7, button8, button9, button10)
        val setArr3= arrayOf(button11, button12, button13, button14, button15)
        val setArr4= arrayOf(button16, button17, button18, button19, button20)
        val setArr5= arrayOf(button21, button22, button23, button24, button25)

        val colorArr1= arrayOf(true, true, true, true, true)
        val colorArr2= arrayOf(true, true, true, true, true)
        val colorArr3= arrayOf(true, true, true, true, true)
        val colorArr4= arrayOf(true, true, true, true, true)
        val colorArr5= arrayOf(true, true, true, true, true)

        val setArr= arrayOf(setArr1, setArr2, setArr3, setArr4, setArr5)
        val colorArr= arrayOf(colorArr1, colorArr2, colorArr3, colorArr4, colorArr5)

        val buttonName= findViewById<Button>(R.id.name_click)
        buttonName.setOnClickListener(){
            setName(it)
            buttonName.visibility= View.GONE
            setTiles(it, setArr)
            clickCount.visibility= View.VISIBLE
        }

        for(i in 0..4){
            for(j in 0..4){
                setArr[i][j].setOnClickListener(){
                    clickTile(it, setArr, colorArr, i, j)
                    counter+=1
                    clickCount.text= "Current Clicks: "+ counter.toString()
                }
            }
        }

        val buttonRetry= findViewById<Button>(R.id.retry_button)
        buttonRetry.setOnClickListener(){
            resetTiles(it, setArr, colorArr)
            counter= 0
            clickCount.text= "Current Clicks: "+ counter.toString()
        }
    }

    private fun setName(view: View){
        val editName= findViewById<EditText>(R.id.name_holder)
        val nameTextView= findViewById<TextView>(R.id.game_name)
        val imgId= findViewById<ImageView>(R.id.start_pic)

        nameTextView.text= editName.text
        editName.visibility= View.GONE
        imgId.visibility= View.GONE
    }

    private fun setTiles(view: View, setArr: Array<Array<Button>>){
        val retryButton= findViewById<Button>(R.id.retry_button)
        setArr.forEach {
            it.forEach {
                it.visibility= View.VISIBLE
                it.setBackgroundColor(Color.CYAN)
            }
        }
        retryButton.visibility= View.VISIBLE
    }

private fun clickTile(view: View, setArr: Array<Array<Button>>,  colorArr: Array<Array<Boolean>>, i: Int, j: Int){
        if(i==0){
            if(j==0){
                checkColor(setArr, colorArr, i, j+1)
                checkColor(setArr, colorArr, i+1, j)
            }else if(j==4){
                checkColor(setArr, colorArr, i, j-1)
                checkColor(setArr, colorArr, i+1, j)
            }else{
                checkColor(setArr, colorArr, i, j+1)
                checkColor(setArr, colorArr, i, j-1)
                checkColor(setArr, colorArr, i+1, j)
            }
        }else if(i==4){
            if(j==0){
                checkColor(setArr, colorArr, i, j+1)
                checkColor(setArr, colorArr, i-1, j)
            }else if(j==4){
                checkColor(setArr, colorArr, i, j-1)
                checkColor(setArr, colorArr, i-1, j)
            }else{
                checkColor(setArr, colorArr, i, j+1)
                checkColor(setArr, colorArr, i, j-1)
                checkColor(setArr, colorArr, i-1, j)
            }
        }else if(j==0){
            if(i!=4 && i!=0){
                checkColor(setArr, colorArr, i-1, j)
                checkColor(setArr, colorArr, i+1, j)
                checkColor(setArr, colorArr, i, j+1)
            }
        }else if(j==4){
            if(i!=4 && i!=0){
                checkColor(setArr, colorArr, i-1, j)
                checkColor(setArr, colorArr, i+1, j)
                checkColor(setArr, colorArr, i, j-1)
            }
        }else{
            checkColor(setArr, colorArr, i, j+1)
            checkColor(setArr, colorArr, i, j-1)
            checkColor(setArr, colorArr, i+1, j)
            checkColor(setArr, colorArr, i-1, j)
        }
        checkColor(setArr, colorArr, i, j)
    }

    private fun checkColor(setArr: Array<Array<Button>>, colorArr: Array<Array<Boolean>>, x: Int, y: Int){
        if(colorArr[x][y]== true){
            colorArr[x][y]= false
            setArr[x][y].setBackgroundColor(Color.GRAY)
        }else{
            colorArr[x][y]= true
            setArr[x][y].setBackgroundColor(Color.CYAN)
        }
    }

    private fun resetTiles(view: View, setArr: Array<Array<Button>>, colorArr: Array<Array<Boolean>>):Int{
        setArr.forEach {
            it.forEach {
                it.setBackgroundColor(Color.CYAN)
            }
        }
        for(x in 0..4){
            for(y in 0..4){
                colorArr[x][y]= true
            }
        }
        return 0
    }

//    private fun isWin(view: View, colorArr: Array<Array<Boolean>>, counter: Int): Boolean{
//        if(counter==0){
//            return false
//        }
//        for(i in 0..4){
//            for(j in 0..4){
//                if(colorArr[i][j]!=true){
//                    return false
//                }
//            }
//        }
//        return true
//    }
}

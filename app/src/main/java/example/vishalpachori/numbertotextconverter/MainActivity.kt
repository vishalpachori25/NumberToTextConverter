package example.vishalpachori.numbertotextconverter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    var numberMap = HashMap<Int, String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberMap.put(0, "Zero")
        numberMap.put(1, "One")
        numberMap.put(2, "Two")
        numberMap.put(3, "Three")
        numberMap.put(4, "Four")
        numberMap.put(5, "Five")
        numberMap.put(6, "Six")
        numberMap.put(7, "Seven")
        numberMap.put(8, "Eight")
        numberMap.put(9, "Nine")
        numberMap.put(10, "Ten")
        numberMap.put(11, "Eleven")
        numberMap.put(12, "Twelve")
        numberMap.put(13, "Thirteen")
        numberMap.put(14, "Fourteen")
        numberMap.put(15, "Fifteen")
        numberMap.put(16, "Sixteen")
        numberMap.put(17, "Seventeen")
        numberMap.put(18, "Eighteen")
        numberMap.put(19, "Nineteen")
        numberMap.put(20, "Twenty")
        numberMap.put(30, "Thirty")
        numberMap.put(40, "Forty")
        numberMap.put(50, "Fifty")
        numberMap.put(60, "Sixty")
        numberMap.put(70, "Seventy")
        numberMap.put(80, "Eighty")
        numberMap.put(90, "Ninety")
        numberMap.put(100, "Hundred")
        numberMap.put(1000, "Thousand")
        numberMap.put(100000, "Lakh")
        numberMap.put(10000000, "Crore")

        val value =findViewById<EditText>(R.id.digits_entry)
        value.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                convertThisToText(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })


    }
    private var tempText =""
    private fun convertThisToText(s: String) {

        if (s.isNotEmpty()){
            var number : Int = s.toInt()
            var textView : TextView = findViewById(R.id.converted_string)

            recursiveFun(number)

            textView.text =tempText
        }
    }

    private fun recursiveFun(number: Int)
    {
        var x = 10000000
        while(number%x == number){
            x/=100
            if (x<100) {
                break
            }
        }
        when {
            number < 10 -> tempText += "\n" + numberMap[number%10]

            number < 100 -> {
                tempText += "\n" +numberMap[((number.div(10)))*10]

                recursiveFun(number = number%10)
            }
            number <1000 -> {
                tempText += "\n" +numberMap[((number.div(100)))] +numberMap[100]
                recursiveFun(number = number%100)
            }
            else ->{
                tempText += "\n" + numberMap[number.rem(10)] + numberMap[x]
                recursiveFun(number = number/100)
            }
    }

}
}




package jp.techacademy.thion.maikeru.aisatsuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.app.TimePickerDialog
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button1) {
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                Log.d("UI_PARTS", "$hour:$minute")
                if (hour in 2..9 && minute in 0..59){
                    textView1.text="おはよう"
                }
                else if(hour in 10..17 && minute in 0..59){
                    textView1.text="こんにちは"
                }
                else if((hour in 18..23 && minute in 0..59) || (hour in 0..1 && minute in 0..59)) {
                    textView1.text="こんばんは"
                }
            },
            13, 0, true
        )
        timePickerDialog.show()



    }

}

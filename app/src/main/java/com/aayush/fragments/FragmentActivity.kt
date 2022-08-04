package com.aayush.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class FragmentActivity : AppCompatActivity() {
    lateinit var activityInterface: ActivityInterface
//    lateinit var btn:Button
    lateinit var btnAlertDialog: Button
    var i=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        btn=findViewById(R.id.btn)
        btnAlertDialog=findViewById(R.id.btnAlertDialog)

        btnAlertDialog.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setCancelable(false)
                setTitle("Select Color")
                setMessage("Select a color that you want to set as fragment background")
                setPositiveButton("Red"){_,_->
                    activityInterface.ActivityInterface(1, i)
                    i++
                }
                setNegativeButton("Green"){_,_->
                    activityInterface.ActivityInterface(2, i)
                    i++
                }
                setNeutralButton("Yellow"){_,_->
                    activityInterface.ActivityInterface(3, i)
                    i++
                }
            }.show()
        }
    }
    fun showToast(){
        Toast.makeText(this,"Invoked from Fragment",Toast.LENGTH_SHORT).show()
    }
}
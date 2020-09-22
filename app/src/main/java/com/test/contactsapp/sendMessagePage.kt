package com.test.contactsapp

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.test.contactsapp.ViewModel.Frag1ViewModel
import com.test.contactsapp.ViewUtils.JSONCaching
import kotlinx.android.synthetic.main.activity_send_message_page.*
import kotlinx.android.synthetic.main.activity_send_message_page.toolbar
import kotlinx.android.synthetic.main.activity_send_message_page.view.*
import org.json.JSONException
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*


class sendMessagePage : AppCompatActivity() {

    var otp: String = ""
    private lateinit var viewModel: Frag1ViewModel
    lateinit var progress:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message_page)

        viewModel = ViewModelProvider(this).get(Frag1ViewModel::class.java)
        otp = viewModel.generateRandomNumber()
        message.text = "Hi, your OTP is"
        textView.text = otp
        toolbar.ivback.setOnClickListener{
            finish()
        }
        progress = ProgressDialog(this)
        send.setOnClickListener {

           progress.show()
            viewModel.getapiData(intent.getStringExtra("number"), otp).observe(this, androidx.lifecycle.Observer {
                if (it == "success") {
                    progress.dismiss()
                    Toast.makeText(this, "SuccessFully otp sent", Toast.LENGTH_SHORT).show()
                    try {
                        //Calendar c = Calendar.getInstance();
                        val sdf = SimpleDateFormat("yyyyMMdd_HHmmss")
                        val currentDateandTime = sdf.format(Date())
                        val jsonObject = JSONObject()
                        jsonObject.put("name", intent.getStringExtra("name"))
                        jsonObject.put("number", intent.getStringExtra("number"))
                        jsonObject.put("OTP", otp)
                        jsonObject.put("Date", currentDateandTime)
                        Log.e("jsondata",jsonObject.toString())
                        JSONCaching(this@sendMessagePage).writeAppendToJSONFile(jsonObject)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    finish()
                    startActivity(Intent(this, MainActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or Intent.FLAG_ACTIVITY_CLEAR_TOP))
                } else {
                    progress.dismiss()
                    Toast.makeText(this, "Sorry,Please try after some time", Toast.LENGTH_SHORT)
                        .show()
                }
            })

        }
    }
}
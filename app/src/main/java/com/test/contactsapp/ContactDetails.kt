package com.test.contactsapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_contact_details.*
import kotlinx.android.synthetic.main.activity_contact_details.view.*
import org.json.JSONException

//class for Contact Details
class ContactDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)

        name.text = "Name : ${intent.getStringExtra("name")}"
        contact.text = "Contact No. : ${intent.getStringExtra("number")}"

        toolbar.ivback.setOnClickListener{
            finish()
        }
        sendMessageButton.setOnClickListener {
            val i = Intent(this@ContactDetails, sendMessagePage::class.java)
            try {
                i.putExtra("name", intent.getStringExtra("name"))
                i.putExtra("number", intent.getStringExtra("number"))
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            startActivity(i)
        }
    }

}
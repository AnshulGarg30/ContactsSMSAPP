package com.example.vipulsublaniya.contactapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vipulsublaniya.contactapp.Model.ContactListModel
import com.test.contactsapp.ContactDetails
import com.test.contactsapp.R
import kotlinx.android.synthetic.main.list_item_contacts.view.*
import org.json.JSONException


class ContactAdapter(val contextCompat: Context,val list: ArrayList<ContactListModel>):RecyclerView.Adapter<ContactAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val name=itemView.name
        val mobileno=itemView.mobileno
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item_contacts, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        holder.name.text="${list[position].firstName} ${list[position].lastName}"
        holder.mobileno.text=list[position].mobileno
        holder.itemView.setOnClickListener{
            val i = Intent(contextCompat, ContactDetails::class.java)
            try {
                i.putExtra("name",holder.name.text.toString())
                i.putExtra("number",holder.mobileno.text.toString())
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            contextCompat.startActivity(i)
        }
    }

}
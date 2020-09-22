package com.example.vipulsublaniya.contactapp.Adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vipulsublaniya.contactapp.Model.ContactListModel
import com.test.contactsapp.R
import kotlinx.android.synthetic.main.message_item_contacts.view.*
import org.json.JSONException


class MessageAdapter(val contextCompat: Context, val list: ArrayList<String>):RecyclerView.Adapter<MessageAdapter.ViewHolder>(){
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val count=itemView.count
        val mobileno=itemView.mobileno
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageAdapter.ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.message_item_contacts, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MessageAdapter.ViewHolder, position: Int) {
        Log.e("dataonpos",list[position])
        holder.count.text="${position+1}"
        holder.mobileno.text=list[position].toString()
    }



}
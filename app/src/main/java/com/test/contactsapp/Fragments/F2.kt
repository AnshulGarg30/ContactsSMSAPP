package com.test.contactsapp.Fragments

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vipulsublaniya.contactapp.Adapter.ContactAdapter
import com.example.vipulsublaniya.contactapp.Adapter.MessageAdapter
import com.example.vipulsublaniya.contactapp.Model.ContactListModel
import com.test.contactsapp.ViewModel.Frag1ViewModel
import com.test.contactsapp.ViewUtils.JSONCaching
import kotlinx.android.synthetic.main.frag_f1.view.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class F2 : Fragment() {


    private lateinit var viewModel: Frag1ViewModel
    //    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val fragmentView = inflater.inflate(com.test.contactsapp.R.layout.frag_f1, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //load data initially

        viewModel = ViewModelProvider(this).get(Frag1ViewModel::class.java)
        view.recyclerviewf1.layoutManager= LinearLayoutManager(context)
        view.recyclerviewf1.addItemDecoration(
            DividerItemDecoration(
                this.activity,
                LinearLayout.VERTICAL
            )
        )
        viewModel.refresh(activity!!)
        view.recyclerviewf1.adapter= MessageAdapter(context!!,viewModel.messagelist)
    }
}
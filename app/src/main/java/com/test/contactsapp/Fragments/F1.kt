package com.example.vipulsublaniya.contactapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vipulsublaniya.contactapp.Adapter.ContactAdapter
import com.example.vipulsublaniya.contactapp.Model.ContactListModel
import com.test.contactsapp.R
import com.test.contactsapp.ViewModel.Frag1ViewModel
import kotlinx.android.synthetic.main.frag_f1.view.*


class F1 : Fragment() {

    var adapterList: ArrayList<ContactListModel> = ArrayList()
    private lateinit var viewModel: Frag1ViewModel
    //@Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //inflate the layout
        val fragmentView = inflater.inflate(R.layout.frag_f1, container, false)
        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(Frag1ViewModel::class.java)
        view.recyclerviewf1.layoutManager= LinearLayoutManager(context)
        view.recyclerviewf1.addItemDecoration(
            DividerItemDecoration(
                this.activity,
                LinearLayout.VERTICAL
            )
        )
        adapterList = viewModel.readContacts(context!!,adapterList)
        view.recyclerviewf1.adapter=ContactAdapter(context!!,adapterList)
    }
}
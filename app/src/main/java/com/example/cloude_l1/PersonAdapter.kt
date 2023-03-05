package com.example.cloude_l1

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.cloude_l1.databinding.ItemBinding


    class PersonAdapter(var activity: Activity, var data: ArrayList<person>) : BaseAdapter() {
        override fun getCount(): Int {
            return data.size
        }

        override fun getItem(p0: Int): Any {
            return data[p0]
        }

        override fun getItemId(p0: Int): Long {
            return data[p0].id.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val binding = ItemBinding.inflate(LayoutInflater.from(p2!!.context), p2, false)
            val root = p1
            if (root == null)
            binding.name.text = "" + data[p0].name
            binding.id.text = data[p0].id
            binding.address.text = data[p0].address.toString()

            return binding.root
        }
    }


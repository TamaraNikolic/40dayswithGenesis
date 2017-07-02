package com.example.tamaranikolic.kotlin_proba

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_view.view.*

/**
 * Created by tamara.nikolic on 12.6.17..
 */

internal class RecordAdapter (private val arrayList: ArrayList<String>,
                              private val context: Context,
                              private val layout: Int) : RecyclerView.Adapter<RecordAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindItems(arrayList[position], context)
    }

    override fun getItemCount(): Int {
      return arrayList.size
    }


    internal class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(item : String, context : Context) {
            itemView.record_name.setText(item)
            itemView.setOnClickListener {
                val intent = Intent(context, PlayActivity :: class.java)
                intent.putExtra("item", item)
                context.startActivity(intent)
            }
        }

    }
}
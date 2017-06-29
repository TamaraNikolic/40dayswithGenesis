package com.example.tamaranikolic.kotlin_proba

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var recordAdapter: RecordAdapter ?= null
    private var recordList: ArrayList<String> ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
        setUpList()

    }

    private fun initComponents () {
        recordList = ArrayList<String>()
        recordList!!.addAll(resources.getStringArray(R.array.record_list))
        recordAdapter = RecordAdapter(recordList !!, this, R.layout.item_view)

        }

    private fun setUpList () {
        recyclerView.layoutManager = StaggeredGridLayoutManager(10, StaggeredGridLayoutManager.HORIZONTAL)
        recyclerView.adapter = recordAdapter
        recordAdapter!!.notifyDataSetChanged()
    }
}

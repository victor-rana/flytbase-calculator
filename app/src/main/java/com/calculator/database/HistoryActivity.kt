package com.calculator.database

import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class HistoryActivity : AppCompatActivity() {

    var listView: ListView? = null
    var expressions: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        listView = findViewById(R.id.lvHistory)

        expressions = intent .getSerializableExtra( "expressions" ) as ArrayList<String>

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1, android.R.id.text1, expressions
        )

        with(listView) {

            this!!.adapter = adapter

            // ListView Item Click Listener

            // ListView Item Click Listener
            this.onItemClickListener = OnItemClickListener { _, _, position, _ -> // ListView Clicked item index

                // ListView Clicked item value
                val itemValue = getItemAtPosition(position) as String

                // Show Alert
                Toast.makeText(
                    applicationContext,
                    itemValue, Toast.LENGTH_LONG
                )
                    .show()
            }
        }

    }
}
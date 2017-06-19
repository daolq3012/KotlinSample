package com.fstyle.kotlinsample.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.fstyle.kotlinsample.R
import com.fstyle.kotlinsample.adapters.ForecastListAdapter
import com.fstyle.kotlinsample.adapters.OnRecyclerViewItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnRecyclerViewItemClickListener<String> {

  private val items = listOf("Mon 6/19 - Sunny - 31/17",
      "Tue 6/20 - Foggy - 21/8", "Wed 6/21 - Cloudy - 22/17",
      "Thurs 6/22 - Rainy - 18/11", "Fri 6/23 - Sunny - 20/7")

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    txt_message.text = getString(R.string.hello_kotlin)

    list_forecast.layoutManager = LinearLayoutManager(this)
    val adapter = ForecastListAdapter(this)
    list_forecast.adapter = adapter
    adapter.updateData(items)
  }

  override fun onRecyclerViewItemClick(item: String) {
    Toast.makeText(this, item, Toast.LENGTH_LONG).show()
  }
}

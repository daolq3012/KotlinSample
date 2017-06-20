package com.fstyle.kotlinsample.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.fstyle.kotlinsample.R
import com.fstyle.kotlinsample.adapters.ForecastListAdapter
import com.fstyle.kotlinsample.adapters.OnRecyclerViewItemClickListener
import com.fstyle.kotlinsample.data.model.User
import com.fstyle.kotlinsample.data.source.UserRepository
import com.fstyle.kotlinsample.data.source.UserRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnRecyclerViewItemClickListener<User> {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    txt_message.text = getString(R.string.hello_kotlin)

    list_forecast.layoutManager = LinearLayoutManager(this)
    var dividerItemDecoration: DividerItemDecoration = DividerItemDecoration(this,
        DividerItemDecoration.VERTICAL)

    list_forecast.addItemDecoration(dividerItemDecoration)
    val adapter = ForecastListAdapter(this)
    list_forecast.adapter = adapter
    val userRepository: UserRepository = UserRepositoryImpl()
    // TODO update later
    val items = userRepository.searchUsers("", 0)
    adapter.updateData(items)
  }

  override fun onRecyclerViewItemClick(item: User?) {
    Toast.makeText(this, item?.name, Toast.LENGTH_LONG).show()
  }
}

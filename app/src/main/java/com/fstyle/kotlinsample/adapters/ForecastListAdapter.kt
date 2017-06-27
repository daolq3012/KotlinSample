package com.fstyle.kotlinsample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fstyle.kotlinsample.R
import com.fstyle.kotlinsample.data.model.User
import kotlinx.android.synthetic.main.layout_item_list_forecast.view.*

/**
 * Created by framgia on 16/06/2017.
 */
class ForecastListAdapter(
    context: Context) : BaseRecyclerViewAdapter<ForecastListAdapter.ItemViewHolder>(context) {

  private val mItemClickListener: OnRecyclerViewItemClickListener<User>
  private val mItems: ArrayList<User> = ArrayList()

  init {
    if (context is OnRecyclerViewItemClickListener<*>) {
      mItemClickListener = context as OnRecyclerViewItemClickListener<User>
    } else {
      mItemClickListener = null!!
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
    val layoutItem = LayoutInflater.from(context).inflate(R.layout.layout_item_list_forecast,
        parent,
        false)
    return ItemViewHolder(layoutItem, mItemClickListener)
  }

  override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
    holder?.bindData(mItems[position])
  }

  override fun getItemCount(): Int {
    return mItems.size
  }

  fun updateData(users: List<User>) {
    mItems.addAll(users)
    notifyDataSetChanged()
  }

  class ItemViewHolder(itemView: View,
      listener: OnRecyclerViewItemClickListener<User>) : RecyclerView.ViewHolder(itemView) {

    private var item: User? = null

    init {
      itemView.setOnClickListener({ listener.onRecyclerViewItemClick(item) })
    }

    fun bindData(item: User) {
      this.item = item
      with(item) {
        itemView.txt_info_forecast.text = "$userLogin - $id"
      }
    }
  }
}

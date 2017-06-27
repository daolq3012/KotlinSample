package com.fstyle.kotlinsample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fstyle.kotlinsample.R
import com.fstyle.kotlinsample.data.model.User

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

    private val mTextViewForecast: TextView = itemView.findViewById(
        R.id.txt_info_forecast) as TextView

    init {
      itemView.setOnClickListener({ listener.onRecyclerViewItemClick(item) })
    }

    fun bindData(item: User) {
      this.item = item
      with(item) {
        mTextViewForecast.text = "$userLogin - $id"
      }
    }
  }
}

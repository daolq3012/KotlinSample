package com.fstyle.kotlinsample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fstyle.kotlinsample.R

/**
 * Created by framgia on 16/06/2017.
 */
class ForecastListAdapter(
    context: Context) : BaseRecyclerViewAdapter<ForecastListAdapter.ItemViewHolder>(context) {

  private val mItemClickListener: OnRecyclerViewItemClickListener<String>
  private val mItems: ArrayList<String> = ArrayList()

  init {
    if (context is OnRecyclerViewItemClickListener<*>) {
      mItemClickListener = context as OnRecyclerViewItemClickListener<String>
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

  fun updateData(items: List<String>) {
    mItems.addAll(items)
    notifyDataSetChanged()
  }

  class ItemViewHolder(itemView: View,
      listener: OnRecyclerViewItemClickListener<String>) : RecyclerView.ViewHolder(itemView) {

    private var item: String = ""

    private val mTextViewForecast: TextView = itemView.findViewById(
        R.id.txt_info_forecast) as TextView

    init {
      itemView.setOnClickListener({ listener.onRecyclerViewItemClick(item) })
    }

    fun bindData(item: String) {
      this.item = item
      mTextViewForecast.text = item
    }
  }
}

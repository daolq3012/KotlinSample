package com.fstyle.kotlinsample.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView

/**
 * Created by framgia on 19/06/2017.
 */
abstract class BaseRecyclerViewAdapter<VH : RecyclerView.ViewHolder> protected constructor(
    protected val context: Context) : RecyclerView.Adapter<VH>()

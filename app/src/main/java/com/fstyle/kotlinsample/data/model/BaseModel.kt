package com.fstyle.kotlinsample.data.model

import com.google.gson.Gson

/**
 * Created by framgia on 19/06/2017.
 */

abstract class BaseModel : Cloneable {

  @Throws(CloneNotSupportedException::class)
  override fun clone(): BaseModel {
    val gson = Gson()
    return gson.fromJson(gson.toJson(this), this.javaClass)
  }
}

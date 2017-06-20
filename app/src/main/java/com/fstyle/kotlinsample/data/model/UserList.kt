package com.fstyle.kotlinsample.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by framgia on 19/06/2017.
 */
class UserList {
  @Expose
  @SerializedName("total_count")
  var totalCount: Int? = 0
  @Expose
  @SerializedName("items")
  var users: List<User> = ArrayList()
}

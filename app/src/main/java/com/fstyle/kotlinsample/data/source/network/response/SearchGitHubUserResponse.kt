package com.fstyle.kotlinsample.data.source.network.response

import com.fstyle.kotlinsample.data.model.User
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by framgia on 20/06/2017.
 */
class SearchGitHubUserResponse {
  @Expose
  var totalCount: Int = 0
  @Expose
  @SerializedName("items")
  var users: List<User> = ArrayList()
}

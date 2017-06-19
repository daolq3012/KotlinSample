package com.fstyle.kotlinsample.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by framgia on 19/06/2017.
 */
class User : BaseModel() {
  @Expose
  @SerializedName("login")
  var userLogin: String? = null
  @Expose
  @SerializedName("id")
  var id: Int? = null
  @Expose
  @SerializedName("name")
  var name: String? = null
  @Expose
  @SerializedName("avatar_url")
  var avatarUrl: String? = null
}

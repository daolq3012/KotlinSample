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
  var id: Int? = null
  @Expose
  var avatarUrl: String? = null
  @Expose
  var gravatarId: String? = null
}

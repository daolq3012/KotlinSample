package com.fstyle.kotlinsample.data.source

import com.fstyle.kotlinsample.data.model.User
import java.util.*

/**
 * Created by framgia on 19/06/2017.
 */
class UserRepositoryImpl : UserRepository {

  override fun getUser() {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun searchUsers(keyword: String, limit: Int): List<User> {
    var mUsers: ArrayList<User> = arrayListOf()
    for (i in 1..10) {
      var user: User = User()
      user.id = i
      user.name = "UserName $i"
      mUsers.add(user)
    }
    return mUsers
  }
}

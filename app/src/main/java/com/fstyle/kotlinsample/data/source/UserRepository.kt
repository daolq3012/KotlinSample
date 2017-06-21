package com.fstyle.kotlinsample.data.source

import com.fstyle.kotlinsample.data.model.User
import rx.Observable

/**
 * Created by framgia on 19/06/2017.
 */
interface UserRepository {
  fun getUser()

  fun searchUsers(keyword: String, limit: Int): Observable<List<User>>
}

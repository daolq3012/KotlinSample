package com.fstyle.kotlinsample.data.source

import com.fstyle.kotlinsample.data.model.User
import com.fstyle.kotlinsample.data.source.network.response.SearchGitHubUserResponse
import com.fstyle.kotlinsample.data.source.network.service.GitHubApi
import rx.Observable

/**
 * Created by framgia on 19/06/2017.
 */
class UserRepositoryImpl(val gitHubApi: GitHubApi) : UserRepository {

  override fun getUser() {
    TODO(
        "not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  override fun searchUsers(keyword: String, limit: Int): Observable<List<User>> {
    return gitHubApi.searchGithubUsers(keyword,
        limit.toString()).flatMap { response: SearchGitHubUserResponse ->
      Observable.just(response.users)
    }
  }
}

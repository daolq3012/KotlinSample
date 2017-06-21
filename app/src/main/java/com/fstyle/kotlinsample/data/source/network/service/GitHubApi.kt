package com.fstyle.kotlinsample.data.source.network.service

import com.fstyle.kotlinsample.data.source.network.response.SearchGitHubUserResponse
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by framgia on 20/06/2017.
 */
interface GitHubApi {

  @GET("/search/users")
  fun searchGithubUsers(@Query("q") keyword: String,
      @Query("per_page") limit: String): Observable<SearchGitHubUserResponse>
}

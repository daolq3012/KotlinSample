package com.fstyle.kotlinsample.data.source.network.service

import android.app.Application
import com.fstyle.kotlinsample.utils.Constant

/**
 * Created by framgia on 20/06/2017.
 */
class GitHubServiceClient : ServiceClient() {
  companion object {

    private var mGitHubApi: GitHubApi? = null

    fun initialize(application: Application) {
      mGitHubApi = createService(application, Constant.END_POINT_URL, GitHubApi::class.java,
          getGsonConfig(), null)
    }

    fun getInstance(): GitHubApi {
      if (mGitHubApi == null) {
        throw RuntimeException("Need call method NameServiceClient#initialize() first!")
      }
      return mGitHubApi as GitHubApi
    }
  }
}

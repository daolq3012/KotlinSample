package com.fstyle.kotlinsample.data.source.network.middleware

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import rx.Observable
import java.lang.reflect.Type

/**
 * Created by framgia on 19/06/2017.
 */
class RxErrorHandlingCallAdapterFactory private constructor() : CallAdapter.Factory() {

  private val mRxJavaCallAdapterFactory: RxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create()

  override fun get(returnType: Type?, annotations: Array<out Annotation>?,
      retrofit: Retrofit?): CallAdapter<*> {
    return RxCallAdapterWrapper(mRxJavaCallAdapterFactory.get(returnType, annotations, retrofit))
  }

  /**
   * RxCallAdapterWrapper
   */
  private class RxCallAdapterWrapper internal constructor(
      private val wrapped: CallAdapter<*>) : CallAdapter<Observable<*>> {

    override fun <R : Any?> adapt(call: Call<R>?): Observable<*> {
      return ((wrapped.adapt(
          call) as Observable<*>)).onErrorResumeNext {
        // TODO update catch Exception in here
        throwable ->
        Observable.error(throwable)
      }
    }

    override fun responseType(): Type {
      return wrapped.responseType()
    }
  }

  companion object {
    fun create(): CallAdapter.Factory {
      return RxErrorHandlingCallAdapterFactory()
    }
  }
}

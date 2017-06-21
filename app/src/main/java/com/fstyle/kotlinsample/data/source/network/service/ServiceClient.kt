package com.fstyle.kotlinsample.data.source.network.service

import android.app.Application
import com.fstyle.kotlinsample.BuildConfig
import com.fstyle.kotlinsample.data.source.network.middleware.RxErrorHandlingCallAdapterFactory
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by framgia on 19/06/2017.
 */
open class ServiceClient {
  companion object {
    private val CONNECTION_TIMEOUT = 60

    internal fun <T> createService(application: Application, endpoint: String,
        serviceClass: Class<T>, gson: Gson, interceptor: Interceptor?): T {
      val httpClientBuilder = OkHttpClient.Builder()
      val cacheSize = 10 * 1024 * 1024 // 10MB
      httpClientBuilder.cache(Cache(application.cacheDir, cacheSize.toLong()))
      if (interceptor != null) {
        httpClientBuilder.addInterceptor(interceptor)
      }
      httpClientBuilder.readTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
      httpClientBuilder.connectTimeout(CONNECTION_TIMEOUT.toLong(), TimeUnit.SECONDS)
      val retrofitBuilder = Retrofit.Builder().baseUrl(endpoint).addCallAdapterFactory(
          RxErrorHandlingCallAdapterFactory.create()).addConverterFactory(
          GsonConverterFactory.create(gson))

      if (BuildConfig.DEBUG) {
        val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClientBuilder.addInterceptor(logging)
      }

      val retrofit = retrofitBuilder.client(httpClientBuilder.build()).build()
      return retrofit.create(serviceClass)
    }

    internal fun getGsonConfig(): Gson {
      val booleanAdapter = BooleanAdapter()
      val integerAdapter = IntegerAdapter()

      return GsonBuilder().registerTypeAdapter(Boolean::class.java, booleanAdapter)
          .registerTypeAdapter(Boolean::class.javaPrimitiveType, booleanAdapter)
          .registerTypeAdapter(Int::class.java, integerAdapter)
          .registerTypeAdapter(Int::class.javaPrimitiveType, integerAdapter)
          .setFieldNamingPolicy(
              FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).excludeFieldsWithoutExposeAnnotation().create()
    }
  }
}

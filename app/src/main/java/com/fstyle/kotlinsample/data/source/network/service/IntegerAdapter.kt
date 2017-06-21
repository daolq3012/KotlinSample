package com.fstyle.kotlinsample.data.source.network.service

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException
import java.lang.NumberFormatException

/**
 * Created by framgia on 20/06/2017.
 */
class IntegerAdapter : TypeAdapter<Int>() {

  @Throws(IOException::class)
  override fun write(out: JsonWriter?, value: Int?) {
    if (value == null) {
      out?.nullValue()
      return
    }
    out?.value(value)
  }

  @Throws(IOException::class, NumberFormatException::class)
  override fun read(`in`: JsonReader?): Int? {
    val peek = `in`?.peek()
    when (peek) {
      JsonToken.NULL -> {
        `in`.nextNull()
        return null
      }

      JsonToken.NUMBER -> return `in`.nextInt()

      JsonToken.STRING -> return java.lang.Integer.valueOf(`in`.nextString())

      JsonToken.BOOLEAN -> {
        return if (`in`.nextBoolean()) 1 else 0
      }

      else -> return null
    }
  }
}

package com.fstyle.kotlinsample.data.source.network.service

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException

/**
 * Created by framgia on 20/06/2017.
 */
class BooleanAdapter : TypeAdapter<Boolean>() {

  @Throws(IOException::class)
  override fun read(`in`: JsonReader?): Boolean? {
    var peek = `in`?.peek()
    when (peek) {
      JsonToken.NULL -> {
        `in`?.nextNull()
        return null
      }

      JsonToken.BOOLEAN -> return `in`?.nextBoolean()

      JsonToken.NUMBER -> return `in`?.nextInt() != 0

      JsonToken.STRING -> return java.lang.Boolean.valueOf(`in`?.nextString())

      else -> return null
    }
  }

  @Throws(IOException::class)
  override fun write(out: JsonWriter?, value: Boolean?) {
    if (value == null) {
      out?.nullValue()
      return
    }
    out?.value(value)
  }
}

package com.dokong.allforone.ktx

import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  11.11. 19:08
 */
fun InputStream.toByteArray(): ByteArray = with(ByteArrayOutputStream()) {
    write(this@toByteArray, this)
    close()
    toByteArray()
}

@Throws(IOException::class)
fun write(inputStream: InputStream, outputStream: OutputStream) {
    val buffer = ByteArray(4096)
    val len = inputStream.read(buffer)
    while (len != -1) outputStream.write(buffer, 0, len)
}
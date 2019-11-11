package com.dokong.allforone.ktx

import cn.hutool.crypto.SecureUtil

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-11. 13:32
 */
fun String.md5(): String = SecureUtil.md5(this)

fun String.sha1(): String = SecureUtil.sha1(this)

fun String.sha256(): String = SecureUtil.sha256(this)

/**
 * 增强MD5算法
 * @param salt 盐值
 */
fun String.md5Hmac(salt: String) = SecureUtil.hmacMd5(salt)

fun String.sha1Hmac(salt: String) = SecureUtil.hmacSha1(this)

/**
 * DES对称加密
 * @param key
 */
fun String.encryptDES(key: String) = SecureUtil.des(key.toByteArray()).encrypt(this).toString()

fun String.decryptDES(key: String) = SecureUtil.des(key.toByteArray()).decrypt(this).toString()

/**
 * AES对称加密
 * @param key
 */
fun String.encryptAES(key: String) = SecureUtil.aes(key.toByteArray()).encrypt(this).toString()

fun String.decryptAES(key: String) = SecureUtil.aes(key.toByteArray()).decrypt(this).toString()
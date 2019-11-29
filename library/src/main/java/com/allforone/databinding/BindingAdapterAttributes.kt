package com.allforone.databinding

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Creat Time :  2019-11-28. 13:24
 * BindingAdapter 命名表
 */
//命名前缀
const val suffix = "app:"

//命名中缀 - 控件类型
const val type_view = "view_"
const val type_image = "image_"
const val type_recycler = "recycler_"

/**
 * View about
 */
const val VIEW_CLICK = "${suffix}${type_view}click"
const val VIEW_LONG_CLICK = "${suffix}${type_view}longClick"

/**
 * ImageView about
 */
const val IMAGE_URL = "${suffix}${type_image}url"
const val IMAGE_PLACEHOLDER = "${suffix}${type_image}placeholder"
const val IMAGE_ERROR = "${suffix}${type_image}error"

/***
 * RecyclerView about
 */
const val RECYCLER_BIND_ITEMS = "${suffix}${type_recycler}bind_items"


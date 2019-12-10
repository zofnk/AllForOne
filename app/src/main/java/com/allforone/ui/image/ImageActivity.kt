package com.allforone.ui.image

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.allforone.R
import com.allforone.core.common.BaseActivity
import com.allforone.databinding.ActImageBinding
import com.allforone.ktx.createViewModel
import kotlinx.android.synthetic.main.act_image.*

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-10. 10:27
 */
class ImageActivity : BaseActivity<ActImageBinding>() {

    private lateinit var imageViewModel: ImageViewModel

    companion object {
        fun start(ctx: Context) {
            ctx.startActivity(Intent(ctx, ImageActivity::class.java))
        }
    }

    override fun bindLayoutId() = R.layout.act_image

    override fun onCreated(savedInstanceState: Bundle?) {
        imageViewModel = createViewModel(ImageViewModel::class.java)

        rvImage.adapter = imageViewModel.imageAdapter
    }
}
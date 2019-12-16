package com.allforone.ui.image

import android.app.Application
import com.allforone.core.vm.BaseViewModel

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-10. 10:29
 */
class ImageViewModel(app: Application) : BaseViewModel(app) {

    val imageAdapter: ImageAdapter by lazy { ImageAdapter() }

    init {
        val imageData = mutableListOf(
            "https://desk-fd.zol-img.com.cn/t_s1920x1200c5/g4/M08/0C/09/Cg-4WVSBfl-IanN7AC__cIPrv8EAAR5PQMDkT8AL_-I272.jpg",
            "https://desk-fd.zol-img.com.cn/t_s1920x1200c5/g5/M00/02/08/ChMkJ1bKzFWIFLWLAA5J8SETqcwAALI1QAAAAAADkoJ782.jpg",
            "https://desk-fd.zol-img.com.cn/t_s1920x1200c5/g4/M08/0C/09/Cg-4WVSBfl-IanN7AC__cIPrv8EAAR5PQMDkT8AL_-I272.jpg",
            "https://desk-fd.zol-img.com.cn/t_s1920x1200c5/g5/M00/02/08/ChMkJ1bKzFWIFLWLAA5J8SETqcwAALI1QAAAAAADkoJ782.jpg",
            "https://desk-fd.zol-img.com.cn/t_s1920x1200c5/g4/M08/0C/09/Cg-4WVSBfl-IanN7AC__cIPrv8EAAR5PQMDkT8AL_-I272.jpg",
            "https://desk-fd.zol-img.com.cn/t_s1920x1200c5/g5/M00/02/08/ChMkJ1bKzFWIFLWLAA5J8SETqcwAALI1QAAAAAADkoJ782.jpg"
        )
        imageAdapter.setNewData(imageData)
    }
}
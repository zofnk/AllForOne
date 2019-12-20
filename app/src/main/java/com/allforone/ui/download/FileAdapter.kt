package com.allforone.ui.download

import android.content.Context
import androidx.annotation.NonNull
import com.allforone.R
import com.allforone.databinding.ItemFileBinding
import com.liulishuo.okdownload.DownloadTask
import com.liulishuo.okdownload.SpeedCalculator
import com.liulishuo.okdownload.StatusUtil
import com.liulishuo.okdownload.kotlin.enqueue4WithSpeed
import com.liulishuo.okdownload.kotlin.spChannel
import common.core.adapter.QuickBindingAdapter
import common.core.viewholder.BaseBindingViewHolder
import common.ktx.click
import common.ktx.load
import common.ktx.logE
import common.ktx.toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import java.io.File

/**
 * Author : zofnk.
 * Email : zofnk@vip.qq.com.
 * Create Time :  2019-12-20. 11:46
 */
data class FileBean(var name: String, var url: String, var icon: String)

class FileAdapter : QuickBindingAdapter<FileBean, ItemFileBinding>(R.layout.item_file) {

    @ExperimentalCoroutinesApi
    override fun convert(hepler: BaseBindingViewHolder<ItemFileBinding>, item: FileBean) {
        val task: DownloadTask = DownloadTask.Builder(item.url, getParentFile(mContext))
            .setFilename(item.name)
            .setMinIntervalMillisCallbackProcess(16)
            .setPassIfAlreadyCompleted(false)
            .build()

        hepler.viewBinding.apply {
            tvName.text = item.name
            ivIcon.load(item.icon, roundRadius = 4, thumbSize = 0.1f)

            task.let {
                val status = StatusUtil.getStatus(it)
                if (status == StatusUtil.Status.COMPLETED) {
                    pgItem.progress = pgItem.max
                }
                StatusUtil.getCurrentInfo(it)?.let { info ->
                    val offset = info.totalOffset
                    val total = info.totalLength
                    val percent = offset.toFloat() / total.toFloat()

                    percent.toString()
                        .logE("getCurrentInfo offset : $offset , totalLength : $total , percent :")

                    tvStartProgress.text = offset.toString()
                    tvEndProgress.text = total.toString()
                    pgItem.progress = (percent * pgItem.max).toInt()
                }
            }

            btnStart.click {
                btnStart.text = "开始"
                task.let { task ->
                    if (task.tag != null) {
                        task.cancel()
                    } else {
                        btnStart.text = "取消"
                        task.tag = item.url

                        var totalLength: Long = 0
                        task.enqueue4WithSpeed(
                            onTaskStart = {
                                mContext.toast("开始下载")
                            }
                        ) { task, cause, realCause, taskSpeed ->
                            btnStart.text = "开始"
                            task.tag = null
                            realCause?.let {
                                mContext.toast("download error : $it")
                            }
                        }
                        // Second way to show progress.
                        val speedCalculator = SpeedCalculator()
                        CoroutineScope(Dispatchers.Main).launch {
                            var lastOffset = 0L
                            task.spChannel().consumeEach { dp ->
                                val increase = when (lastOffset) {
                                    0L -> 0L
                                    else -> dp.currentOffset - lastOffset
                                }
                                lastOffset = dp.currentOffset
                                speedCalculator.downloading(increase)

                                val offset = dp.currentOffset
                                val total = totalLength
                                val percent = offset.toFloat() / total.toFloat()


                                percent.toString()
                                    .logE("task offset : $offset , totalLength : $totalLength , percent : ")
                                tvStartProgress.text = offset.toString()
                                tvEndProgress.text = total.toString()
                                pgItem.progress = (percent * pgItem.max).toInt()
                            }
                        }
                    }
                }
            }
            this.item = item
            executePendingBindings()
        }
    }

    private fun getParentFile(@NonNull context: Context): File {
//       return "${Environment.getExternalStorageDirectory().absolutePath}${File.separator}allforone${File.separator}files"
        val externalSaveDir = context.externalCacheDir
        return externalSaveDir ?: context.cacheDir
    }
}

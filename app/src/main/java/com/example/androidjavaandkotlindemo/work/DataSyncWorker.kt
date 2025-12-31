package com.example.androidjavaandkotlindemo.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

/**
 * DataSyncWorker - 使用Kotlin编写
 * 使用WorkManager进行后台任务处理
 */
class DataSyncWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {
    
    override suspend fun doWork(): Result {
        return try {
            // 执行后台任务
            // 例如：同步数据、上传日志等
            
            // 示例：模拟一些工作
            Thread.sleep(2000)
            
            Result.success(
                workDataOf("result" to "数据同步完成")
            )
        } catch (e: Exception) {
            Result.failure(
                workDataOf("error" to e.message)
            )
        }
    }
}


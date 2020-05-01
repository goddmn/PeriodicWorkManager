package com.example.periodicworkmanager

import android.content.Context
import android.content.Intent
import androidx.work.Worker
import androidx.work.WorkerParameters

class Worker(context: Context, workerParameters: WorkerParameters) : Worker(context, workerParameters){
    val mContext = context
    override fun doWork(): Result {
        val intent = Intent(mContext, MainActivity::class.java)
        mContext.startActivity(intent)
        return Result.success()
    }

}
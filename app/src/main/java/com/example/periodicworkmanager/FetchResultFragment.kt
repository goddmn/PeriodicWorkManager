package com.example.periodicworkmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit


class FetchResultFragment : Fragment() {
    private lateinit var workManager: WorkManager
    lateinit var txtResult: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fetch_result, container, false)
        initViews(view)
        getValue()
        initWorkManagerDelay()
        return view
    }

    private fun initViews(view: View) {
        txtResult = view.findViewById(R.id.txt_result)
    }

    private fun getValue() {
        if (arguments?.get("value") != null){
            txtResult.text = arguments?.get("value").toString()
        }
    }

    private fun initWorkManagerDelay() {
        workManager = WorkManager.getInstance()
        val requestBuilder = OneTimeWorkRequest.Builder(Worker::class.java).setInitialDelay(5, TimeUnit.SECONDS).build()
        workManager.enqueue(requestBuilder)
    }

}

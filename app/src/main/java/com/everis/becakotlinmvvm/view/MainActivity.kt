package com.everis.becakotlinmvvm.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.everis.becakotlinmvvm.databinding.ActivityMainBinding
import com.everis.becakotlinmvvm.viewmodel.HolidayViewModel

class MainActivity : AppCompatActivity() {

    val TAG_LOG = javaClass.simpleName

    lateinit var holidayAdapter: HolidayAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()

        binding.progressBar.visibility = View.VISIBLE

        val holidayViewModel = HolidayViewModel()
        initObserver(holidayViewModel)
    }

    private fun initUI() {
        binding.rvHolidayList.setHasFixedSize(true);
        val layoutManager = LinearLayoutManager(this)
        binding.rvHolidayList.layoutManager = layoutManager
        binding.rvHolidayList.itemAnimator = DefaultItemAnimator()

        holidayAdapter = HolidayAdapter()
        binding.rvHolidayList.adapter = holidayAdapter
    }

    private fun initObserver(holidayViewModel: HolidayViewModel) {
        holidayViewModel.getHolidays().observe(this,
                { listHolidays ->
                    Log.e(TAG_LOG, "observe onChanged()=" + listHolidays?.size)
                    binding.progressBar.visibility = View.GONE
                    holidayAdapter.addData(listHolidays!!)
                    holidayAdapter.notifyDataSetChanged()
                })
    }

}
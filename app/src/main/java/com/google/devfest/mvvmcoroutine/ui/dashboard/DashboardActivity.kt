package com.google.devfest.mvvmcoroutine.ui.dashboard

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.devfest.mvvmcoroutine.common.BaseActivity
import com.google.devfest.mvvmcoroutine.common.DiffCallback
import com.google.mvvmcoroutine.R
import kotlinx.android.synthetic.main.activity_dashboard.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardActivity : BaseActivity() {

    private val dashboardViewModel by viewModel<DashboardViewModel>()
    private val diffCallback by inject<DiffCallback>()

    private val dashboardAdapter by lazy {
        DashboardAdapter(diffCallback) {
            Toast.makeText(this@DashboardActivity, "Id User : $it", Toast.LENGTH_SHORT).show()
        }
    }

    override fun loadDepsModule() {
        DashboardModule.loadModules()
    }

    override fun onViewReady(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_dashboard)

        with(rvUser) {
            layoutManager = LinearLayoutManager(this@DashboardActivity)
            val dividerItemDecoration = DividerItemDecoration(this@DashboardActivity, LinearLayoutManager.VERTICAL)
            adapter = dashboardAdapter
            addItemDecoration(dividerItemDecoration)
        }

        dashboardViewModel.users.observe(this) {
            dashboardAdapter.setListUserData(it)
        }

        dashboardViewModel.fetchUsers()
    }
}

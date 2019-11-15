package com.google.devfest.mvvmcoroutine.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.devfest.mvvmcoroutine.common.DiffCallback
import com.google.devfest.mvvmcoroutine.model.response.Data
import com.google.mvvmcoroutine.R
import kotlinx.android.synthetic.main.item_student.view.*
import java.util.Locale

/**
 * Created by herisulistiyanto on 2019-11-15.
 * KjokenKoddinger
 */

class DashboardAdapter(
        private val diffCallback: DiffCallback = DiffCallback(),
        private val listener: (Int) -> Unit)
    : RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder>() {

    private val listData = mutableListOf<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val holderView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_student, parent, false)
        return DashboardViewHolder(holderView)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        holder.onBind(listData[holder.adapterPosition], listener)
    }

    override fun getItemCount() = listData.size

    fun setListUserData(data: List<Data>?) {
        calculateDiff(data.orEmpty())
    }

    private fun calculateDiff(newData: List<Data>) {
        diffCallback.setList(listData, newData)
        val result = DiffUtil.calculateDiff(diffCallback)
        with(listData) {
            clear()
            addAll(newData)
        }
        result.dispatchUpdatesTo(this)
    }

    inner class DashboardViewHolder(private val curView: View) : RecyclerView.ViewHolder(curView) {

        fun onBind(data: Data, listener: (Int) -> Unit) {
            with(curView) {
                tvInitial.text = data.name.extractInitial()
                tvName.text = data.name
                tvEmail.text = data.email

                if (adapterPosition != RecyclerView.NO_POSITION) {
                    setOnClickListener {
                        listener.invoke(data.id)
                    }
                }
            }
        }

    }

    fun String?.extractInitial(): String {
        return if (this.isNullOrEmpty()) "" else this.take(2).toUpperCase(Locale.getDefault())
    }

}
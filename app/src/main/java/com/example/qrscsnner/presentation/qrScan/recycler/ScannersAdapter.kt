package com.example.qrscsnner.presentation.qrScan.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qrscsnner.domain.models.ScannerResult

class ScannersAdapter(private val shareScan: (scannerResult: ScannerResult) -> Unit) : RecyclerView.Adapter<ScannersViewHolder>() {

    private var items = listOf<ScannerResult>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScannersViewHolder {
        return ScannersViewHolder.newInstance(parent, shareScan)
    }

    override fun onBindViewHolder(holder: ScannersViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount() = items.size

    fun bindItem(scannerResults: List<ScannerResult>){
        items = scannerResults
        notifyDataSetChanged()
    }

}
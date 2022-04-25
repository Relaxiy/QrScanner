package com.example.qrscsnner.presentation.qrScan.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qrscsnner.R
import com.example.qrscsnner.databinding.ScannerItemBinding
import com.example.qrscsnner.domain.models.ScannerResult

class ScannersViewHolder(
    private val binding: ScannerItemBinding,
    private val shareScan: (scannerResult: ScannerResult) -> Unit
) : RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun newInstance(
            parent: ViewGroup,
            shareScan: (scannerResult: ScannerResult) -> Unit
        ) = ScannersViewHolder(
            ScannerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            shareScan
        )
    }

    fun bindItem(scannerItem: ScannerResult) {
        binding.apply {
            scannerResult.text = scannerItem.result
            scanDate.text = scannerItem.currentDate
            scanTime.text = scannerItem.currentTime
            btnShare.setOnClickListener {
                shareScan(scannerItem)
            }
        }
    }
}
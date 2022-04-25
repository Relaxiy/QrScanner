package com.example.qrscsnner.presentation.qrScan

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.qrscsnner.R
import com.example.qrscsnner.databinding.ActivityMainBinding
import com.example.qrscsnner.domain.models.ScannerResult
import com.example.qrscsnner.presentation.qrScan.recycler.ScannersAdapter
import com.example.qrscsnner.utils.appComponent
import com.example.qrscsnner.utils.openFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val adapter by lazy {
        ScannersAdapter { scannerResult ->
            shareScan(scannerResult)
        }
    }

    private val mainActivityViewModel: MainActivityViewModel by viewModels {
        appComponent.viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        openScanner()
        initRecycler()
    }

    private fun openScanner() {
        binding.btn.setOnClickListener {
            openFragment(CodeScannerFragment.TAG, CodeScannerFragment.newInstance(), R.id.container)
        }
    }

    private fun shareScan(scannerResult: ScannerResult) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            data = Uri.parse("mailto:")
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, "result")
            putExtra(
                Intent.EXTRA_TEXT,
                scannerResult.toString()
            )
        }
        startActivity(Intent.createChooser(intent, "Choose Client"))
    }

    private fun initRecycler() {
        binding.recycler.adapter = adapter
        mainActivityViewModel.scannerResults.observe(this) { scannerResult ->
            adapter.bindItem(scannerResult)
        }
    }
}
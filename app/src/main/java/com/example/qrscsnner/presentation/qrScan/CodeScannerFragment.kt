package com.example.qrscsnner.presentation.qrScan

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.qrscsnner.R
import com.example.qrscsnner.databinding.FragmentCodeScannerBinding
import com.example.qrscsnner.utils.appComponent

class CodeScannerFragment : Fragment(R.layout.fragment_code_scanner) {

    companion object{
        const val TAG = "CodeScannerFragment"
        fun newInstance() = CodeScannerFragment()
    }

    private val binding by viewBinding<FragmentCodeScannerBinding>()

    private val codeScanner by lazy {
        CodeScanner(requireContext(), binding.scannerView)
    }

    private val mainActivityViewModel by viewModels<MainActivityViewModel> {
        requireActivity().appComponent.viewModelsFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initScanner()
    }

    private fun initScanner() {
        codeScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats = CodeScanner.ALL_FORMATS
            autoFocusMode = AutoFocusMode.SAFE
            scanMode = ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false

            decodeCallback = DecodeCallback { result ->
                requireActivity().runOnUiThread {
                    mainActivityViewModel.saveScannerResult(result.text)
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                }
            }
            codeScanner.errorCallback = ErrorCallback {
                requireActivity().runOnUiThread {
                    Toast.makeText(
                        requireContext(),
                        "Camera initialization error: ${it.message}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        binding.scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

}
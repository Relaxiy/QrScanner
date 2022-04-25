package com.example.qrscsnner.presentation.qrScan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrscsnner.domain.ScannerResultInteractor
import com.example.qrscsnner.domain.models.ScannerResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val scannerResultInteractor: ScannerResultInteractor
) : ViewModel() {

    val scannerResults: LiveData<List<ScannerResult>> get() = _scannerResults
    private val _scannerResults = MutableLiveData<List<ScannerResult>>()

    init {
        getScannerResults()
    }

    private fun getScannerResults() {
        viewModelScope.launch {
            scannerResultInteractor.getScannerResults().collect { list ->
                _scannerResults.postValue(list)
            }
        }
    }

    fun saveScannerResult(result: String) {
        viewModelScope.launch {
            scannerResultInteractor.saveScannerResult(
                createScannerResult(result)
            )
        }
    }

    private fun createScannerResult(result: String): ScannerResult {
        return ScannerResult(result = result)
    }
}
package com.example.cleanarchitecturestudy.view.qr

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivityQrBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.ScanContract
import com.journeyapps.barcodescanner.ScanIntentResult
import com.journeyapps.barcodescanner.ScanOptions


class QrCodeActivity: BaseActivity<ActivityQrBinding>(R.layout.activity_qr) {

    /**
     * zxing Library 버전에 따라 사용되는 방법이 다르기 때문에, 두 가지 방법으로 사용해 보았음.
     */
    fun btnClick(view: View) {
        when(view.id) {
            R.id.btn_qr_code -> {
                initQrCode()
            }
            R.id.btn_qr_code_new -> {
                launcherQrCode()
            }
        }
    }

    private fun initQrCode() {
        val integrator = IntentIntegrator(this)
        integrator.setPrompt("Barcode or QR Code")
        integrator.setOrientationLocked(false)
        integrator.setBeepEnabled(true)
        integrator.initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)

        if (result != null) {
            binding.qrText.text = result.toString()
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun launcherQrCode() {
        val options = ScanOptions()
        options.setDesiredBarcodeFormats(ScanOptions.QR_CODE)
        options.setPrompt("Scan a barcode")
        options.setBeepEnabled(false)
        options.setBarcodeImageEnabled(true)
        barcodeLauncher.launch(options)
    }

    private val barcodeLauncher: ActivityResultLauncher<ScanOptions> =
        registerForActivityResult<ScanOptions, ScanIntentResult>(
            ScanContract(),
            ActivityResultCallback { result: ScanIntentResult ->
                if (result.contents == null) {
                    Toast.makeText(this@QrCodeActivity, "Cancelled", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(
                        this@QrCodeActivity,
                        "Scanned: " + result.contents,
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
}
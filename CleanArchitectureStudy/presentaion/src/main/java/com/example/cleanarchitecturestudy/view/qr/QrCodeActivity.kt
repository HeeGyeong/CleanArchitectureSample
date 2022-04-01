package com.example.cleanarchitecturestudy.view.qr

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.cleanarchitecturestudy.R
import com.example.cleanarchitecturestudy.base.BaseActivity
import com.example.cleanarchitecturestudy.databinding.ActivityQrBinding
import com.google.zxing.integration.android.IntentIntegrator

class QrCodeActivity: BaseActivity<ActivityQrBinding>(R.layout.activity_qr) {

    fun btnClick(view: View) {
        when(view.id) {
            R.id.btn_qr_code -> {
                initQrCode()
            }
        }
    }

    private fun initQrCode() {
        val integrator = IntentIntegrator(this)
        integrator.setPrompt("바코드 및 QR코드 등록을 위해\n상자안에 위치시켜 주세요\n\n")
        integrator.setOrientationLocked(false) // 세로,가로 모드를 고정 시켜주는 역할
        integrator.setBeepEnabled(true) // QR코드 스캔시 소리 나게 하려면 true 아니면 false로 지
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
}
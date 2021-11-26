package com.example.test

import android.content.Intent
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult

class QrcodeScanActivity : AppCompatActivity() {

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val result: IntentResult =
            IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if(result != null) {
            if (result.contents == null) {
                Log.e("this", "잘못된 QR코드입니다.")
            } else {
                Log.e("this", result.contents.toString())
            }
        }
        else{
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}

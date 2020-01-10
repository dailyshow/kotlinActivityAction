package com.cis.activityaction

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    // 전화는 권한을 요청해야한다.
    val permissionList = arrayOf(
        Manifest.permission.CALL_PHONE
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()

        btn1.setOnClickListener { view ->
            val uri1 = Uri.parse("geo: 37.243243, 131.861601")
            val intent1 = Intent(Intent.ACTION_VIEW, uri1)
            startActivity(intent1)
        }

        btn2.setOnClickListener { view ->
            val uri2 = Uri.parse("http://developer.android.com")
            val intent2 = Intent(Intent.ACTION_VIEW, uri2)
            startActivity(intent2)
        }

        btn3.setOnClickListener { view ->
            val uri3 = Uri.parse("tel:01012341234")
            val intent3 = Intent(Intent.ACTION_DIAL, uri3)
            startActivity(intent3)
        }

        btn4.setOnClickListener { view ->
            val uri4 = Uri.parse("tel:01098769876")
            val intent4 = Intent(Intent.ACTION_CALL, uri4)
            startActivity(intent4)
        }
    }

    fun checkPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }

        for (permission: String in permissionList) {
            val chk = checkCallingOrSelfPermission(permission)

            if (chk == PackageManager.PERMISSION_DENIED) {
                requestPermissions(permissionList, 0)
                break
            }
        }
    }
}

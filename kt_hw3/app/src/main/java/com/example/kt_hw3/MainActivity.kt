package com.example.kt_hw3

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle("請選擇功能")
                    .setMessage("請根據下方按鈕選擇要顯示的物件")
                    .setNeutralButton("取消") { dialogInterface, i -> Toast.makeText(this, "dialog關閉", Toast.LENGTH_SHORT).show()}
                    .setNegativeButton("自定義Toast") { dialogInterface, i -> showToast() }
                    .setPositiveButton("顯示list") { dialogInterface, i -> showListDialog() }
                    .show()
        }
    }

    private fun showToast() {
        val toast = Toast(this)
        toast.setGravity(Gravity.TOP, 0, 50)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layoutInflater.inflate(R.layout.custom_toast,null)
        toast.show()
    }

    private fun showListDialog() {
        val list = arrayOf("massage1", "massage2", "massage3", "massage4", "massage5")
        AlertDialog.Builder(this)
                .setTitle("使用LIST呈現")
                .setItems(list) { dialogInterface, i -> Toast.makeText(this, "你選得是" + list[i], Toast.LENGTH_SHORT).show()}
                .show()
    }
}
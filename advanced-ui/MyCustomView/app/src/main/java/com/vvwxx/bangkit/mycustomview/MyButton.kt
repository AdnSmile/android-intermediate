package com.vvwxx.bangkit.mycustomview

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat

class MyButton : AppCompatButton {

    private lateinit var enabledBackground: Drawable
    private lateinit var disabledBackground: Drawable
    private var txtColor: Int = 0

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    // Metode onDraw() digunakan untuk mengcustom button ketika enable dan disable
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        background = if (isEnabled) enabledBackground else disabledBackground // Mengubah background dari Button

        setTextColor(txtColor) // Mengubah warna text pada button
        textSize = 12f // Mengubah ukuran text pada button
        gravity = Gravity.CENTER // Menjadikan object pada button menjadi center
        text = if (isEnabled) "Submit" else "Isi Dulu" // Mengubah text pada button pada kondisi enable dan disable
    }

    private fun init() {
        txtColor = ContextCompat.getColor(context, android.R.color.background_light)
        enabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button) as Drawable
        disabledBackground = ContextCompat.getDrawable(context, R.drawable.bg_button_disable) as Drawable
    }
}
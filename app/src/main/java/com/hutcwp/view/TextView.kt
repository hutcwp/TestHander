package com.hutcwp.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import com.hutcwp.testhander.R


/**
 *  author : kevin
 *  date : 2023/6/4 15:09
 *  description :
 */
class TextView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    var text: CharSequence? = ""
    var textSize: Float = 0F

    var staticLayout: StaticLayout? = null


    private val paint by lazy {
        Paint().apply {
            color = Color.WHITE
            textSize = 14f
        }
    }

    init {
        val ta: TypedArray = context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.TextView, 0, 0
        )

        text = ta.getText(R.styleable.TextView_text)
        textSize = ta.getDimension(R.styleable.TextView_textSize, 0F)

        paint.textSize = textSize
    }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
    }

    override fun onDraw(canvas: Canvas?) {
        staticLayout = StaticLayout(
            text?.toString(),
            TextPaint(paint), 1000, Layout.Alignment.ALIGN_NORMAL, 1f, 0f, true
        )

        staticLayout?.draw(canvas)

//        canvas?.drawText(text?.toString() ?: "AAA", 50f, 50f, paint)
    }

}
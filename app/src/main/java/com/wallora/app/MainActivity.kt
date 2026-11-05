package com.wallora.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {

    private val backgroundColor = Color.rgb(15, 17, 25)
    private val accentColor = Color.rgb(120, 90, 255)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = backgroundColor
        window.navigationBarColor = backgroundColor

        val scroll = ScrollView(this)
        scroll.setBackgroundColor(backgroundColor)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(20, 35, 20, 30)

        scroll.addView(layout)

        val logo = TextView(this)
        logo.text = "WALLORA"
        logo.textSize = 34f
        logo.setTextColor(Color.WHITE)
        logo.typeface = Typeface.DEFAULT_BOLD
        logo.gravity = Gravity.CENTER
        layout.addView(logo)

        val subtitle = TextView(this)
        subtitle.text = "اكتشف عالمًا جديدًا من الخلفيات"
        subtitle.textSize = 16f
        subtitle.setTextColor(Color.LTGRAY)
        subtitle.gravity = Gravity.CENTER
        subtitle.setPadding(0, 10, 0, 30)
        layout.addView(subtitle)

        addHeading(layout, "استكشف التصنيفات")

        val categories = listOf(
            "🌿 الطبيعة",
            "🌌 الفضاء",
            "🏎️ السيارات",
            "💎 الفخامة",
            "🎭 الأنمي"
        )

        for (category in categories) {
            addButton(layout, category)
        }

        addHeading(layout, "مكتبة الخلفيات")

        addButton(layout, "🖼️ الخلفيات الثابتة")
        addButton(layout, "✨ الخلفيات المتحركة")
        addButton(layout, "❤️ المفضلة")

        val footer = TextView(this)
        footer.text = "WALLORA • VERSION 1.0"
        footer.setTextColor(Color.GRAY)
        footer.gravity = Gravity.CENTER
        footer.setPadding(0, 35, 0, 10)
        layout.addView(footer)

        setContentView(scroll)
    }

    private fun addHeading(
        layout: LinearLayout,
        title: String
    ) {
        val heading = TextView(this)
        heading.text = title
        heading.textSize = 21f
        heading.setTextColor(Color.WHITE)
        heading.typeface = Typeface.DEFAULT_BOLD
        heading.setPadding(0, 25, 0, 15)
        layout.addView(heading)
    }

    private fun addButton(
        layout: LinearLayout,
        title: String
    ) {
        val button = Button(this)
        button.text = title
        button.textSize = 16f
        button.setTextColor(Color.WHITE)
        button.setBackgroundColor(
            Color.rgb(35, 38, 55)
        )

        button.setOnClickListener {
            Toast.makeText(
                this,
                "$title قريبًا",
                Toast.LENGTH_SHORT
            ).show()
        }

        val params = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            60
        )

        params.bottomMargin = 12
        layout.addView(button, params)
    }
}

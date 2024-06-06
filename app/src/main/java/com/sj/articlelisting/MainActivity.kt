package com.sj.articlelisting

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<LinearLayout>(R.id.searchLayout).setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            startActivity(intent)
        }

        findViewById<LinearLayout>(R.id.mostViewedLayout).setOnClickListener {
            val intent = Intent(this, ArticleListingActivity::class.java)
            intent.putExtra("listType", "mostViewed")
            startActivity(intent)
        }

        findViewById<LinearLayout>(R.id.mostSharedLayout).setOnClickListener {
            val intent = Intent(this, ArticleListingActivity::class.java)
            intent.putExtra("listType", "mostShared")
            startActivity(intent)
        }

        findViewById<LinearLayout>(R.id.mostEmailedLayout).setOnClickListener {
            val intent = Intent(this, ArticleListingActivity::class.java)
            intent.putExtra("listType", "mostEmailed")
            startActivity(intent)
        }

    }
}
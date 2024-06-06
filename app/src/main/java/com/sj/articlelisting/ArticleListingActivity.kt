package com.sj.articlelisting

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.sj.articlelisting.databinding.ActivityArticleListingBinding
import com.sj.articlelisting.ui.ArticleAdapter
import com.sj.articlelisting.ui.MostPopularArticleAdapter
import com.sj.articlelisting.viewmodel.ArticleViewModel

class ArticleListingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArticleListingBinding
    private val viewModel: ArticleViewModel by viewModels()
    private lateinit var loadingDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleListingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        // Initialize the loading dialog
        loadingDialog = createLoadingDialog()

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe loading state
        viewModel.loadingState.observe(this, Observer { isLoading ->
            if (isLoading) {
                showLoadingDialog()
            } else {
                hideLoadingDialog()
            }
        })


        intent = getIntent();
        val listType = intent.getStringExtra("listType") ?: "search"
        val query = intent.getStringExtra("query")

        if (listType == "search") {
            supportActionBar?.title = "Search results for: $query"
            // Fetch articles
            viewModel.getArticles(query ?: "").observe(this, Observer { articles ->
                recyclerView.adapter = articles?.let { ArticleAdapter(it) }
            })
        } else {

            when (listType) {
                "mostEmailed" -> {
                    supportActionBar?.title = "Most Emailed Articles"

                    // Fetch most emailed articles
                    viewModel.getMostEmailed().observe(this, Observer { articles ->
                        recyclerView.adapter = articles?.let { MostPopularArticleAdapter(it) }
                    })
                }

                "mostShared" -> {

                    supportActionBar?.title = "Most Shared Articles"
                    // Fetch most shared articles
                    viewModel.getMostShared().observe(this, Observer { articles ->
                        recyclerView.adapter = articles?.let { MostPopularArticleAdapter(it) }
                    })
                }

                "mostViewed" -> {

                    supportActionBar?.title = "Most Viewed Articles"
                    // Fetch most viewed articles
                    viewModel.getMostViewed().observe(this, Observer { articles ->
                        recyclerView.adapter = articles?.let { MostPopularArticleAdapter(it) }
                    })
                }
            }
        }

    }

    private fun createLoadingDialog(): Dialog {
        val builder = AlertDialog.Builder(this)
        val inflater = layoutInflater
        val dialogView = inflater.inflate(R.layout.dialog_loading, null)
        builder.setView(dialogView)
        builder.setCancelable(false)

        val dialog = builder.create()
        dialog.setOnShowListener {
            // Set the height of the dialog
            val window = dialog.window
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
        return dialog
    }


    private fun showLoadingDialog() {
        if (!loadingDialog.isShowing) {
            loadingDialog.show()
        }
    }

    private fun hideLoadingDialog() {
        if (loadingDialog.isShowing) {
            loadingDialog.dismiss()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}

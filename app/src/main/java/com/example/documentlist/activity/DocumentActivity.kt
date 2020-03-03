package com.example.documentlist.activity

import android.app.Activity
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.compose.Composable
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import com.example.documentlist.model.VKDocs
import com.example.documentlist.request.DocsRequest
import com.example.documentlist.ui.LoginScreen
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback

class DocumentActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme() {
                Text("wtf")
                requestDocuments()
            }
        }

    }


    private fun requestDocuments() {
        VK.execute(DocsRequest(), object : VKApiCallback<List<VKDocs>> {
            override fun fail(error: Exception) {
                Log.e(ContentValues.TAG, error.toString())

                setContent {
                    MaterialTheme {
                        Greeting(error.toString())
                    }
                }

            }

            override fun success(result: List<VKDocs>) {
                if (!isFinishing && result.isNotEmpty())
                    setContent {
                        showDocs(result)
                    }
            }
        })
    }

    @Composable
    private fun showDocs(docs: List<VKDocs>) {
        LoginScreen(docs)
    }

    companion object {
        fun startFrom(context: Context) {
            val intent = Intent(context, DocumentActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent)
        }
    }

}
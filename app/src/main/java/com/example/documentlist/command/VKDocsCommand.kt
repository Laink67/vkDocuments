package com.example.documentlist.command

import com.example.documentlist.model.VKDocs
import com.vk.api.sdk.VKApiManager
import com.vk.api.sdk.VKApiResponseParser
import com.vk.api.sdk.VKMethodCall
import com.vk.api.sdk.internal.ApiCommand

/*
class VKDocsCommand() : ApiCommand<List<VKDocs>>() {
    override fun onExecute(manager: VKApiManager): List<VKDocs> {
        val call = VKMethodCall.Builder()
            .method("docs.get")
            .args("fields", "title_50")
            .version(manager.config.version)
            .build()

//        return manager.execute(call, VKApiResponseParser {  })
    }
}*/

package com.example.documentlist.request

import com.example.documentlist.model.VKDocs
import com.example.documentlist.model.VKUser
import com.vk.api.sdk.requests.VKRequest
import org.json.JSONObject

class DocsRequest : VKRequest<List<VKDocs>> {
    constructor(uids: IntArray = intArrayOf()) : super("docs.get") {
        if (uids.isNotEmpty()) {
            addParam("user_ids", uids.joinToString { "," })
        }
        addParam("fields", "title_50")
    }

    override fun parse(r: JSONObject): List<VKDocs> {
        val docs = r.getJSONObject("response").getJSONArray("items")
        val result = ArrayList<VKDocs>()

        for (i in 0 until docs.length())
            result.add(VKDocs.parse(docs.getJSONObject(i)))

        return result
    }
}
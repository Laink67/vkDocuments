package com.example.documentlist.model

import android.os.Parcel
import android.os.Parcelable
import org.json.JSONObject

data class VKDocs(
    val id: Int = 0,
    val title: String = "",
    val size: Int = 0,
    val ext: String = "",
    val date: Int = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeInt(size)
        parcel.writeString(ext)
        parcel.writeInt(date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<VKDocs> {
        override fun createFromParcel(parcel: Parcel): VKDocs {
            return VKDocs(parcel)
        }

        override fun newArray(size: Int): Array<VKDocs?> {
            return arrayOfNulls(size)
        }

        fun parse(json: JSONObject) = VKDocs(
            id = json.optInt("id", 0),
            title = json.optString("title", ""),
            size = json.optInt("size", 0),
            ext = json.optString("ext", ""),
            date = json.optInt("date", 0)
        )
    }
}
package com.midtrans.chatapp.model

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by farhan on 3/16/18.
 */
data class Chat(private val id: Int,
                private val sender: String,
                private val avatar: String,
                private val message: String,
                private val sent_at: String) : Parcelable {
    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(sender)
        writeString(avatar)
        writeString(message)
        writeString(sent_at)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Chat> = object : Parcelable.Creator<Chat> {
            override fun createFromParcel(source: Parcel): Chat = Chat(source)
            override fun newArray(size: Int): Array<Chat?> = arrayOfNulls(size)
        }
    }
}
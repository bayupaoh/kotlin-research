package me.bayupaoh.belajarkotlin.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.RealmObject


/**
 * Created by King Oil on 12/10/2017.
 */

open class Image : RealmObject(){
    @SerializedName("Photo")
    @Expose
    var photo: String? = null

    @SerializedName("Thumb")
    @Expose
    var thumb: String? = null


    @SerializedName("PhotoCaption")
    @Expose
    var photoCaption: String? = null
}
package com.ubaya.mvvm_160421134.util

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.widget.ImageView
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import com.ubaya.mvvm_160421134.R

fun createNotificationChannel(context: Context, importance: Int, showBadge:
Boolean, name: String, description: String) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val channelId = "${context.packageName}-$name"
        val channel = NotificationChannel(channelId, name, importance)
        channel.description = description
        channel.setShowBadge(showBadge)

        val notificationManager =
            context.getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }
}

@BindingAdapter("android:imageUrl")
fun loadPhotoURL(imageView: ImageView, url:String) {
    val picasso = Picasso.Builder(imageView.context)
    picasso.listener { picasso, uri, exception ->
        exception.printStackTrace()
    }
    picasso.build().load(url).into(imageView)
}



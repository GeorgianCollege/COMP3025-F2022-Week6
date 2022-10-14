package ca.georgiancollege.comp3025_f2022_week6

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val contactListString = getTextFromResource(this, R.raw.contacts)

        Log.i("contact_list", contactListString)
    }

    fun getTextFromResource(context: Context, resourceId: Int): String
    {
        return context.resources.openRawResource(resourceId)
            .bufferedReader()
            .use {it.readText()}
    }
}
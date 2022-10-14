package ca.georgiancollege.comp3025_f2022_week6

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactListRawString = getTextFromResource(this, R.raw.contacts)
        Log.i("contact_list_raw", contactListRawString)

        val contactListAssetString = getTextFromAssets(this, "contacts.json")
        Log.i("contact_list_assets", contactListAssetString)
    }

    fun getTextFromResource(context: Context, resourceId: Int): String
    {
        return context.resources.openRawResource(resourceId)
            .bufferedReader()
            .use {it.readText()}
    }

    fun getTextFromAssets(context: Context, fileName: String): String
    {
        return context.resources.assets.open(fileName)
            .bufferedReader()
            .use {it.readText()}
    }
}
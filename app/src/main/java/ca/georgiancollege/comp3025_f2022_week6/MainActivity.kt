package ca.georgiancollege.comp3025_f2022_week6

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contactList = deserializeJSON()

        if (contactList != null) {
            for(contact in contactList)
            {
                Log.i("listItem", contact.toString())
            }
        }
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

    fun deserializeJSON(): List<ContactModel>?
    {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        val listType = Types.newParameterizedType(List::class.java, ContactModel::class.java)
        val adapter: JsonAdapter<List<ContactModel>> = moshi.adapter(listType)
        val contactListRawString = getTextFromResource(this, R.raw.contacts)
        val contactList: List<ContactModel>? = adapter.fromJson(contactListRawString)
        //Log.i("contact_list_raw", contactList.toString())
        return contactList
    }
}
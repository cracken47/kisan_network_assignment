package com.karan.kisan_network.ui.fragment

import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karan.kisan_network.ui.adapter.ContactAdapter
import com.karan.kisan_network.R
import com.karan.kisan_network.model.Contact
import com.karan.kisan_network.model.JsonAttributes
import com.karan.kisan_network.ui.activity.ShowProfileActivity
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

/**
 * Fragment class that shows a list containing all contacts
 */
class ContactFragment : Fragment() {
    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null (which
     * is the default implementation).  This will be called between
     * [.onCreate] and [.onActivityCreated].
     *
     *
     *
     * If you return a View from here, you will later be called in
     * [.onDestroyView] when the view is being released.
     *
     * @param inflater           The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container          If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.
     */
    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_recycleview, container, false)
    }

    /**
     * Called immediately after [.onCreateView]
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     *
     * @param view               The View returned by [.onCreateView].
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     */
    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = view.findViewById<View>(R.id.recyclerView) as RecyclerView
        val linearLayout: LinearLayout =
            view.findViewById<View>(R.id.layout_no_data) as LinearLayout
        var contactList: List<Contact?>? = ArrayList<Contact?>()
        try {
            contactList = contactList1
        } catch (e: IOException) {
            Log.e(TAG, "setupRecyclerView: failed to read json file", e.fillInStackTrace())
        } catch (e: JSONException) {
            Log.e(TAG, "setupRecyclerView: failed to read json file", e.fillInStackTrace())
        }
        if (contactList != null) {
            linearLayout.setVisibility(View.GONE)
            setupRecyclerView(recyclerView, contactList)
        }
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, contactList: List<Contact?>) {
        val adapter = context?.let { ContactAdapter(it, contactList as List<Contact>) }
        adapter?.let { setOnclickListener(it, contactList) }
        val linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    private fun setOnclickListener(
        subjectAdapter: ContactAdapter,
        contactList: List<Contact?>
    ) {
        subjectAdapter.setOnItemClickListener(object : ContactAdapter.OnItemClickListener {
            override fun onClick(view: View?, position: Int) {
                val startIntent: Intent = ShowProfileActivity.getStartIntent(
                    getActivity(),
                    contactList[position]
                )
                startActivity(startIntent)
            }
        })
    }

    /**
     * reads contact json file
     * @return string containing [Contact] in json format
     * @throws IOException in case any exception occurs
     */
    @Throws(IOException::class)
    private fun readContactsFromResources(): String {
        val statesJson = StringBuilder()
        val resources: Resources = getResources()
        val rawStates = resources.openRawResource(R.raw.contact)
        val reader = BufferedReader(InputStreamReader(rawStates))
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            statesJson.append(line)
        }
        return statesJson.toString()
    }

    /**
     * reads from a jsonString and converts it into contact [Contact]
     * @return all contacts in json file
     * @throws IOException in case json file not presents etc.
     * @throws JSONException when json file related error occured
     */
    @get:Throws(IOException::class, JSONException::class)
    private val contactList1: List<Contact?>
        private get() {
            val jsonArray = JSONArray(readContactsFromResources())
            var contact: JSONObject
            val tmpContactList: ArrayList<Contact> = ArrayList<Contact>(jsonArray.length())
            for (i in 0 until jsonArray.length()) {
                contact = jsonArray.getJSONObject(i)
                val fullName: String = contact.getString(JsonAttributes.FULL_NAME)
                val countryCode: String = contact.getString(JsonAttributes.COUNTRY_CODE)
                val mobileNumber: String = contact.getString(JsonAttributes.MOBILE_NUMBER)
                tmpContactList.add(Contact(fullName, countryCode + mobileNumber))
            }
            return tmpContactList
        }

    companion object {
        private const val TAG = "ContactFragment"
        fun newInstance(): ContactFragment {
            return ContactFragment()
        }
    }
}
package com.karan.kisan_network.ui.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.karan.kisan_network.ui.fragment.ShowProfileFragment
import com.karan.kisan_network.R
import com.karan.kisan_network.model.Contact


/**
 * shows contact information
 */
class ShowProfileActivity : AppCompatActivity() {
 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        val contact: Contact = getIntent().getParcelableExtra(Contact.TAG)
        initToolbar()
        attachFragment(contact)
    }

    // Initialise and populates the toolbar
    private fun initToolbar() {
        supportActionBar?.title = "Profile"
    }

    /**
     * Attaches the view fragment
     * @param contact [Contact] you want to display in the view
     */
    private fun attachFragment(contact: Contact) {
        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction().replace(R.id.container, ShowProfileFragment.newInstance(contact))
            .commit()
    }

    companion object {
        /**
         * Use this public method to create instance of this class
         * @param context context in which this is running
         * @param contact [Contact] To which you want to  send message
         * @return Intent of the [ShowProfileActivity]
         */
        fun getStartIntent(context: Context?, contact: Contact?): Intent {
            val starter = Intent(context, ShowProfileActivity::class.java)
            starter.putExtra(Contact.TAG, contact)
            return starter
        }
    }
}
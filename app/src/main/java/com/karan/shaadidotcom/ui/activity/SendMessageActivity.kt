package com.karan.shaadidotcom.ui.activity


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.karan.shaadidotcom.ui.fragment.SendMessageFragment
import com.karan.shaadidotcom.R
import com.karan.shaadidotcom.model.Contact

/**
 * Creates send message activity
 */
class SendMessageActivity : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)
        val contact: Contact = intent.getParcelableExtra(Contact.TAG)
        initToolbar()
        attachFragment(contact)
    }

    /**
     * initialise and populate the toolbar
     */
    private fun initToolbar() {
        supportActionBar?.title = "Send Message"
    }

    /**
     * Attach the view fragment
     * @param contact [Contact] to which the message will be send
     */
    private fun attachFragment(contact: Contact) {
        val fm: FragmentManager = supportFragmentManager
        fm.beginTransaction().replace(R.id.container, SendMessageFragment.newInstance(contact))
            .commit()
    }

    companion object {
        /**
         * Use this public method to create instance of this class
         * @param context context in which this is running
         * @param contact [Contact] To which you want to  send message
         * @return Intent of the [SendMessageActivity]
         */
        fun getStartIntent(context: Context?, contact: Contact?): Intent {
            val starter = Intent(context, SendMessageActivity::class.java)
            starter.putExtra(Contact.TAG, contact)
            return starter
        }
    }
}
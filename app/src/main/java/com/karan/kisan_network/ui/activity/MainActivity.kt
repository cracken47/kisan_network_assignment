package com.karan.kisan_network.ui.activity


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.karan.kisan_network.R
import com.karan.kisan_network.ui.fragment.ContactFragment
import com.karan.kisan_network.ui.fragment.MessageFragment


class MainActivity :  AppCompatActivity()  {

 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar()
        initViewPagerAndTabs()
    }

    private fun initToolbar() {
        supportActionBar?.title = getString(R.string.app_name)
    }

    /**
     * initialise the viewpager and populates with the given fragments.
     */
    private fun initViewPagerAndTabs() {
        val viewPager = findViewById<View>(R.id.viewPager) as ViewPager
        val pagerAdapter = PagerAdapter(supportFragmentManager)
        val tabLayout = findViewById<View>(R.id.tabLayout) as TabLayout

        // shows list of contacts, populated from json file
        pagerAdapter.addFragment(ContactFragment.newInstance(), "Contact")
        // shows list of sent messages, populates from sqlite database
        pagerAdapter.addFragment(MessageFragment.newInstance(), "Message")
        viewPager.adapter = pagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        return if (id == R.id.action_setting) {
            // To-do create a setting activity and call it
            true
        } else super.onOptionsItemSelected(item)
    }


    /**
     * class used to populate fragments in viewpager extends FragmentPagerAdapter
     */
    private class PagerAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager) {
        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val fragmentTitleList: MutableList<String> = ArrayList()

        /**
         * Call to add new fragment in the view pager
         * @param fragment the fragment you want to add
         * @param title title of fragment
         */
        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            fragmentTitleList.add(title)
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return fragmentTitleList[position]
        }
    }

}

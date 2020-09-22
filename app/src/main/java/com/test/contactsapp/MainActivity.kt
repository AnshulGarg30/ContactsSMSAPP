package com.test.contactsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.*
import androidx.viewpager.widget.ViewPager
import com.example.vipulsublaniya.contactapp.F1
import com.test.contactsapp.Fragments.F2
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = SectionsPagerAdapter(getSupportFragmentManager())
        tab_layout.setupWithViewPager(pager)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm!!) {
        override fun getItemPosition(`object`: Any): Int {
            return super.getItemPosition(`object`)
            //            return POSITION_NONE;
        }

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            //Assign tab fragment view
            return when (position) {
                0 -> F1()
                1 -> F2()
                else -> F1()
            }
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            val l = Locale.getDefault()
            when (position) {
                0 -> return getString(R.string.title_section1)
                1 -> return getString(R.string.title_section2)
            }
            return null
        }
    }
}
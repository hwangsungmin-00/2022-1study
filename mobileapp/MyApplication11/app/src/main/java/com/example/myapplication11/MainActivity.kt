package com.example.myapplication11

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication11.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    class MyFragmentAdapter(activity:FragmentActivity) : FragmentStateAdapter(activity){
        val fragments: List<Fragment>
        init{
            fragments= listOf(Fragment1(), Fragment2(), Fragment3())
        }
        override fun getItemCount(): Int {
            //TODO("Not yet implemented")
            return fragments.size
        }

        override fun createFragment(position: Int): Fragment {
            //TODO("Not yet implemented")
            return fragments[position]
        }
    }
    val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    lateinit var toogle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        //val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        toogle= ActionBarDrawerToggle(this, binding.drawer, R.string.drawer_open, R.string.drawer_close)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toogle.syncState()

        //val fragmentManager : FragmentManager = supportFragmentManager
        //val transaction : FragmentTransaction = fragmentManager.beginTransaction()
        //val fragment = Fragment1()
        //transaction.add(R.id.fragment_content, fragment)
        //transaction.commit()
        binding.viewpager.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        binding.viewpager.adapter=MyFragmentAdapter(this)

        TabLayoutMediator(binding.tab1,binding.viewpager){
            tab, position->tab.text="TAB ${position+1}"
        }.attach()

        binding.mainDrawerView.setNavigationItemSelectedListener {
            Log.d("mobileApp", "Navigation selected... ${it.title}")
            true
        }
        binding.fab.setOnClickListener{
            when(binding.fab.isExtended){
                true->binding.fab.shrink()
                false->binding.fab.extend()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //val menuItem1: MenuItem? = menu?.add(0, 0, 0, "메뉴1")
        //val menuItem2: MenuItem? = menu?.add(0, 1, 0, "메뉴2")
        menuInflater.inflate(R.menu.menu_main, menu)
        val menuSearch=menu?.findItem(R.id.menu_search)
        val searchView=menuSearch?.actionView as SearchView
        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                //TODO("Not yet implemented")
                return true
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                //TODO("Not yet implemented")
                //binding.tv1.text=p0
                return true
            }
        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)) return true
        when(item.itemId){
            R.id.menu1->{
                //binding.tv1.setTextColor(Color.BLUE)
                true
            }
            R.id.menu2->{
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
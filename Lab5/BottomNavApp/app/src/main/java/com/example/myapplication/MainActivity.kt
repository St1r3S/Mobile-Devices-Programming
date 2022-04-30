package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            val fragment: Fragment
            when (it.itemId) {
                R.id.fox -> {
                    fragment = LysycyaFragment.newInstance()
                    setCurrentFragment(fragment)
                }
                R.id.tiger -> {
                    fragment = TygranFragment.newInstance()
                    setCurrentFragment(fragment)
                }
                R.id.wolf -> {
                    fragment = VovkFragment.newInstance()
                    setCurrentFragment(fragment)
                }
            }
            true
        }
        binding.bottomNavigationView.selectedItemId = R.id.fox
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, fragment)
        }
    }
}
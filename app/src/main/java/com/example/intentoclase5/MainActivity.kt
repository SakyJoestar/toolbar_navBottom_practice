package com.example.intentoclase5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import com.example.intentoclase5.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)
        setupToolbar()
        setupNavBot()
        setupButton()
    }

   private fun setupToolbar(){
       val toolbar = binding.contentToolbar.toolbar
//       setSupportActionBar(toolbar)
//       setupDrawer(toolbar)
       binding.contentToolbar.toolbar.setOnMenuItemClickListener { item ->
           when(item.itemId){
               R.id.action_share -> {
                   //Tarea a realizar
                   Snackbar.make(binding.root, "Compartir", Snackbar.LENGTH_SHORT).show()
                   true
               }
               else -> true
           }
       }
    }


    private fun setupNavBot() {
        val bottomNavigationView = binding.bottomNavigationView

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btn1 -> {
                    true
                }

                else -> {
                    Snackbar.make(binding.root, "Próximamente", Snackbar.LENGTH_SHORT).show()
                    bottomNavigationView.selectedItemId = R.id.btn1
                    false
                }
            }
        }
    }

    private fun setupButton(){
        binding.imageButton.setOnClickListener {
            Snackbar.make(binding.root, "Agregar tarjeta", Snackbar.LENGTH_SHORT).show()
        }
    }
}
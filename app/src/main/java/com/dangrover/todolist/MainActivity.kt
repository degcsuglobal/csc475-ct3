package com.dangrover.todolist

import android.app.AlertDialog
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.dangrover.todolist.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        var todoListFragment : TodoListFragment? = supportFragmentManager.findFragmentById(R.id.todo_fragment_container) as TodoListFragment?

        /*
        val navController = findNavController(R.id.main_activity_coordinator_layout)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        */


        // add button action
        binding.addbutton.setOnClickListener {
            todoListFragment?.showAddTodoDialog()
        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*
    private fun showAddTodoDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Add Todo")
        val input : View = EditText(requireContext())
        builder.setView(input)

        builder.setPositiveButton("Create") { _, _ ->
            val todo = Todo(
                itemName = input.text.toString(),
                completed = false
            )

            val todoDao = (db as TodoDatabase).todoDao()
            todoDao.insertAll(todo)
            //  binding.todorecycler.adapter?.notifyDataSetChanged()
        }

        builder.show()
    }
     */

}
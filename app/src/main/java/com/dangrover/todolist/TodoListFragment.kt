package com.dangrover.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.*
import com.dangrover.todolist.databinding.FragmentTodoListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TodoListFragment : Fragment() {

    private var _binding: FragmentTodoListBinding? = null

    private lateinit var db : RoomDatabase
    private lateinit var todos : List<Todo>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root


    }

    // helper function to refresh the todo list
    private fun refreshTodoList() {
        val todoDao = (db as TodoDatabase).todoDao()
        todos = todoDao.getAll()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // load database
        db = Room.databaseBuilder(
            requireContext(),
            TodoDatabase::class.java, "todo-list"
        ).allowMainThreadQueries() // TODO turn this off and refactor code to use BG threads
            .build()

        refreshTodoList()

        val recyclerView: RecyclerView = view.findViewById(R.id.todorecycler)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = TodoListAdapter(todos)

        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
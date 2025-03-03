package com.dangrover.todolist
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class TodoListAdapter(private var dataSet: List<Todo>, private val fragment: TodoListFragment) :
    RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {

    fun setData(newDataSet: List<Todo>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }

    // Provide a reference to the views for each data item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val checkbox: CheckBox
        val deleteButton: Button

        init {
            checkbox = view.findViewById(R.id.checkbox) as CheckBox
            deleteButton = view.findViewById(R.id.deletebutton)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.todo_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.checkbox.setText(dataSet[position].itemName) // Title
        viewHolder.checkbox.setChecked(dataSet[position].completed == true) // Status

        // set up click listeners for each button
        viewHolder.deleteButton.setOnClickListener {
            fragment.deleteTodo(dataSet[position])
        }

        viewHolder.checkbox.setOnCheckedChangeListener { _, isChecked ->
            fragment.updateTodoChecked(dataSet[position], isChecked)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
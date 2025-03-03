package com.dangrover.todolist
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class TodoListAdapter(private var dataSet: List<Todo>) :
    RecyclerView.Adapter<TodoListAdapter.ViewHolder>() {


    fun setData(newDataSet: List<Todo>) {
        dataSet = newDataSet
        notifyDataSetChanged()
    }

    // Provide a reference to the views for each data item
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val statusButton: Button

        init {
            textView = view.findViewById(R.id.textView)
            statusButton = view.findViewById(R.id.item_status_button)
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

        // Title
        viewHolder.textView.text = dataSet[position].itemName
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
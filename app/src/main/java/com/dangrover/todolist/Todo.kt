package com.dangrover.todolist
import androidx.room.*
import java.util.Date

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true) val todoId: Int? = null,
    @ColumnInfo(name = "item_name") val itemName: String?,
    @ColumnInfo(name = "completed") val completed: Boolean?
)
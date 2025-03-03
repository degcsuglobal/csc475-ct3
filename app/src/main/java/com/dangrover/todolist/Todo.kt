package com.dangrover.todolist
import androidx.room.*
import java.util.Date

@Entity
data class Todo(
    @PrimaryKey val todoId: Int,
    @ColumnInfo(name = "item_name") val itemName: String?,
    @ColumnInfo(name = "completed") val completed: Boolean?
)
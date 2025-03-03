package com.dangrover.todolist
import androidx.room.*

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): List<Todo>

    @Insert
    fun insertAll(vararg todos: Todo)

    @Delete
    fun deleteTodos(vararg todos: Todo)
}
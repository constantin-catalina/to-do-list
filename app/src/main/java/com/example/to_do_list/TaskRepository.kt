package com.example.to_do_list

import androidx.lifecycle.LiveData
import com.example.to_do_list.data.Task
import com.example.to_do_list.data.TaskDao

class TaskRepository(private val taskDao: TaskDao) {

    fun getAllTasks(): LiveData<List<Task>> = taskDao.getAllTasks()

    suspend fun insert(task: Task) = taskDao.insert(task)

    suspend fun delete(task: Task) = taskDao.delete(task)

    suspend fun update(task: Task) = taskDao.update(task)
}

package com.example.to_do_list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.to_do_list.data.Task
import com.example.to_do_list.data.TaskDatabase
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TaskRepository
    val tasks: LiveData<List<Task>>

    init {
        val dao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(dao)
        tasks = repository.getAllTasks()
    }

    fun addTask(name: String) = viewModelScope.launch {
        repository.insert(Task(name = name))
    }

    fun deleteTask(task: Task) = viewModelScope.launch {
        repository.delete(task)
    }

    fun updateTask(task: Task, updatedName: String) = viewModelScope.launch {
        repository.update(task.copy(name = updatedName))
    }

    fun toggleTaskChecked(task: Task) = viewModelScope.launch {
        val updated = task.copy(checked = !task.checked)
        repository.update(updated)
    }
}

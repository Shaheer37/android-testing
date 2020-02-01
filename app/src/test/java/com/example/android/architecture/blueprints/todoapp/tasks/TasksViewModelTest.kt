package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.TodoApplication
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest{
    @get:Rule val instantExecutorRule = InstantTaskExecutorRule()

    lateinit var tasksViewModel: TasksViewModel

    @Before
    fun setupViewModel(){
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext() as TodoApplication)
    }

    @Test
    fun addNewTask_setsNewTaskEvent(){
        val tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext() as TodoApplication)
        tasksViewModel.addNewTask()
        val value = tasksViewModel.newTaskEvent.getOrAwaitValue()
        assertThat(value.getContentIfNotHandled(), (not(nullValue())))
    }

    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {

        // Given a fresh ViewModel


        // When the filter type is ALL_TASKS
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)


        // Then the "Add task" action is visible
        val value = tasksViewModel.tasksAddViewVisible.getOrAwaitValue()
        assertThat(value, (`is`(true)))

    }
}
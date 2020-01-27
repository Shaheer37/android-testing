package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`

import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {
    @Test
    fun getActiveAndCompletedStats_noCompleted_returnsHundredZero(){

        //given
        val tasks = listOf<Task>(
            Task("title", "desc", isCompleted = false)
        )

        //when
        val result = getActiveAndCompletedStats(tasks)

        //then
        assertThat(result.activeTasksPercent, `is`(100f))
        assertThat(result.completedTasksPercent, `is`(0f))

    }

    @Test
    fun getActiveAndCompletedStats_noActive_returnsHundredZero(){

        //given
        val tasks = listOf<Task>(
                Task("title", "desc", isCompleted = true)
        )

        //when
        val result = getActiveAndCompletedStats(tasks)

        //then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(100f))

    }

    @Test
    fun getActiveAndCompletedStats_both_returnsFortySixty(){

        //given
        val tasks = listOf<Task>(
                Task("title1", "desc", isCompleted = true),
                Task("title2", "desc", isCompleted = true),
                Task("title3", "desc", isCompleted = false),
                Task("title4", "desc", isCompleted = false),
                Task("title5", "desc", isCompleted = false)
        )

        //when
        val result = getActiveAndCompletedStats(tasks)

        //then
        assertThat(result.activeTasksPercent, `is`(60f))
        assertThat(result.completedTasksPercent, `is`(40f))
    }

    @Test
    fun getActiveAndCompletedStats_empty_returnsZero(){

        //given
        val tasks = emptyList<Task>()

        //when
        val result = getActiveAndCompletedStats(tasks)

        //then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }

    @Test
    fun getActiveAndCompletedStats_null_returnsZero(){

        //given
        val tasks = null

        //when
        val result = getActiveAndCompletedStats(tasks)

        //then
        assertThat(result.activeTasksPercent, `is`(0f))
        assertThat(result.completedTasksPercent, `is`(0f))
    }
}
package com.example.android.architecture.blueprints.todoapp.statistics

import com.example.android.architecture.blueprints.todoapp.data.Task
import org.hamcrest.CoreMatchers.`is`

import org.junit.Assert.*
import org.junit.Test

class StatisticsUtilsTest {
    @Test
    fun getActiveAndeCompletedStats_noCompleted_returnsHundredZero(){

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
}
package com.otw.android.estadojetpackcompose.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

fun getWellnessTasks() = List(30) {
    WellnessTask(it,"Task # $it")
}

@Composable
fun  WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember {
        getWellnessTasks()
    },
    onCloseTask: (WellnessTask) -> Unit

) {
    LazyColumn(modifier = modifier ) {     
        items(list, key = {task -> task.id}) {task ->
         WellnessTaskItem(taskName = task.label, onClose = {onCloseTask(task)})
        }
    }
}

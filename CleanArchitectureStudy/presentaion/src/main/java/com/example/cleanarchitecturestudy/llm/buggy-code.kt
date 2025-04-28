package com.example.cleanarchitecturestudy.llm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * 버그 코드 : 25.04.28 기준 테스트 중 입니다.
 *
 * 강제로 버그를 만들어 해결하는 케이스를 확인하기 위한 코드입니다.
 * 해당 코드 사용 시, 주석을 풀고 테스트 해야합니다.
 */

/*
// 버그 1: 데이터 클래스에 val/var 누락
data class Todo(
    id: Int,
    text: String,
    completed: Boolean
)

// 버그 2: completed 속성 타입 불일치
val initialTodos = listOf(
    Todo(1, "Kotlin 공부하기", completed = "false"),
    Todo(2, "Jetpack Compose 공부하기", completed = false)
)

// 버그 3: StateFlow 초기화 방식 오류
class TodoViewModel : ViewModel() {
    // 버그 4: 초기값 설정 오류
    private val _todos = MutableStateFlow<List<Todo>>()
    val todos: StateFlow<List<Todo>> = _todos.asStateFlow()

    private val _filter = MutableStateFlow("all")
    val filter: StateFlow<String> = _filter.asStateFlow()

    // 버그 5: 불변성 원칙 위반
    fun addTodo(text: String) {
        if (text.isBlank()) return

        // 버그 6: 중복 ID 할당 가능성
        val newId = (Math.random() * 1000).toInt()
        val newTodo = Todo(newId, text, false)

        // 불변성 원칙 위반
        val currentList = _todos.value.toMutableList()
        currentList.add(newTodo)
        _todos.value = currentList
    }

    // 버그 7: 잘못된 필터 로직
    val filteredTodos: List<Todo>
        get() {
            return when (filter.value) {
                "active" -> _todos.value.filter { it.completed }
                "completed" -> _todos.value.filter { !it.completed }
                else -> _todos.value
            }
        }

    // 버그 8: 논리 오류 (토글 기능 반대로 작동)
    fun toggleTodo(id: Int) {
        val newList = _todos.value.map { todo ->
            if (todo.id == id) {
                todo.copy(completed = !todo.completed)
            } else {
                todo
            }
        }
        _todos.value = newList
    }

    // 버그 9: 함수 정의 누락
    fun deleteTodo(id: Int) {
        // 구현 누락
    }

    fun setFilter(filterType: String) {
        _filter.value = filterType
    }
}

@Composable
fun TodoApp(viewModel: TodoViewModel) {
    val todos by viewModel.todos.collectAsState()
    val filter by viewModel.filter.collectAsState()
    var newTodoText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Todo 앱",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 버그 10: 이벤트 핸들러 잘못 연결
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = newTodoText,
                onValueChange = { newTodoText },
                modifier = Modifier.weight(1f),
                placeholder = { Text("할 일 입력") }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = {
                    viewModel.addTodo(newTodoText)
                    newTodoText = ""
                }
            ) {
                Text("추가")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { viewModel.setFilter("all") }) {
                Text("모두")
            }
            Button(onClick = { viewModel.setFilter("active") }) {
                Text("활성")
            }
            Button(onClick = { viewModel.setFilter("completed") }) {
                Text("완료")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 버그 11: filteredTodos가 flow가 아니라 직접 호출하는 방식으로 잘못 구현됨
        LazyColumn {
            items(viewModel.filteredTodos) { todo ->
                TodoItem(
                    todo = todo,
                    onToggle = { viewModel.toggleTodo(todo.id) },
                    // 버그 12: 삭제 함수 연결 안됨
                    onDelete = { }
                )
            }
        }
    }
}

@Composable
fun TodoItem(
    todo: Todo,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = todo.completed,
            onCheckedChange = { onToggle() }
        )

        Text(
            text = todo.text,
            modifier = Modifier.weight(1f),
            style = if (todo.completed) {
                MaterialTheme.typography.bodyLarge.copy(
                    textDecoration = TextDecoration.LineThrough
                )
            } else {
                MaterialTheme.typography.bodyLarge
            }
        )

        Button(onClick = onDelete) {
            Text("삭제")
        }
    }
}
*/
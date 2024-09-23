package com.cmps312.todolistapp.repository

import android.util.Log
import com.cmps312.todolistapp.model.Project
import com.cmps312.todolistapp.model.Todo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class TodoRepository {

    // Create the firebase Database

    val db : FirebaseFirestore by lazy {FirebaseFirestore.getInstance()}
    // a reference to the collections
    val projectCollectionRef by lazy {db.collection("projects")}
    val todoCollectionRef by lazy {db.collection("todos") }



    fun observeProjects(): Flow<List<Project>> = callbackFlow {
        val snapshot = projectCollectionRef.addSnapshotListener{value , err ->
            if(err != null){
                return@addSnapshotListener
            }
            if(value != null) {
                val projects = value!!.toObjects(Project::class.java)
                this.trySend(projects)
            }
        }
        awaitClose{snapshot.remove()}
    }

    fun addProject(project: Project) = projectCollectionRef.add(project)

    fun updateProject(project: Project) = projectCollectionRef.document(project.id).set(project)

    suspend fun deleteProject(project: Project) {
       val todos = getTodoListByProject(project.id)
        todos.forEach {
            deleteTodo(it)
        }
        projectCollectionRef.document(project.id).delete()



    }

    fun observeTodos(pid: String): Flow<List<Todo>> = callbackFlow {
        val snapshot = todoCollectionRef
            .whereEqualTo("pid",pid)
            .addSnapshotListener { value, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            if (value != null) {
                val todos = value.toObjects(Todo::class.java)
                this.trySend(todos)
            }
        }
        awaitClose { snapshot.remove() }
    }

    suspend fun getTodo(id: String) = todoCollectionRef.document(id).get().await().toObject(Todo::class.java)

    suspend fun addTodo(todo: Todo) = todoCollectionRef.add(todo)


    fun updateTodo(todo: Todo) = todoCollectionRef.document(todo.id).set(todo)

    suspend fun deleteTodo(todo: Todo) = todoCollectionRef.document(todo.id).delete()

    suspend fun getTodoListByProject(pid: String) = todoCollectionRef.whereEqualTo("pid", pid).get().await().toObjects(Todo::class.java)
}
package com.pkissling.kotlin.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Instead of calling `Deferred.await()` on each object immediately after delegating the invocation of the method to  `async { ... }`,
// this implementation delegates the computation to `async { ... }`, collects the `Deferred` objects and calls await on all objects at the same time.
//
// Overall invocation takes ~500ms, yet still running on the same threads.
fun part7() = runBlocking { // this: CoroutineScope

    println("runBlocking { ... } running on thread: ${Thread.currentThread().name}") // 'main'

    val deferred1 = async {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'
        expensiveComputation(10)
    }

    val deferred2 = async {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'
        expensiveComputation(20)
    }

    val deferred3 = async {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'
        expensiveComputation(30)
    }

    println("sum = ${deferred1.await() + deferred2.await() + deferred3.await()}")
}

private suspend fun expensiveComputation(i: Int): Int {
    delay(500) // instead of Thread.sleep(500)
    return i * 10
}








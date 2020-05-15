package com.pkissling.kotlin.coroutines

import kotlinx.coroutines.*

// Using `withContext(...)` allows us to using different Thread pools to perform our computation.
// Now we have reached the end result: Computations are performed in parallel and differents Threads are being used.
//
// Overall invocation takes ~500ms.
fun part8() = runBlocking { // this: CoroutineScope

    println("runBlocking { ... } running on thread: ${Thread.currentThread().name}") // 'main'

    val deferred1 = withContext(Dispatchers.Default) {
        async {
            println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'DefaultDispatcher-worker-1'
            expensiveComputation(10)
        }
    }

    val deferred2 = withContext(Dispatchers.Default) {
        async {
            println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'DefaultDispatcher-worker-1'
            expensiveComputation(10)
        }
    }

    val deferred3 = withContext(Dispatchers.Default) {
        async {
            println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'DefaultDispatcher-worker-1'
            expensiveComputation(10)
        }
    }

    println("sum = ${deferred1.await() + deferred2.await() + deferred3.await()}")
}

private suspend fun expensiveComputation(i: Int): Int {
    delay(500) // instead of Thread.sleep(500)
    return i * 10
}








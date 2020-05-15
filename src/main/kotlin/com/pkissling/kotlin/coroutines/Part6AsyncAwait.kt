package com.pkissling.kotlin.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Using async { ... } allows us the return objects from Coroutines.
// Yet, instead of the values we now get a `deferred` object, which allows us the call `Deferred.await()` to retrieve the value from it.
// Computation is still done sequentially. This is because `Deferred.await()` is a blocking function, making the thread wait until the value was returned.
//
// The method still runs for ~1500ms.
fun part6() = runBlocking { // this: CoroutineScope

    println("runBlocking { ... } running on thread: ${Thread.currentThread().name}") // 'main'

    val deferred1 = async {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'
        expensiveComputation(10)
    }
    val result1 = deferred1.await()

    val deferred2 = async {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'
        expensiveComputation(20)
    }
    val result2 = deferred2.await()

    val deferred3 = async {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'
        expensiveComputation(30)
    }
    val result3 = deferred3.await()

    println("sum = ${result1 + result2 + result3}")
}

private suspend fun expensiveComputation(i: Int): Int {
    delay(500) // instead of Thread.sleep(500)
    return i * 10
}








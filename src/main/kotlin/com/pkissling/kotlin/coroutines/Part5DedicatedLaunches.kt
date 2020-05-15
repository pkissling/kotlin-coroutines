package com.pkissling.kotlin.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


// Although we now launch 3 different Coroutines, computation is still done sequentially.
// This is because the function `expensiveComputation(...)` is still blocking the thread.
// Using the keyword `suspend` we convert the (implicit) blocking function into a suspending function.
// Our coroutines are still running on the 'main' Thread. But the computation is now done in parallel.
//
// On problem though still remains: We are not able to return objects from the `launch { ... }`
//
// Overall invocation takes ~500ms.
fun part5() = runBlocking { // this: CoroutineScope

    println("runBlocking { ... } running on thread: ${Thread.currentThread().name}") // 'main'

    launch {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'

        val result1 = expensiveComputation(10)
        println("result1 = $result1")

        // 'return is now allowed here'
        // return result1
    }

    launch {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'

        val result2 = expensiveComputation(20)
        println("result2 = $result2")
    }

    launch {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'

        val result3 = expensiveComputation(30)
        println("result3 = $result3")
    }

    // Summing does not work, because we are not able to return an object from the launch { ... } block
    // println("sum = ${result1 + result2 + result3}")
}

private suspend fun expensiveComputation(i: Int): Int {
    delay(500) // instead of Thread.sleep(500)
    return i * 10
}








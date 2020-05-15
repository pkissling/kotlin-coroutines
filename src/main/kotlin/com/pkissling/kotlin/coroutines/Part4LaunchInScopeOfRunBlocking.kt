package com.pkissling.kotlin.coroutines

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


// Using runBlocking { .. } we are now able to launch coroutines within the scope of the `runBlocking` block.
// This means we do not rely on the `GlobalScope` anymore.
// Although the computation is running on a different thread, it's still done sequentially.
//
// Overall invocation takes ~1500ms.
fun part4() = runBlocking { // this: CoroutineScope

    println("runBlocking { ... } running on thread: ${Thread.currentThread().name}") // 'main'

    launch {
        println("launch { ... } running on thread: ${Thread.currentThread().name}") // 'main'
        val result1 = expensiveComputation(10)
        val result2 = expensiveComputation(20)
        val result3 = expensiveComputation(30)

        println("sum = ${result1 + result2 + result3}")
    }
}

private fun expensiveComputation(i: Int): Int {
    Thread.sleep(500)
    return i * 10
}








package com.pkissling.kotlin.coroutines

import kotlinx.coroutines.runBlocking


// Now the main thread will wait until the coroutine has concluded.
// Though the coroutine is still running on the main thread and computation is done sequentially.
//
// Overall invocation takes ~1500ms.
fun part3() = runBlocking { // this: CoroutineScope

    println("Running on thread: ${Thread.currentThread().name}") // 'main'

    val result1 = expensiveComputation(10)
    val result2 = expensiveComputation(20)
    val result3 = expensiveComputation(30)

    println("sum = ${result1 + result2 + result3}")

    // not needed anymore
    // Thread.sleep(2000)
}

private fun expensiveComputation(i: Int): Int {
    Thread.sleep(500)
    return i * 10
}








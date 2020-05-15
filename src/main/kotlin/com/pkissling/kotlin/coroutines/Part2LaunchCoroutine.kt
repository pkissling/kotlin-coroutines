package com.pkissling.kotlin.coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


// Computation is now running in a coroutine (in GlobalScope) on a different thread.
// Yet computations are still done sequentially.
// Furthermore we have to keep the process alive with `Thread.sleep(...)` otherwise the thread would quit directly after launching the Coroutine.
//
// Overall invocation takes ~1500ms.
fun part2() {
    println("Running on thread: ${Thread.currentThread().name}") // 'main'

    // launches a new coroutine
    GlobalScope.launch {

        println("Running on thread: ${Thread.currentThread().name}") // 'DefaultDispatcher-worker-1'

        val result1 = expensiveComputation(10)
        val result2 = expensiveComputation(20)
        val result3 = expensiveComputation(30)
        println("sum = ${result1 + result2 + result3}")

    }

    Thread.sleep(2000) // we have to keep the main Thread alive
}


private fun expensiveComputation(i: Int): Int {
    Thread.sleep(500)
    return i * 10
}








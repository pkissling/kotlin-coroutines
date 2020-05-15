package com.pkissling.kotlin.coroutines


// Calculations are performed sequentially. Each calculation takes around 500ms.
// The invocation of the method concludes after all subsequent methods have been invoked.
//
// Overall invocation takes ~1500ms.
fun part1() {
    println("Running on thread: ${Thread.currentThread().name}")

    val result1 = expensiveComputation(1)
    val result2 = expensiveComputation(2)
    val result3 = expensiveComputation(3)

    println("sum = ${result1 + result2 + result3}")
}

private fun expensiveComputation(i: Int): Int {
    Thread.sleep(500)
    return i * 10
}



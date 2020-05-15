package com.pkissling.kotlin.coroutines


fun main() {
    measureInvocation("part1") {
        part1()
    }

    measureInvocation("part2") {
        part2()
    }

    measureInvocation("part3") {
        part3()
    }

    measureInvocation("part4") {
        part4()
    }

    measureInvocation("part5") {
        part5()
    }

    measureInvocation("part6") {
        part6()
    }

    measureInvocation("part7") {
        part7()
    }

    measureInvocation("part8") {
        part8()
    }
}

fun <T> measureInvocation(name: String, function: () -> T) : T {
    val before = System.currentTimeMillis()
    println("[START][$name]")

    return function.invoke().also {
        println("[END  ][$name] Took ${System.currentTimeMillis() - before} ms\n")
    }

}


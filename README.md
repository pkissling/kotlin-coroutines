# Purpose
A Kotlin project I created in order to understand the concept of [Kotlin's Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html).

# Goal
Transforming a project from traditional blocking and sequential method calls to a suspending implementation embracing Coroutines and being able to delegate invocation of different methods into dedicated Threads. 
More precisely, the tangible goals were to understand:
- How to `launch` a Coroutine
- How to make a function `suspending`
- The difference between `launch { ... }` and `async { ... }`
- How to leverage different `Threads` and even corresponding `Thread Pools`
- How to switch between `blocking` and `suspending` contexts

# Run
```$bash
$ ./gradlew run
```
plugins {
    kotlin("jvm") version "1.3.71"

    application
}


repositories {
    jcenter()
}

dependencies {
    // bom
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // implementation
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.6")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
}

application {
    // Define the main class for the application.
    mainClassName = "com.pkissling.kotlin.coroutines.AllKt"
}

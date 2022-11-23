import gradle.kotlin.dsl.accessors._e115dd7072ba4d98136045faa736bf3c.jacocoTestReport
import gradle.kotlin.dsl.accessors._e115dd7072ba4d98136045faa736bf3c.jar
import gradle.kotlin.dsl.accessors._e115dd7072ba4d98136045faa736bf3c.test
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.jacoco
import org.gradle.kotlin.dsl.java
import org.gradle.kotlin.dsl.repositories

plugins {
    java
    jacoco
}

repositories {
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestReport)
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)
    reports {
        xml.required.set(false)
        csv.required.set(false)
    }
}

tasks.jar {
    enabled = false
}
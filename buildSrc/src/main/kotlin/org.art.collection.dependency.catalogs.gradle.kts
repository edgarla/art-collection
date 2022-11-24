import org.gradle.kotlin.dsl.invoke

plugins {
    pmd
    java
    jacoco
    checkstyle
    `jvm-test-suite`
}

repositories {
    mavenCentral()
}

testing {
    suites {
        val test by getting(JvmTestSuite::class) {
            useJUnitJupiter()
            dependencies {
                implementation("org.springframework.boot:spring-boot-starter-test:2.7.5")
            }
        }
    }
}

tasks {
    withType<JavaCompile>().configureEach {
        javaCompiler.set(javaToolchains.compilerFor {
            languageVersion.set(JavaLanguageVersion.of(17))
        })
    }

    named<Test>("test") {
        finalizedBy(tasks.jacocoTestReport)
    }

    withType<Pmd>().configureEach {
        ruleSets = listOf("category/java/errorprone.xml",
            "category/java/bestpractices.xml")
    }

    named<JacocoReport>("jacocoTestReport") {
        dependsOn(tasks.test)
        reports {
            xml.required.set(true)
            csv.required.set(false)
        }
    }

    named<JacocoCoverageVerification>("jacocoTestCoverageVerification") {
        violationRules {
            rule {
                limit {
                    minimum = BigDecimal.valueOf(70)
                }
            }
        }
    }

    withType<Checkstyle>().configureEach {
        version = "10.3.2"
        ignoreFailures = false
        reports {
            xml.required.set(true)
            html.required.set(true)
        }
    }

    named("jar") {
        enabled = true
    }
}
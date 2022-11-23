import org.gradle.kotlin.dsl.libs

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once https://github.com/gradle/gradle/issues/22797 is fixed
plugins {
    id("org.art.collection.dependency.catalogs")
    alias(libs.plugins.spring.boot)
}

group = "org.art.collection"
version = "1.0"

dependencies {
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.spring.boot.starter.actuator)

    annotationProcessor(libs.spring.boot.configuration.processor)
    annotationProcessor(libs.lombok)
    compileOnly(libs.lombok)

    testImplementation(libs.spring.boot.starter.test)
}
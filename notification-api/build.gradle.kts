plugins {
    val kotlinVersion = "1.4.10"
    val springBootVersion = "2.3.5.RELEASE"
    val springBootManagementVersion = "1.0.10.RELEASE"
    val googleJibVersion = "2.6.0"

    kotlin("plugin.spring") version kotlinVersion
    kotlin("plugin.jpa") version kotlinVersion
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version springBootManagementVersion
    id("com.google.cloud.tools.jib") version googleJibVersion
}

dependencies {
    implementation(project(":notification-common"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    runtimeOnly("com.h2database:h2")
}

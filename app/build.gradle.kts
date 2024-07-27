plugins {
    id("java")
    application
    kotlin("jvm")
    checkstyle
}

group = "hexlet-code"
version = "1.0"

repositories {
    mavenCentral()
}

application {
    mainClass.set("hexlet.code.App")
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "hexlet.code.App"
    }
}
kotlin {
    jvmToolchain(21)
}

tasks.getByName("run", JavaExec::class) {
    standardInput = System.`in`
}
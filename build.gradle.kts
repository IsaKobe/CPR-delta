plugins {
    id("java")
}

group = "cz.richard"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.google.code.gson:gson:2.13.2")
    implementation("com.thoughtworks.xstream:xstream:1.4.21")
    implementation("com.google.inject:guice:7.0.0")
    implementation("com.cronutils:cron-utils:9.2.1")
    implementation("org.quartz-scheduler:quartz:2.5.1")
}

tasks.test {
    useJUnitPlatform()
}
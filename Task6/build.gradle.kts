plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.testng:testng:6.14.3")
    //testImplementation(platform("org.junit:junit-bom:5.10.0"))
    //testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mockito:mockito-core:5.12.0")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.22.0")
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-chrome-driver
    implementation ("org.seleniumhq.selenium:selenium-chrome-driver:4.22.0")

}

tasks.test {
    //useJUnitPlatform()
    useTestNG()

}
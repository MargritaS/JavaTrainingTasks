plugins {
    id("java")
}
// Define the version of AspectJ
val aspectJVersion = "1.9.20.1"
// Define configuration for AspectJ agent
val agent: Configuration by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = true
}
// Define the version of Allure you want to use via the allureVersion property
val allureVersion = "2.24.0"


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
    // https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    implementation ("io.qameta.allure:allure-testng:2.29.0")
    // Import allure-bom to ensure correct versions of all the dependencies are used
    implementation ( platform("io.qameta.allure:allure-bom:$allureVersion"))
    // Add necessary Allure dependencies to dependencies section
    implementation ( "io.qameta.allure:allure-testng")
    // Add aspectjweaver dependency
    agent("org.aspectj:aspectjweaver:${aspectJVersion}")
}

tasks.test {
    //useJUnitPlatform()
    useTestNG()
    jvmArgs = listOf(
        "-javaagent:${agent.singleFile}"
    )
}






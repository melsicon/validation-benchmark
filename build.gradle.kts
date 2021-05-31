plugins {
  application
  id("com.github.ben-manes.versions") version "0.39.0"
  id("se.patrikerdes.use-latest-versions") version "0.2.17"
}

buildDir = file("gradle-build")

sourceSets {
  map {
    it.java {
      exclude("de/melsicon/example/validation/jee9/**")
    }
  }
}

tasks.withType<JavaCompile> {
  options.release.set(11)
}

application {
  mainClass.set("org.openjdk.jmh.Main")
  applicationDefaultJvmArgs = listOf(
    "-Djava.util.logging.config.file=conf/logging.properties",
    "-XX:+CrashOnOutOfMemoryError",
  )
}

repositories {
  google()
  mavenCentral()
}

dependencies {
  compileOnly("org.projectlombok:lombok:1.18.20")
  annotationProcessor("org.projectlombok:lombok:1.18.20")

  compileOnly("org.immutables:value-annotations:2.9.0-beta2")
  annotationProcessor("org.immutables:value-processor:2.9.0-beta2")

  implementation("org.openjdk.jmh:jmh-core:1.32")
  annotationProcessor("org.openjdk.jmh:jmh-generator-annprocess:1.32")

  compileOnly("org.checkerframework:checker-qual:3.13.0")
  testCompileOnly("org.checkerframework:checker-qual:3.13.0")

  implementation("com.google.guava:guava:30.1.1-jre")
  implementation("jakarta.validation:jakarta.validation-api:2.0.2")
  runtimeOnly("org.glassfish:jakarta.el:3.0.3")
  runtimeOnly("org.hibernate.validator:hibernate-validator:6.2.0.Final")
  runtimeOnly("org.ow2.asm:asm:9.1")

  testImplementation("junit:junit:4.13.2")
  testImplementation("com.google.truth:truth:1.1.3")
  testImplementation("com.google.truth.extensions:truth-java8-extension:1.1.3")
}

tasks.useLatestVersions {
  updateBlacklist = listOf(
    "jakarta.validation:jakarta.validation-api",
    "org.glassfish:jakarta.el",
    "org.hibernate.validator:hibernate-validator",
  )
}
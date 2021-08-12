workspace(name = "de_melsicon_validation_benchmark")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# ---

http_archive(
    name = "rules_jvm_external",
    sha256 = "995ea6b5f41e14e1a17088b727dcff342b2c6534104e73d6f06f1ae0422c2308",
    strip_prefix = "rules_jvm_external-4.1",
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/4.1.tar.gz",
)

load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:specs.bzl", "maven")

# ---

maven_install(
    artifacts = [
        "com.google.errorprone:error_prone_annotations:2.8.1",
        "com.google.guava:guava:30.1.1-jre",
        "jakarta.validation:jakarta.validation-api:2.0.2",
        "org.checkerframework:checker-qual:3.17.0",
        "org.checkerframework:checker-util:3.17.0",
        "org.checkerframework:checker:3.17.0",
        "org.glassfish:jakarta.el:3.0.3",
        "org.hibernate.validator:hibernate-validator:6.2.0.Final",
        "org.immutables:value-annotations:2.9.0-beta3",
        "org.immutables:value-processor:2.9.0-beta3",
        "org.openjdk.jmh:jmh-core:1.33",
        "org.openjdk.jmh:jmh-generator-annprocess:1.33",
        "org.ow2.asm:asm:9.2",
        "org.projectlombok:lombok:1.18.20",
        maven.artifact(
            "com.google.truth",
            "truth",
            "1.1.3",
            testonly = True,
        ),
        maven.artifact(
            "com.google.truth.extensions",
            "truth-java8-extension",
            "1.1.3",
            testonly = True,
        ),
        maven.artifact(
            "junit",
            "junit",
            "4.13.2",
            testonly = True,
        ),
    ],
    fetch_sources = True,
    maven_install_json = "@de_melsicon_validation_benchmark//:maven_install.json",
    repositories = [
        "https://maven-central-eu.storage-download.googleapis.com/maven2",
        "https://repo1.maven.org/maven2",
    ],
)

load("@maven//:defs.bzl", "pinned_maven_install")

pinned_maven_install()

# ---

maven_install(
    name = "jee9",
    artifacts = [
        "jakarta.validation:jakarta.validation-api:3.0.0",
        "org.glassfish:jakarta.el:4.0.1",
        "org.hibernate.validator:hibernate-validator:7.0.1.Final",
    ],
    fetch_sources = True,
    maven_install_json = "@de_melsicon_validation_benchmark//:jee9_install.json",
    repositories = [
        "https://maven-central-eu.storage-download.googleapis.com/maven2",
        "https://repo1.maven.org/maven2",
    ],
)

load("@jee9//:defs.bzl", jee9_pinned_maven_install = "pinned_maven_install")

jee9_pinned_maven_install()

# ---

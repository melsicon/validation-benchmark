load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "benchmark",
    srcs = glob(["*.java"]),
    javacopts = [
        "-AskipDefs=\\.jmh_generated\\.",
        "-Xlint:-cast",
    ],
    visibility = ["//visibility:public"],
    runtime_deps = [
        "@jee9//:org_glassfish_jakarta_el",
        "@jee9//:org_hibernate_validator_hibernate_validator",
    ],
    deps = [
        "//src/main/java/de/melsicon/example/validation/immutables",
        "//src/main/java/de/melsicon/example/validation/jee9/self_validating",
        "//src/main/java/de/melsicon/example/validation/jee9/validated",
        "//src/main/java/de/melsicon/example/validation/pojo",
        "//toolchain:checker",
        "//toolchain:jmh",
        "@jee9//:jakarta_validation_jakarta_validation_api",
        "@maven//:com_google_errorprone_error_prone_annotations",
    ],
)

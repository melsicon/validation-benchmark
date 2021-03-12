load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "benchmark",
    srcs = glob(["*.java"]),
    javacopts = [
        "-Xlint:-cast",
    ],
    visibility = ["//visibility:public"],
    runtime_deps = [
        "@maven//:com_google_flogger_flogger_system_backend",
        "@maven//:org_glassfish_jakarta_el",
        "@maven//:org_hibernate_validator_hibernate_validator",
    ],
    deps = [
        "//src/main/java/de/melsicon/example/validation/immutables",
        "//src/main/java/de/melsicon/example/validation/pojo",
        "//src/main/java/de/melsicon/example/validation/self_validating",
        "//src/main/java/de/melsicon/example/validation/validated",
        "//toolchain:jmh",
        "//toolchain:nullaway",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:jakarta_validation_jakarta_validation_api",
    ],
)

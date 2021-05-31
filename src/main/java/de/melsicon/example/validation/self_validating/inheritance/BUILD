load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "inheritance",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//src/main/java/de/melsicon/example/validation/self_validating",
        "//toolchain:checker",
        "//toolchain:lombok",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:jakarta_validation_jakarta_validation_api",
    ],
)

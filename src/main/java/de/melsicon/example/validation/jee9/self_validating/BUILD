load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "self_validating",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//toolchain:checker",
        "//toolchain:lombok",
        "@jee9//:jakarta_validation_jakarta_validation_api",
        "@maven//:com_google_errorprone_error_prone_annotations",
    ],
)

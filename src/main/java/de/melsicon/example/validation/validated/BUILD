load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "validated",
    srcs = glob(["*.java"]),
    visibility = ["//visibility:public"],
    deps = [
        "//toolchain:checker",
        "//toolchain:immutables",
        "//toolchain:lombok",
        "@maven//:com_google_errorprone_error_prone_annotations",
        "@maven//:jakarta_validation_jakarta_validation_api",
    ],
)

load("@rules_java//java:defs.bzl", "java_library")

java_library(
    name = "validated",
    srcs = glob(["*.java"]),
    javacopts = ["-AskipDefs=\\.Immutable[A-Z][A-Za-z0-9]*$$"],
    visibility = ["//visibility:public"],
    deps = [
        "//toolchain:checker",
        "//toolchain:immutables",
        "//toolchain:lombok",
        "@jee9//:jakarta_validation_jakarta_validation_api",
        "@maven//:com_google_code_findbugs_jsr305",
        "@maven//:com_google_errorprone_error_prone_annotations",
    ],
)

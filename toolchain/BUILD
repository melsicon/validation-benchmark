load("@bazel_tools//tools/jdk:default_java_toolchain.bzl", "default_java_toolchain")
load("@rules_java//java:defs.bzl", "java_library", "java_package_configuration", "java_plugin")

default_java_toolchain(
    name = "toolchain_java11",
    package_configuration = [
        ":src_configuration",
    ],
    source_version = "11",
    target_version = "11",
    visibility = ["//visibility:public"],
    xlint = [
        "all",
        "-processing",
    ],
)

JAVACOPTS = [
    "-Werror",
    "-Xpkginfo:always",
    "-XepExcludedPaths:.*/bazel-out/.*",
    "-XepDisableWarningsInGeneratedCode",
    "-XepAllDisabledChecksAsWarnings",
    "-Xep:Java7ApiChecker:OFF",
    "-Xep:AndroidJdkLibsChecker:OFF",
    "-Xep:StaticOrDefaultInterfaceMethod:OFF",
    "-Xep:NoFunctionalReturnType:OFF",
    "-Xep:WildcardImport:OFF",
    "-Xep:NullAway:ERROR",
    "-XepOpt:NullAway:AnnotatedPackages=de.melsicon",
    "-XepOpt:NullAway:TreatGeneratedAsUnannotated",
    "-XepOpt:NullAway:CheckOptionalEmptiness",
    "-XepOpt:NullAway:AcknowledgeRestrictiveAnnotations",
    "-XepOpt:NullAway:CustomInitializerAnnotations=org.junit.Before,org.junit.BeforeClass,org.openjdk.jmh.annotations.Setup",
    "-XepOpt:NullAway:ExcludedFieldAnnotations=org.openjdk.jmh.annotations.Param",
]

java_package_configuration(
    name = "src_configuration",
    javacopts = JAVACOPTS,
    packages = [":src_group"],
)

package_group(
    name = "src_group",
    packages = [
        "//src/...",
    ],
)

# ---
# https://github.com/uber/NullAway/wiki

java_plugin(
    name = "nullaway_processor",
    deps = ["@maven//:com_uber_nullaway_nullaway"],
)

java_library(
    name = "nullaway",
    exported_plugins = ["nullaway_processor"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_checkerframework_checker_qual"],
)

# ---
# https://checkerframework.org/manual/#nullness-checker

java_plugin(
    name = "checker_processor",
    processor_class = "org.checkerframework.checker.nullness.NullnessChecker",
    deps = ["@maven//:org_checkerframework_checker"],
)

java_library(
    name = "checker",
    exported_plugins = ["checker_processor"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_checkerframework_checker_qual"],
)

# ---
# https://immutables.github.io

java_plugin(
    name = "immutables_processor",
    generates_api = True,
    processor_class = "org.immutables.value.processor.Processor",
    deps = ["@maven//:org_immutables_value_processor"],
)

java_library(
    name = "immutables",
    exported_plugins = ["immutables_processor"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_immutables_value_annotations"],
)

# ---
# https://projectlombok.org/features/all

java_plugin(
    name = "lombok_processor",
    generates_api = True,
    processor_class = "lombok.launch.AnnotationProcessorHider$AnnotationProcessor",
    deps = ["@maven//:org_projectlombok_lombok"],
)

java_library(
    name = "lombok",
    data = [
        "//:lombok.config",
    ],
    exported_plugins = ["lombok_processor"],
    neverlink = True,
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_projectlombok_lombok"],
)

# ---
# https://github.com/openjdk/jmh

java_plugin(
    name = "jmh_processor",
    processor_class = "org.openjdk.jmh.generators.BenchmarkProcessor",
    deps = ["@maven//:org_openjdk_jmh_jmh_generator_annprocess"],
)

java_library(
    name = "jmh",
    exported_plugins = ["jmh_processor"],
    visibility = ["//visibility:public"],
    exports = ["@maven//:org_openjdk_jmh_jmh_core"],
)

# ---
# https://truth.dev

java_library(
    name = "truth",
    testonly = True,
    visibility = ["//visibility:public"],
    exports = [
        "@maven//:com_google_truth_extensions_truth_java8_extension",
        "@maven//:com_google_truth_truth",
        "@maven//:junit_junit",
        "@maven//:org_ow2_asm_asm",
    ],
)

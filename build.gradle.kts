plugins {
    id("application")
    id("jvm-test-suite")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

application {
    mainClass.set("fr.univamu.progav.Main")
}

group = "fr.univamu"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

testing {
    suites {
        withType<JvmTestSuite>().configureEach {
            useJUnitJupiter()

            dependencies {
                implementation(platform("org.junit:junit-bom:5.10.0"))
                implementation("org.junit.jupiter:junit-jupiter")
            }

            targets {
                all {
                    testTask.configure {
                        testLogging {
                            events("passed", "skipped", "failed")
                            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
                            showStandardStreams = true
                        }
                    }
                }
            }
        }

        getByName<JvmTestSuite>("test") {
        }

        fun registerTdSuite(suiteName: String, packagePath: String) {
            register(suiteName, JvmTestSuite::class.java) {
                sources {
                    java {
                        setSrcDirs(listOf("src/$suiteName/java"))
                    }
                    resources {
                        setSrcDirs(listOf("src/$suiteName/resources"))
                    }
                }
                dependencies {
                    implementation(project())
                }
            }
        }

        (1..9).forEach { i ->
            registerTdSuite("td${i}test", "td$i")
        }
    }
}

// Make `check` (and therefore `build`, CI, etc.) run every td suite too
tasks.named("check") {
    dependsOn(testing.suites.matching { it.name.startsWith("td") })
}


(1..9).forEach { i ->
    tasks.register("td$i") { dependsOn("td${i}Test") }
}
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
//        val test by getting(JvmTestSuite::class) {
        getByName<JvmTestSuite>("test") {
            useJUnitJupiter() 

            dependencies {
                implementation(platform("org.junit:junit-bom:5.10.0"))
                implementation("org.junit.jupiter:junit-jupiter")
            }
        }

        fun registerTdSuite(suiteName: String, packagePath: String) {
            suites.register(suiteName, JvmTestSuite::class.java) {
                sources {
                   java {
                        setSrcDirs(listOf("src/test/java"))
                    }
                }
                dependencies {
                   implementation(project())
                   implementation(platform("org.junit:junit-bom:5.10.0"))
                   implementation("org.junit.jupiter:junit-jupiter")
                }
                useJUnitJupiter()
                   targets {
                      all {
                        testTask.configure {
                           filter { includeTestsMatching("fr.univamu.progav.td.$packagePath.*") }
                        }
                    }	
                }
            }
        }

        (1..9).forEach { i ->
            registerTdSuite("td${i}Test", "td$i")
        }

    }
}


plugins {
    `java-library`
    id("xyz.jpenilla.run-paper") version "2.3.1"
    id("de.eldoria.plugin-yml.bukkit") version "0.7.1"
}

java { toolchain.languageVersion.set(JavaLanguageVersion.of(project.ext.get("javaToolchainVersion") as Int)) }

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()

        sourceCompatibility = JavaVersion.VERSION_1_8.toString()
        targetCompatibility = JavaVersion.VERSION_1_8.toString()
    }

    javadoc { options.encoding = Charsets.UTF_8.name() }
    processResources { filteringCharset = Charsets.UTF_8.name() }

    runServer {
        minecraftVersion("1.11.2")
        jvmArgs("-Dcom.mojang.eula.agree=true")
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.21.5-R0.1-SNAPSHOT")
}


bukkit {
    main = "me.sytex.noShieldDelay.NoShieldDelay"

    name = "NoShieldDelay"
    description = "Remove the server-side delay for shields to make blocking more responsive. "
    version = project.version as String

    authors = listOf("Sytex")
    contributors = listOf()
}
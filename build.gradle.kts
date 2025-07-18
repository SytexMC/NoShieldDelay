allprojects {
    group = "me.sytex"
    version = "2.0.2"

    ext { set("javaToolchainVersion", 8) }

    tasks.withType<Jar> {
        archiveBaseName.set(rootProject.name)
    }

    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }
}

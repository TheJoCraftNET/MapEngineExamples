plugins {
    id("java-library")
    id("net.minecrell.plugin-yml.bukkit") version "0.5.3"
}

group = "de.pianoman911"
version = "1.0.0"

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.thejocraft.net/releases/")
}

dependencies {
    compileOnlyApi("io.papermc.paper:paper-api:1.19.4-R0.1-SNAPSHOT")
    compileOnlyApi("de.pianoman911:mapengine-api:1.3.1")
}

bukkit {
    main = "$group.mapengineexampleplugin.ExamplePlugin"
    apiVersion = "1.19"
    authors = listOf("pianoman911")
    depend = listOf("MapEngine")
    name = rootProject.name
}

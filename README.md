# Enderman Overhaul

To add this library to your project, do the following:

Kotlin DSL:
```kotlin
repositories {
    maven(url = "https://maven.teamresourceful.com/repository/maven-public/")
}

dependencies {
    implementation("tech.alexnijjar.endermanoverhaul:endermanoverhaul-neoforge-$minecraftVersion:$endermanOverhaulVersion")
}
```

Groovy DSL:
```groovy
repositories {
    maven { url "https://maven.teamresourceful.com/repository/maven-public/" }
}

dependencies {
    implementation "tech.alexnijjar.endermanoverhaul:endermanoverhaul-neoforge-$minecraftVersion:$endermanOverhaulVersion"
}
```
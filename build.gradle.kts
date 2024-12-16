plugins {
    id("java")
}

//======================
// SOFTWARE INFORMATION
//======================
group = "lu.embellishedduck"
version = "PRE-ALPHA"

//=======================
// INSTANTIATE VARIABLES
//=======================
val lwjglVersion = "3.3.4"
val jomlVersion = "1.10.7"
val `joml-primitivesVersion` = "1.10.0"
val `lwjgl3-awtVersion` = "0.1.8"
val steamworks4jVersion = "1.9.0"
val `steamworks4j-serverVersion` = "1.9.0"

val lwjglNatives = Pair(
    System.getProperty("os.name")!!,
    System.getProperty("os.arch")!!
).let { (name, arch) ->
    when {
        arrayOf("Linux", "SunOS", "Unit").any { name.startsWith(it) } ->
            if (arrayOf("arm", "aarch64").any { arch.startsWith(it) })
                "natives-linux${if (arch.contains("64") || arch.startsWith("armv8")) "-arm64" else "-arm32"}"
            else if (arch.startsWith("ppc"))
                "natives-linux-ppc64le"
            else if (arch.startsWith("riscv"))
                "natives-linux-riscv64"
            else
                "natives-linux"
        arrayOf("Mac OS X", "Darwin").any { name.startsWith(it) }     ->
            "natives-macos${if (arch.startsWith("aarch64")) "-arm64" else ""}"
        arrayOf("Windows").any { name.startsWith(it) }                ->
            if (arch.contains("64"))
                "natives-windows${if (arch.startsWith("aarch64")) "-arm64" else ""}"
            else
                "natives-windows-x86"
        else                                                                            ->
            throw Error("Unrecognized or unsupported platform. Please set \"lwjglNatives\" manually")
    }
}


//================================
// REPOSITORIES TO PULL FROM HERE
//================================
repositories {

    mavenCentral()

}


//======================
// PROJECT DEPENDENCIES
//======================
dependencies {

    implementation(platform("org.lwjgl:lwjgl-bom:$lwjglVersion"))

    implementation("org.lwjgl", "lwjgl")
    implementation("org.lwjgl", "lwjgl-assimp")
    implementation("org.lwjgl", "lwjgl-cuda")
    implementation("org.lwjgl", "lwjgl-glfw")
    implementation("org.lwjgl", "lwjgl-ktx")
    implementation("org.lwjgl", "lwjgl-meshoptimizer")
    implementation("org.lwjgl", "lwjgl-nuklear")
    implementation("org.lwjgl", "lwjgl-openal")
    implementation("org.lwjgl", "lwjgl-opencl")
    implementation("org.lwjgl", "lwjgl-opengl")
    implementation("org.lwjgl", "lwjgl-stb")
    runtimeOnly("org.lwjgl", "lwjgl", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-assimp", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-glfw", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-ktx", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-meshoptimizer", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-nuklear", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-openal", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-opengl", classifier = lwjglNatives)
    runtimeOnly("org.lwjgl", "lwjgl-stb", classifier = lwjglNatives)
    implementation("org.joml", "joml", jomlVersion)
    implementation("org.joml", "joml-primitives", `joml-primitivesVersion`)
    implementation("org.lwjglx", "lwjgl3-awt", `lwjgl3-awtVersion`)
    implementation("com.code-disaster.steamworks4j", "steamworks4j", steamworks4jVersion)
    implementation("com.code-disaster.steamworks4j", "steamworks4j-server", `steamworks4j-serverVersion`)

    //SLF4J
    implementation("org.slf4j", "slf4j-api", "2.0.16")
    implementation("org.slf4j", "slf4j-simple", "2.0.16")

    //Lombok
    implementation("org.projectlombok", "lombok", "1.18.36")
    annotationProcessor("org.projectlombok", "lombok", "1.18.36")

    //Jsoniter
    implementation("com.jsoniter", "jsoniter", "0.9.19")

}
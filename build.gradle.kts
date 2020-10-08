import kr.entree.spigradle.kotlin.protocolLib
import kr.entree.spigradle.kotlin.spigot

plugins {
    id("kr.entree.spigradle") version "2.2.3"
}

group = "kr.acog"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    protocolLib()
}

dependencies {
    testCompile("junit", "junit", "4.12")
    compileOnly("org.projectlombok:lombok:1.18.12")
    annotationProcessor("org.projectlombok:lombok:1.18.12")
    compileOnly(spigot("1.12.2"))
    compileOnly(protocolLib())
}

spigot {
    description = "Study Plugin"
    depends = listOf("ProtocolLib")
    commands {
        create("대전") {
            aliases = listOf("싸움")
            description = "대전 명령어"
            permission = "auto.fight"
        }
        create("대전관리") {
            aliases = listOf("싸움관리")
            description = "대전관리 명령어"
            permission = "auto.fight.*"
        }
    }
    permissions {
        create("auto.fight.user") {
            description = "AutoFight Command Permission"
            defaults = "true"
        }
        create("auto.fight.*") {
            description = "AutoFight Command Top Permission"
            defaults = "op"
        }
    }
}

tasks {
    compileJava.get().options.encoding = "UTF-8"
    compileTestJava.get().options.encoding = "UTF-8"
}
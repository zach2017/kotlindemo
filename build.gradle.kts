import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.0.4"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
}

group = "zach"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

extra["springCloudAzureVersion"] = "5.0.0"
extra["springCloudVersion"] = "2022.0.1"

dependencies {

	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-amqp")
//	implementation("org.springframework.boot:spring-boot-starter-data-couchbase")
//	implementation("org.springframework.boot:spring-boot-starter-data-couchbase-reactive")
//	implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
//	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
//	implementation("org.springframework.boot:spring-boot-starter-graphql")
//	implementation("org.springframework.boot:spring-boot-starter-mail")
//	implementation("org.springframework.boot:spring-boot-starter-quartz")
//	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.azure.spring:spring-cloud-azure-starter")
/*
 	implementation("com.azure.spring:spring-cloud-azure-starter-actuator")
	implementation("com.azure.spring:spring-cloud-azure-starter-jdbc-mysql")
	implementation("com.azure.spring:spring-cloud-azure-starter-jdbc-postgresql")
	implementation("com.azure.spring:spring-cloud-azure-starter-keyvault")
	implementation("com.azure.spring:spring-cloud-azure-starter-storage")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.apache.kafka:kafka-streams")
	implementation("org.flywaydb:flyway-core")
	implementation("org.flywaydb:flyway-mysql")
	implementation("org.flywaydb:flyway-sqlserver")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation("org.springframework.cloud:spring-cloud-config-server")
	implementation("org.springframework.cloud:spring-cloud-starter-config")
	implementation("org.springframework.cloud:spring-cloud-starter-vault-config")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity6")
//	compileOnly("org.projectlombok:lombok")
//	runtimeOnly("com.h2database:h2")
//	runtimeOnly("com.microsoft.sqlserver:mssql-jdbc")
//	runtimeOnly("com.mysql:mysql-connector-j")
//	runtimeOnly("io.micrometer:micrometer-registry-datadog")
//	runtimeOnly("io.micrometer:micrometer-registry-prometheus")
//	runtimeOnly("org.postgresql:postgresql")
//	annotationProcessor("org.projectlombok:lombok")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")
//	testImplementation("io.projectreactor:reactor-test")
//	testImplementation("org.springframework.amqp:spring-rabbit-test")
//	testImplementation("org.springframework.graphql:spring-graphql-test")
//	testImplementation("org.springframework.kafka:spring-kafka-test")
//	testImplementation("org.springframework.security:spring-security-test")
*/
}

dependencyManagement {
	imports {
		mavenBom("com.azure.spring:spring-cloud-azure-dependencies:${property("springCloudAzureVersion")}")
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

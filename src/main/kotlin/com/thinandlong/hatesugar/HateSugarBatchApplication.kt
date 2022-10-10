package com.thinandlong.hatesugar

import com.thinandlong.hatesugar.extension.Zone
import mu.KotlinLogging
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationListener
import org.springframework.core.env.Environment
import java.util.*

@SpringBootApplication
class HateSugarBatchApplication(
    private val environment: Environment
) : ApplicationListener<ApplicationReadyEvent> {
    private val logger = KotlinLogging.logger { }

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        logger.info { "applicationReady status ${environment.activeProfiles.contentToString()}" }
    }
}

fun main(args: Array<String>) {
    init()
    runApplication<HateSugarBatchApplication>(*args)
}

fun init() {
    TimeZone.setDefault(TimeZone.getTimeZone(Zone.KST))

    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "100")

    java.security.Security.setProperty("networkaddress.cache.ttl", "60")
    java.security.Security.setProperty("networkaddress.cache.negative.ttl", "10")
}

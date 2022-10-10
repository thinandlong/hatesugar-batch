package com.thinandlong.hatesugar.extension

import com.thinandlong.hatesugar.common.domain.EnvironmentType
import org.springframework.core.env.Environment

fun Environment.isProd(): Boolean {
    return this.activeProfiles.any {
        it.equals(EnvironmentType.PROD.value)
    }
}

fun Environment.isStaging(): Boolean {
    return this.activeProfiles.any {
        it.equals(EnvironmentType.STAGING.value)
    }
}

fun Environment.isTest(): Boolean {
    return this.activeProfiles.any {
        it.equals(EnvironmentType.TEST.value)
    }
}

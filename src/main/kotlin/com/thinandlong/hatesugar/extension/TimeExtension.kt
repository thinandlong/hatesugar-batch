package com.thinandlong.hatesugar.extension

import java.time.ZoneId

object Zone {
    val KST: ZoneId = ZoneId.of("Asia/Seoul")
    val UTC: ZoneId = ZoneId.of("UTC")
}

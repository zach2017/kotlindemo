package zach.simple

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DefaultController {

    companion object {
        private val LOG: Logger = LoggerFactory.getLogger(DefaultController::class.java)
    }

    @GetMapping("/")
    fun get(): String {

        LOG.info("DEFAULT HERE")

        return " HOME DEFAULT "
    }
}

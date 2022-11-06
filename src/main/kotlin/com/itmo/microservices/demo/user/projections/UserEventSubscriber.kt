package com.itmo.microservices.demo.user.projections

import com.itmo.microservices.demo.user.api.UserAggregate
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.quipy.streams.AggregateSubscriptionsManager
import javax.annotation.PostConstruct

@Service
class UserEventSubscriber {

    val Logger = LoggerFactory.getLogger(UserEventSubscriber::class.java)

    lateinit var subscriptionsManager: AggregateSubscriptionsManager

    @PostConstruct
    fun init() {
        subscriptionsManager.createSubscriber(UserAggregate::class, "some-subscriber-name") {
            Logger.debug("subscriber created for user")
        }
    }
}
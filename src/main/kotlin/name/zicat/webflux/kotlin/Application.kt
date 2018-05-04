package name.zicat.webflux.kotlin

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.embedded.netty.NettyReactiveWebServerFactory
import org.springframework.boot.web.embedded.netty.NettyServerCustomizer
import org.springframework.boot.web.reactive.server.ReactiveWebServerFactory
import org.springframework.context.annotation.Bean
import reactor.core.scheduler.Scheduler
import reactor.core.scheduler.Schedulers
import java.util.concurrent.Executors
import reactor.ipc.netty.resources.LoopResources

/**
 *
 * @author zicat
 *
 */

@SpringBootApplication
open class WebFluxKotlinApplication {

    @Value("\${server.loopThreads}") lateinit var lootThreads: Integer

    @Value("\${reactor.workThreads}") lateinit var workThread: Integer


    @Bean
    open fun reactiveWebServerFactory(): ReactiveWebServerFactory {
        val factory = NettyReactiveWebServerFactory()
        factory.addServerCustomizers(NettyServerCustomizer {
            builder -> builder.loopResources(LoopResources.create("loop-http", lootThreads.toInt(), true))
        })
        return factory
    }

    @Bean
    open fun getScheduler(): Scheduler {
        val threadPool = Executors.newFixedThreadPool(workThread.toInt())
        return Schedulers.fromExecutor(threadPool)
    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder().sources(WebFluxKotlinApplication::class.java)
            .web(WebApplicationType.REACTIVE).run(*args)
}
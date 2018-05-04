package name.zicat.webflux.kotlin.controller

import name.zicat.webflux.kotlin.model.ProductInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import reactor.core.scheduler.Scheduler


/**
 *
 * @author zicat
 *
 */

@RestController class ProductHandler {


    @Autowired lateinit var scheduler: Scheduler

    /**
     *
     * @param productId
     * @param description
     *
     * @return Mono<ProductInfo>
     *
     */
    @GetMapping(value = "/product", produces = [(MediaType.APPLICATION_JSON_UTF8_VALUE)])
    fun product(productId: Int, description: String): Mono<ProductInfo> {
        return Mono.just(ProductInfo(productId, description)).subscribeOn(scheduler)
    }
}
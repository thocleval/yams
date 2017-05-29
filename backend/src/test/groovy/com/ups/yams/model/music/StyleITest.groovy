package com.ups.yams.model.music

import com.ups.yams.repository.StyleMongoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
class StyleITest extends Specification {
    @Autowired StyleMongoRepository styleMongoRepository

    def "test save repository"() {
        given: "a style"
        Style style = new Style(name: "rock", description: "Des solos de la disto et des chanteurs qui crient.")

        when: "the style is saved"
        styleMongoRepository.save(style)

        then: "the track has an id"
        style.getId() != null
    }
}
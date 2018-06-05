package io.micronaut.spec

import geb.spock.GebSpec
import io.micronaut.GoogleAnalytics
import io.micronaut.pages.FaqPage

class FaqSpec extends GebSpec implements GoogleAnalytics {

    def "faq page has google analytics code"() {
        when:
        to FaqPage

        then:
        browser.driver.pageSource.contains(googleAnalyticsCode)
    }
}

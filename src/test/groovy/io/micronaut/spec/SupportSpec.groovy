package io.micronaut.spec

import geb.spock.GebSpec
import io.micronaut.GoogleAnalytics
import io.micronaut.pages.SupportPage

class SupportSpec extends GebSpec implements GoogleAnalytics {

    def "faq page has google analytics code"() {
        when:
        to SupportPage

        then:
        browser.driver.pageSource.contains(googleAnalyticsCode)
    }
}

package io.micronaut.spec

import geb.spock.GebSpec
import io.micronaut.GoogleAnalytics
import io.micronaut.pages.HomePage

class HomeSpec extends GebSpec implements GoogleAnalytics {

    def "if I go to index.html, I am in the home page"() {
        when:
        browser.to HomePage

        then:
        at HomePage
    }

    def "home page has google analytics code"() {
        when:
        to HomePage

        then:
        browser.driver.pageSource.contains(googleAnalyticsCode)
    }
}
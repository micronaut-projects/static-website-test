package io.micronaut.spec

import geb.spock.GebSpec
import io.micronaut.GoogleAnalytics
import io.micronaut.pages.NewsPage

class NewsSpec extends GebSpec implements GoogleAnalytics {

    def "news page has google analytics code"() {
        when:
        to NewsPage

        then:
        browser.driver.pageSource.contains(googleAnalyticsCode)
    }
}

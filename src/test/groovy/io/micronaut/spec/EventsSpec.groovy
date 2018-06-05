package io.micronaut.spec

import geb.spock.GebSpec
import io.micronaut.GoogleAnalytics
import io.micronaut.pages.EventsPage
import spock.util.concurrent.PollingConditions

class EventsSpec extends GebSpec implements GoogleAnalytics {

    def conditions = new PollingConditions(timeout: 5)

    def "events page has google analytics code"() {
        when:
        to EventsPage

        then:
        at EventsPage

        and:
        driver.pageSource.contains(googleAnalyticsCode)
    }

    def "training offerings are displayed in Events Page"() {

        when:
        to EventsPage

        then:
        at EventsPage

        and:
        conditions.eventually {
            trainingOfferings().size() > 0
        }
    }

    def "events are displayed in Events Page"() {

        when:
        to EventsPage

        then:
        at EventsPage

        and:
        conditions.eventually {
            events().size() > 0
        }
    }
}

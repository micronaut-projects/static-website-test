package io.micronaut

import geb.spock.GebSpec

class DocumentationSpec extends GebSpec implements GoogleAnalytics {

    def "Docs page has snapshot/api"() {
        when:
        to DocumentationPage

        then:
        at DocumentationPage

        and:
        hasSnapshotApiLink()
    }

    def "Docs page has snapshot/guide"() {

        when:
        browser.to DocumentationPage

        then:
        at DocumentationPage

        and:
        hasSnapshotUserGuideLink()
    }

    def "Docs page has latest/api"() {

        when:
        browser.to DocumentationPage

        then:
        at DocumentationPage

        and:
        hasLatestApiLink()
    }

    def "Docs page has latest/guide"() {

        when:
        browser.to DocumentationPage

        then:
        at DocumentationPage

        and:
        hasLatestUserGuideLink()
    }

    def "home page has google analytics code"() {
        when:
        to HomePage

        then:
        browser.driver.pageSource.contains(googleAnalyticsCode)
    }
}

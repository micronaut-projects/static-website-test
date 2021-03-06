package io.micronaut.spec

import geb.spock.GebSpec
import io.micronaut.GoogleAnalytics
import io.micronaut.pages.DocumentationPage
import io.micronaut.pages.HomePage

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
        to DocumentationPage

        then:
        at DocumentationPage

        and:
        hasSnapshotUserGuideLink()
    }

    def "Docs page has latest/api"() {

        when:
        to DocumentationPage

        then:
        at DocumentationPage

        and:
        hasLatestApiLink()
    }

    def "Docs page has latest/guide"() {

        when:
        to DocumentationPage

        then:
        at DocumentationPage

        and:
        hasLatestUserGuideLink()
    }

    def "home page has google analytics code"() {
        when:
        to HomePage

        then:
        driver.pageSource.contains(googleAnalyticsCode)
    }
}

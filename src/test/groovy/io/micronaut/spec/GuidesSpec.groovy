package io.micronaut.spec

import geb.spock.GebReportingSpec
import groovy.util.logging.Slf4j
import io.micronaut.GoogleAnalytics
import io.micronaut.pages.GuidesPage

@Slf4j
class GuidesSpec extends GebReportingSpec implements GoogleAnalytics {

    def "search filters guides"() {
        when:
        to(GuidesPage)

        then:
        at(GuidesPage)

        when:
        String query = 'Bas'
        search(query)

        then:
        numberOfGuides() < old(numberOfGuides())

        and:
        searchResultsText().contains("GUIDES FILTERED BY: ${query.toUpperCase()}")
    }

    def "check every guide contains google analytic snippet"() {
        when:
        to(GuidesPage)

        then:
        at(GuidesPage)

        and:
            for ( String href  : browser.page.guideLinksHref()) {
                browser.go href
                boolean contains = driver.pageSource.contains(googleAnalyticsCode)
                if(!contains) {
                    log.error '{} does not contain google analytics snippet', href
                }
                assert contains
            }
    }
}

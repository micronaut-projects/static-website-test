package io.micronaut.spec

import geb.spock.GebReportingSpec
import groovy.util.logging.Slf4j
import io.micronaut.GoogleAnalytics
import io.micronaut.GradlePropertiesReader
import io.micronaut.pages.GuidesPage

@Slf4j
class GuidesSpec extends GebReportingSpec implements GoogleAnalytics, GradlePropertiesReader {

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

    def "check every guide uses the latest micronaut version"() {
        when:
        to(GuidesPage)

        then:
        at(GuidesPage)

        and:
        for ( String href  : browser.page.guideLinksHref()) {
            browser.go href
            boolean contains = driver.pageSource.contains(micronautVersion())
            if(!contains) {
                log.error '{} does not contain {}', href, micronautVersion()
            }
            assert contains
        }
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

    def "check every java/kotlin guide contains annotation processing section"() {
        when:
        to(GuidesPage)

        then:
        at(GuidesPage)

        and:
        for ( String href  : browser.page.guideLinksHref()) {
            if ( href.contains('groovy') ) {
                continue
            }
            browser.go href
            String html = driver.pageSource
            if (html.contains("Transcript</h2>")) {
                continue
            }
            boolean contains = html.contains('img/annotationprocessorsintellij.png')
            if(!contains) {
                log.error '{} does not contain annotation processing section', href
            }
            assert contains
        }
    }

    def "check every kotlin guide contains kapt/intellij section"() {
        when:
        to(GuidesPage)

        then:
        at(GuidesPage)

        and:
        for ( String href  : browser.page.guideLinksHref()) {
            if ( !href.endsWith('kt') ) {
                continue
            }
            browser.go href
            String html = driver.pageSource
            boolean contains = html.contains('Kotlin, Kapt and IntelliJ')
            if(!contains) {
                log.error '{} does not contain annotation kapt/intellij section', href
            }
            assert contains
        }
    }
}

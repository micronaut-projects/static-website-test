package io.micronaut.spec

import geb.spock.GebSpec
import io.micronaut.Github
import io.micronaut.GoogleAnalytics
import io.micronaut.pages.DownloadPage
import io.micronaut.pages.HomePage

class DownloadSpec extends GebSpec implements GoogleAnalytics, Github {

    def "download page has google analytics code"() {
        when:
        to DownloadPage

        then:
        at DownloadPage

        and:
        browser.driver.pageSource.contains(googleAnalyticsCode)
    }

    def "download version"() {
        given:
        String v = '1.0.0.M1'

        when:
        browser.to DownloadPage

        then:
        at DownloadPage

        and:
        latestVersion() == v

        and:
        downloadLinksHref().contains githubBinary(v)

        and:
        downloadLinksHref().contains githubRelease(v)


    }
}

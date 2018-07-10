package io.micronaut.spec

import geb.spock.GebSpec
import io.micronaut.Github
import io.micronaut.GoogleAnalytics
import io.micronaut.GradlePropertiesReader
import io.micronaut.pages.DownloadPage
import io.micronaut.pages.HomePage

class DownloadSpec extends GebSpec implements GradlePropertiesReader, GoogleAnalytics, Github {

    def "download page has google analytics code"() {
        when:
        to DownloadPage

        then:
        at DownloadPage

        and:
        browser.driver.pageSource.contains(googleAnalyticsCode)
    }

    def "download version"() {
        when:
        browser.to DownloadPage

        then:
        at DownloadPage

        and:
        latestVersion() == micronautVersion()

        and:
        downloadLinksHref().contains githubBinary(micronautVersion())

        and:
        downloadLinksHref().contains githubRelease(micronautVersion())
    }
}

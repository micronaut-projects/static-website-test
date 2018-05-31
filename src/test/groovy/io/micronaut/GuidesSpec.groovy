package io.micronaut

import geb.spock.GebReportingSpec
import geb.spock.GebSpec

class GuidesSpec extends GebReportingSpec {

    def "guides page contains black logo"() {
        when:
        browser.to(GuidesPage)

        then:
        browser.at(GuidesPage)

        when:
        GuidesPage page = browser.page(GuidesPage)
        report('antes-busqueda')

        then:
        page.hasBlackLogo()

        when:
        String query = 'Bas'
        page.search(query)

        then:
        page.numberOfGuides() < old(page.numberOfGuides())

        and:
        page.searchResultsText().contains("GUIDES FILTERED BY: ${query.toUpperCase()}")
    }
}

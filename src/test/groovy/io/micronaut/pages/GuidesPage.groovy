package io.micronaut.pages

import geb.Page
import geb.module.TextInput
import io.micronaut.modules.NavigationModule

class GuidesPage extends Page {

    static url = 'http://guides.micronaut.io/index.html'

    static at = { !$('body.guides').empty }

    static content = {
        nav { $('#navbar').module(NavigationModule) }

        blackLogo(required: false) {
            $('#blackLogo')
        }
        guideLinks {
            $('.guidegroup', style: notContains('display: none;')).$('li').$('a')
        }
        searchInput {
            $('#query').module(TextInput)
        }
        searchResults { $('#searchresults')}
    }

    List<String> guideLinksHref() {
        guideLinks.collect { it.getAttribute('href')}
    }

    String searchResultsText() {
        searchResults.text()
    }

    void search(String value) {
        for ( char c : value.toCharArray() ) {
            searchInput << c.toString()
        }
    }

    boolean hasBlackLogo() {
        !blackLogo.empty
    }

    int numberOfGuides() {
        guideLinks.size()
    }
}

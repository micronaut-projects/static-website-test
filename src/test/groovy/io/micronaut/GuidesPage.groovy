package io.micronaut

import geb.Page
import geb.module.TextInput

class GuidesPage extends Page {

    static url = 'http://guides.micronaut.io/index.html'

    static at = { !$('body.guides').empty }

    static content = {
        blackLogo(required: false) {
            $('#blackLogo')
        }
        guideLinks {
            $('.guidegroup', style: notContains('display: none;')).$('li')
        }
        searchInput {
            $('#query').module(TextInput)
        }
        searchResults { $('#searchresults')}
    }

    String searchResultsText() {
        searchResults.text()
    }

    void search(String value) {
        searchInput.text = value
    }

    boolean hasBlackLogo() {
        !blackLogo.empty
    }

    int numberOfGuides() {
        guideLinks.size()
    }
}

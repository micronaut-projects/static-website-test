package io.micronaut.pages

import geb.Page
import io.micronaut.modules.NavigationModule

class DocumentationPage extends Page {

    static url = 'documentation.html'

    static at = { !$('body.docs').empty }

    static content = {
        nav { $('#navbar').module(NavigationModule) }
        links { $('.guidegroup a') }
    }

    boolean hasSnapshotApiLink() {
        hasLinkWithWords(['snapshot', 'api'])
    }

    private boolean hasLinkWithWords(List<String> words) {
        links.any {
            String href = it.getAttribute('href')
            words.every { String word -> href.contains(word) }
        }
    }

    boolean hasSnapshotUserGuideLink() {
        hasLinkWithWords(['snapshot', 'guide'])

    }
    boolean hasLatestApiLink() {
        hasLinkWithWords(['latest', 'api'])
    }
    boolean hasLatestUserGuideLink() {
        hasLinkWithWords(['latest', 'guide'])
    }
}

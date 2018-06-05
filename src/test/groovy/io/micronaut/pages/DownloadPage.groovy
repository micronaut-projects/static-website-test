package io.micronaut.pages

import geb.Page
import io.micronaut.modules.NavigationModule

class DownloadPage extends Page {

    static url = 'download.html'

    static at = { !$('body.download').empty }

    static content = {
        nav { $('#navbar').module(NavigationModule) }

        downloadHeader { $('.guidegroupheader', 0) }

        downloadLinks { $('.guidegroup li a')}
    }

    String latestVersion() {
        downloadHeader.text().replaceAll('DOWNLOAD MICRONAUT ', '')
    }

    List<String> downloadLinksHref() {
        downloadLinks.collect { it.getAttribute('href') }
    }
}

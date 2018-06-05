package io.micronaut.pages

import geb.Page
import io.micronaut.modules.NavigationModule

class SupportPage extends Page {

    static url = 'support.html'

    static at = { title.contains('Commercial Support') }

    static content = {
        nav { $('#navbar').module(NavigationModule) }
    }
}

package io.micronaut.pages

import geb.Page
import io.micronaut.modules.NavigationModule

class HomePage extends Page {

    static url = 'index.html'

    static at = { title == 'Micronaut Framework' }

    static content = {
        nav { $('#navbar').module(NavigationModule) }
    }
}

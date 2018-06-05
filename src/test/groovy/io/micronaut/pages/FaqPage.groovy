package io.micronaut.pages

import geb.Page
import io.micronaut.modules.NavigationModule

class FaqPage extends Page {

    static url = 'faq.html'

    static at = { !$('body.faq').empty }

    static content = {
        nav { $('#navbar').module(NavigationModule) }
    }
}

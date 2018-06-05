package io.micronaut.pages

import geb.Page
import io.micronaut.modules.NavigationModule

class NewsPage extends Page {

    static url = 'announcement.html'

    static at = { !$('body.announcement').empty }

    static content = {
        nav { $('#navbar').module(NavigationModule) }
    }
}

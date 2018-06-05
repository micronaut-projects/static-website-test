package io.micronaut.pages

import geb.Page
import io.micronaut.modules.NavigationModule

class BuildStatusPage extends Page {

    static url = 'buildstatus.html'

    static at = { title == 'Build Status' }

    static content = {
        nav { $('#navbar').module(NavigationModule) }
    }
}

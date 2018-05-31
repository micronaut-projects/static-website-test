package io.micronaut

import geb.Page

class HomePage extends Page {

    static url = 'index.html'

    static at = { title == 'Micronaut Framework' }
}

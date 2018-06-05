package io.micronaut.pages

import geb.Page
import io.micronaut.modules.NavigationModule

class EventsPage extends Page {

    static url = 'events.html'

    static at = { !$('body.events').empty }

    static content = {
        nav { $('#navbar').module(NavigationModule) }
        eventLinks { $('#ocievents tbody a') }
        trainingLinks { $('#ocitraining tbody a') }
    }

    List<Event> events() {
        eventLinks.collect { new Event(href: it.getAttribute('href'), name: it.text()) }
    }

    List<Event> trainingOfferings() {
        trainingLinks.collect { new Event(href: it.getAttribute('href'), name: it.text()) }
    }
}

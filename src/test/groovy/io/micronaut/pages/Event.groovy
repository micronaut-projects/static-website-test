package io.micronaut.pages

import groovy.transform.Canonical
import groovy.transform.CompileStatic

@Canonical
@CompileStatic
class Event {
    String name
    String href
}

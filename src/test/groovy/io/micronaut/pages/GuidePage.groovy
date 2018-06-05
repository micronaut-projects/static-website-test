package io.micronaut.pages

import geb.Page

class GuidePage extends Page {

    static url = 'http://guides.micronaut.io/'

    @Override
    String convertToPath(Object[] args) {
        args ? "${args[0]}/guide/index.html" : ''
    }


}

package io.micronaut

import groovy.transform.CompileStatic

@CompileStatic
trait GradlePropertiesReader {

    String micronautVersion() {
        readProperty('micronautVersion')
    }

    String readProperty(String propertyName) {
        def propsFile = new File('gradle.properties')
        assert propsFile.exists()
        Properties props = new Properties()
        props.load(propsFile.newDataInputStream())
        props.getProperty(propertyName)
    }

}
package io.micronaut

trait Github {

    static final String GITHUB_ORGANIZATION = 'micronaut-projects'
    static final String GITHUB_PROJECT = 'micronaut-core'

    String githubRelease(String version) {
        "https://github.com/${GITHUB_ORGANIZATION}/${GITHUB_PROJECT}/releases/tag/v${version}"
    }

    String githubBinary(String version) {
        "https://github.com/${GITHUB_ORGANIZATION}/${GITHUB_PROJECT}/releases/download/v${version}/micronaut-${version}.zip"
    }

}

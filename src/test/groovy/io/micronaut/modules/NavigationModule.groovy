package io.micronaut.modules

import geb.Module
import io.micronaut.Github
import io.micronaut.pages.DocumentationPage
import io.micronaut.pages.DownloadPage
import io.micronaut.pages.EventsPage
import io.micronaut.pages.FaqPage
import io.micronaut.pages.GuidesPage
import io.micronaut.pages.HomePage
import io.micronaut.pages.NewsPage
import io.micronaut.pages.SupportPage

class NavigationModule extends Module implements Github {

    static content = {
        homeLink(to: HomePage) { $('a', href: endsWith(HomePage.url)) }
        newsLink(to: NewsPage) { $('a', href: endsWith(NewsPage.url)) }
        docsLink(to: DocumentationPage) { $('a', href: endsWith(DocumentationPage.url)) }
        downloadLink(to: DownloadPage) { $('a', href: endsWith(DownloadPage.url)) }
        guidesLink(to: GuidesPage) { $('a', href: endsWith(GuidesPage.url)) }
        eventsLink(to: EventsPage) { $('a', href: endsWith(EventsPage.url)) }
        faqLink(to: FaqPage) { $('a', href: endsWith(FaqPage.url)) }
        supportLink(to: SupportPage) { $('a', href: endsWith(SupportPage.url)) }
        githubLink { $('a', href: startsWith("http://github.com/${GITHUB_ORGANIZATION}")) }
    }

}

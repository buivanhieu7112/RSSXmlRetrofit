package com.example.rssparsexmlretrofit.vnexpress

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
class Article {
    @field:Element(name = "title")
    var title: String? = null

    @field:Element(name = "link")
    var link: String? = null

    @field:Element(name = "guid")
    var guid: String? = null

    @field:Element(name = "pubDate")
    var pubDate: String? = null
}

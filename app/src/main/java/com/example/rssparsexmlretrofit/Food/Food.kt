package com.example.rssparsexmlretrofit.Food

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "food",strict = true)
class Food {
    @field:Element(name = "name")
    var name: String? = null

    @field:Element(name = "price")
    var price: String? = null

    @field:Element(name = "description")
    var description: String? = null

    @field:Element(name = "calories")
    var calories: String? = null
}

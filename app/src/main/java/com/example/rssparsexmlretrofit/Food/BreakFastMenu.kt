package com.example.rssparsexmlretrofit.Food

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "breakfast_menu", strict = false)
class BreakFastMenu {
    @field:ElementList(inline = true)
    var foodList: MutableList<Food>? = null
}

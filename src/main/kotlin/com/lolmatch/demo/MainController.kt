package com.lolmatch.demo

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/")
    fun mainView(model : Model): String {
        return buildString {
        append("/first/main")
    }

    }
}
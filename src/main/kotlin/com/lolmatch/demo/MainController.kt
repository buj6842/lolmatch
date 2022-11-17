package com.lolmatch.demo

import com.lolmatch.user.dto.UserCreateDTO
import com.lolmatch.user.service.UserService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Controller
class MainController {

    @GetMapping("/test")
    fun mainView(model : Model): String {
        return buildString {
            append("/first/main")
        }
    }

}
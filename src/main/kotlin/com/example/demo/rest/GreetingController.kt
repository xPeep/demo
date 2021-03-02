package com.example.demo.rest

import org.springframework.ui.Model
import com.example.demo.mode.Greeting
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("website")
class GreetingController {

    @GetMapping("/goin")
    fun greetingForm(model: Model): String {
        model.addAttribute("login", Greeting())
        return "login"
    }

    @PostMapping("/goout")
    fun greetingSubmit(@ModelAttribute greeting: Greeting?, model: Model): String {
        model.addAttribute("result", greeting)
        return "result"
    }

}
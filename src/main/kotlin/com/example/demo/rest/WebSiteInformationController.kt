package com.example.demo.rest

import com.example.demo.manager.interfaces.IVisitorManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.thymeleaf.util.StringUtils
import java.util.*

@Controller
@RequestMapping("website-info")
class WebSiteInformationController(
        @Qualifier("webSiteVisitorManager") val webSiteVisitorManager: IVisitorManager,
        @Qualifier("globalWebSiteVisitorManager") val globalWebSiteVisitorManager: IVisitorManager
) {

    @RequestMapping(value = ["/visits"], method = [RequestMethod.POST, RequestMethod.GET])
    fun getVisitorInfo(model: Model): String {
        webSiteVisitorManager.add()
        globalWebSiteVisitorManager.add()
        model.addAttribute("visits", webSiteVisitorManager.counter)
        model.addAttribute("globalVisits", globalWebSiteVisitorManager.counter)
        return "greeting"
    }

    @RequestMapping(value = ["/welcome/{name}"], method = [RequestMethod.GET])
    fun listUsersInvoices(@PathVariable("name") name: String, model: Model): String {
        model.addAttribute("name", StringUtils.toUpperCase(name, Locale.ENGLISH))
        return "greeting"
    }
}


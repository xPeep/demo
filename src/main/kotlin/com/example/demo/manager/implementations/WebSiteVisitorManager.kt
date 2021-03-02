package com.example.demo.manager.implementations

import com.example.demo.manager.interfaces.IVisitorManager
import org.springframework.stereotype.Service

@Service
data class WebSiteVisitorManager(
        override var counter: Int = 0
) : IVisitorManager {

    override fun add() {
        counter++
    }
}
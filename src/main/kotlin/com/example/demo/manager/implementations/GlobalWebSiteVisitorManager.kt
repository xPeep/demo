package com.example.demo.manager.implementations

import com.example.demo.manager.interfaces.IVisitorManager
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Service

@Service
@Qualifier("CounterServiceImpl")
@Scope(value ="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
data class GlobalWebSiteVisitorManager(
        override var counter: Int = 0
) : IVisitorManager {

    override fun add() {
        counter++
    }

}
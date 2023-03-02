package com.github.vhawkmi.sk.listeners

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.github.vhawkmi.sk.services.MyProjectService

internal class MyProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        projectInstance = project
        project.getService(MyProjectService::class.java)
//        project.service<MyProjectService>()

//        System.getenv("CI")
//            ?: TODO("Don't forget to remove all non-needed sample code files with their corresponding registration entries in `plugin.xml`.")
    }

    override fun projectClosing(project: Project) {
        projectInstance = null
        super.projectClosing(project)
    }

    companion object {
        var projectInstance : Project ?= null
    }

}

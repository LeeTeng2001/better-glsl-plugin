package com.github.leeteng2001.betterglsljetbrain.listeners

import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.github.leeteng2001.betterglsljetbrain.services.MyProjectService

internal class MyProjectManagerListener : ProjectManagerListener {

    override fun projectOpened(project: Project) {
        project.service<MyProjectService>()
    }
}

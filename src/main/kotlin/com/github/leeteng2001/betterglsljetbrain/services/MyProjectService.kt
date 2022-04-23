package com.github.leeteng2001.betterglsljetbrain.services

import com.github.leeteng2001.betterglsljetbrain.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

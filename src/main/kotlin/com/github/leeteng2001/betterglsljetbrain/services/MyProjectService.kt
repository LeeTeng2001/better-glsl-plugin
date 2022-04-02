package com.github.leeteng2001.betterglsljetbrain.services

import com.intellij.openapi.project.Project
import com.github.leeteng2001.betterglsljetbrain.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

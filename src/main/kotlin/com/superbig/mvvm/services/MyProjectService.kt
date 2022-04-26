package com.superbig.mvvm.services

import com.intellij.openapi.project.Project
import com.superbig.mvvm.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

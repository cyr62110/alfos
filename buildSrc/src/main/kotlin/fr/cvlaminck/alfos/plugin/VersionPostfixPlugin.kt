package fr.cvlaminck.alfos.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 *
 */
class VersionPostfixPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.afterEvaluate {
            it.version = "2.0"
        }
    }
}

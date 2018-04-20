package com.quliang.mygroovy

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction;

/**
 * Created by quliang on 18-4-8.
 */

public class PatcherPlugin implements Plugin<Project> {

    private final String EXTENSION_PATCHER = "patcher"

    @Override
    void apply(Project project) {
        project.extensions.create(EXTENSION_PATCHER, PatcherExtension)
        project.tasks.create("patcherTest", PatcherTask)
    }
}

package com.quliang.mygroovy

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction;

/**
 * Created by quliang on 18-4-8.
 */

public class PatcherTask extends DefaultTask {

    PatcherTask() {
        super()
        group = 'patcher'
    }

    @TaskAction
    public void test() {

        println project.patcher.toString()

//        println(project.patcher.toString())
    }
}

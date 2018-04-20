package com.quliang.mygroovy;

/**
 * Created by quliang on 18-4-8.
 */

public class PatcherExtension {

    String sourceApk

    boolean ignoreWarning

    boolean useSign

    PatcherExtension() {
        sourceApk = ''
        ignoreWarning = false
        useSign = true
    }

    @Override
    public String toString() {
        """| sourceApk = ${sourceApk}
           | ignoreWarning = ${ignoreWarning}
           | useSign = ${useSign}
        """.stripMargin()
    }

}

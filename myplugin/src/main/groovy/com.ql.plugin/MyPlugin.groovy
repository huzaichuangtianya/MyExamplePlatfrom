
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by quliang on 18-4-8.
 */

public class MyPlugin implements Plugin<Project> {


    @Override
    void apply(Project project) {


            project.task('testTask') << {
                println "Hello gradle plugin"
            }


//        println "==========================="
//        println "hello world!"
//        println "==========================="
    }
}

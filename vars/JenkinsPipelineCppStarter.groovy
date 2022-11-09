def call(String configJsonPath = "PipelineConfig.json", def body) {
    println("Debug: JenkinsPipelineCpp is started from JenkinsPieplineManager!")
    node {
        echo("Does echo work in shared libraries because of Basic Pipeline Steps?")
        pwd()
        println(pwd())
    }
}

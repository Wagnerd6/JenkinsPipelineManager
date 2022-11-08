def call(String configJsonPath = "PipelineConfig.json", def body) {
    println("Debug: startPipeline executed")
    json = readJSON(file: configJsonPath, returnPojo: true)
}

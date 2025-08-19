# flink-job-template

> flink自定义作业模版

### 产品介绍
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [**至轻云**](https://zhiqingyun.isxcode.com)是一款企业级、智能化大数据中心。一键部署，开箱即用。可快速实现大数据计算、数据采集、数据清洗、数据安全、数据质量、数据管理、数据接口开放等功能，助力企业构建新一代智慧数据中心。

### 构建命令

```bash
git clone https://github.com/isxcode/flink-job-template.git
cd flink-job-template
./gradlew clean build
cp ./build/libs/flink-custom-job.jar ~/Downloads
```

### 新建作业

- 应用名称: custom-job
- mainClass: com.isxcode.acorn.job.Job
- 请求参数: insert into print_sink select count(*) from my_source;

### 官网计算demo

- https://zhiqingyun-demo.isxcode.com/tools/open/file/WordCount.jar

- 应用名称: flink-demo
- mainClass: org.apache.flink.examples.java.wordcount.WordCount
- 请求参数(4个): 
  - --input
  - /Users/ispong/zhiqingyun-agent/README.md
  - --output
  - /Users/ispong/Downloads/out.txt

![20241024174811](https://img.isxcode.com/picgo/20241024174811.png)

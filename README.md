# flink-job-template

> flink自定义作业模版

### 产品介绍
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [**至流云**](https://zhiliuyun.isxcode.com)是一款超轻量级、企业级流式计算产品，围绕Flink生态打造的数据计算平台。一键部署，开箱即用。可快速实现Flink计算、作业调度、数据ETL、数据同步、实时计算等场景。

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

- https://openfly.oss-cn-shanghai.aliyuncs.com/WordCount.jar

应用名称: flink-demo
mainClass: org.apache.flink.examples.java.wordcount.WordCount
请求参数: 
- --input
- /Users/ispong/Downloads/in.txt
- --output
- /Users/ispong/Downloads/out.txt
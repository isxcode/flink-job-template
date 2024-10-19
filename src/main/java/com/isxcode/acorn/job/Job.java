package com.isxcode.acorn.job;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

public class Job {

    public static void main(String[] args) {

        // 从args中获取参数
        String sql = args[0];

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        EnvironmentSettings settings = EnvironmentSettings.newInstance().inStreamingMode().build();
        StreamTableEnvironment streamTableEnvironment = StreamTableEnvironment.create(env, settings);

        String flinkSql = "CREATE TABLE my_source (\n" +
                "    id INT,\n" +
                "    name STRING\n" +
                ") WITH (\n" +
                "    'connector' = 'datagen',  -- 指定连接器为 datagen\n" +
                "    'rows-per-second' = '10',  -- 每秒生成的行数\n" +
                "    'fields.id.kind' = 'sequence',  -- id 字段的生成方式为递增\n" +
                "    'fields.id.start' = '1',  -- id 的起始值\n" +
                "    'fields.id.end' = '100',  -- id 的最大值\n" +
                "    'fields.name.kind' = 'random',  -- name 字段生成随机字符串\n" +
                "    'fields.name.length' = '10'  -- name 字符串的长度\n" +
                ");\n" +
                "\n" +
                "CREATE TABLE print_sink ( \n" +
                "    count_number INT \n" +
                ") WITH ( \n" +
                "    'connector' = 'print' \n" +
                ");\n" +
                "\n" + sql;

        for (String s : flinkSql.split(";")) {
            streamTableEnvironment.executeSql(s);
        }
    }
}

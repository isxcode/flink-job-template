package com.isxcode.acorn.job;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.EnvironmentSettings;
import org.apache.flink.table.api.bridge.java.StreamTableEnvironment;

public class Job {

    public static void main(String[] args) {

        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        EnvironmentSettings settings = EnvironmentSettings.newInstance().inStreamingMode().build();
        StreamTableEnvironment streamTableEnvironment = StreamTableEnvironment.create(env, settings);

        String flinkSql = "CREATE TABLE from_table(\n" +
                "    username STRING,\n" +
                "    age INT\n" +
                ") WITH (\n" +
                "    'connector'='jdbc',\n" +
                "    'url'='jdbc:mysql://127.0.0.1:30102/ispong_db',\n" +
                "    'driver'='com.mysql.cj.jdbc.Driver',\n" +
                "    'table-name'='flink1',\n" +
                "    'username'='ispong',\n" +
                "    'password'='ispong123'); \n" +
                "CREATE TABLE target_table(\n" +
                "    username STRING,\n" +
                "    age INT\n" +
                ") WITH (\n" +
                "    'connector'='jdbc',\n" +
                "    'url'='jdbc:mysql://127.0.0.1:30102/ispong_db',\n" +
                "    'driver'='com.mysql.cj.jdbc.Driver',\n" +
                "    'table-name'='flink2',\n" +
                "    'username'='ispong',\n" +
                "    'password'='ispong123'); \n" +
                "insert into target_table select * from from_table;";

        for (String s : flinkSql.split(";")) {
            streamTableEnvironment.executeSql(s);
        }
    }
}

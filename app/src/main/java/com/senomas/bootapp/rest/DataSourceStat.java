package com.senomas.bootapp.rest;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.argument.StructuredArguments;
import net.ttddyy.dsproxy.ExecutionInfo;
import net.ttddyy.dsproxy.QueryInfo;
import net.ttddyy.dsproxy.listener.QueryExecutionListener;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;

@Slf4j
public class DataSourceStat {
	
	public static DataSource proxyDataSource(DataSourceProperties dataSourceProperties) {
		DataSource oriDS = dataSourceProperties.initializeDataSourceBuilder().build();
		QueryExecutionListener listener = new QueryExecutionListener() {

			@Override
			public void beforeQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
			}

			@Override
			public void afterQuery(ExecutionInfo execInfo, List<QueryInfo> queryInfoList) {
				StringBuilder query = new StringBuilder();
				for (QueryInfo qi : queryInfoList) {
					if (query.length() > 0) query.append('\n');
					query.append(qi.getQuery());
				}
				log.info("{} {}", StructuredArguments.kv("query", query),
						StructuredArguments.kv("responsetime", execInfo.getElapsedTime()),
						StructuredArguments.kv("success", execInfo.isSuccess()),
						StructuredArguments.kv("batch", execInfo.isBatch()),
						StructuredArguments.kv("querySize", queryInfoList.size()),
						StructuredArguments.kv("batchSize", execInfo.getBatchSize()));
			}
		};
		return ProxyDataSourceBuilder.create(oriDS).listener(listener).build();
	}

}

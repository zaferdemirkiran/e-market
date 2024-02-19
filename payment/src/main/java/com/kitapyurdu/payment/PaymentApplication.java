package com.kitapyurdu.payment;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.kitapyurdu.payment.entity.Transaction;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Map;
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
public class PaymentApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
	}

	@Bean
	public Config hazelCastConfig() {
		ManagementCenterConfig config = new ManagementCenterConfig();
		return new Config().setManagementCenterConfig(config);
	}

	@Bean
	public HazelcastInstance hazelcastInstance(Config hazelCastConfig) {
		return Hazelcast.newHazelcastInstance(hazelCastConfig);
	}

	@Bean
	public Map<String, Transaction> transactionMap(@Qualifier("hazelcastInstance") HazelcastInstance hazelcastInstance) {
		return hazelcastInstance.getMap("transactionMap");
	}



}

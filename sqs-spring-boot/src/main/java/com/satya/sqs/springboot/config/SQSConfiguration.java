package com.satya.sqs.springboot.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.internal.StaticCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * File: SQSConfiguration.java Copyright 2021 Jaish Technologies. All rights reserved.
 *
 * <p>This software is the confidential and proprietary information of Jaish Technologies. You
 * shall not disclose such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Jaish Technologies.
 *
 * <p>Created on: 30/12/21, Created by: satyaveer.yadav, Version: 1.0, Project Name: sqs-spring-boot
 * Last updated by: satyaveer.yadav
 */
@Configuration
public class SQSConfiguration {

  @Value("${cloud.aws.credentials.access-key}")
  private String accessKey;

  @Value("${cloud.aws.credentials.secret-key}")
  private String secretKey;

  @Bean
  public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync) {
    return new QueueMessagingTemplate(amazonSQSAsync());
  }

  private AmazonSQSAsync amazonSQSAsync() {
    BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(accessKey, secretKey);
    return AmazonSQSAsyncClientBuilder.standard()
        .withRegion(Regions.US_EAST_2)
        .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
        .build();
  }
}

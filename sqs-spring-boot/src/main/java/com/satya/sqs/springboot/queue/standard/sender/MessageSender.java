package com.satya.sqs.springboot.queue.standard.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * File: MessageSender.java Copyright 2021 Jaish Technologies. All rights reserved.
 *
 * <p>This software is the confidential and proprietary information of Jaish Technologies. You
 * shall not disclose such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with Jaish Technologies.
 *
 * <p>Created on: 30/12/21, Created by: satyaveer.yadav, Version: 1.0, Project Name: sqs-spring-boot
 * Last updated by: satyaveer.yadav
 */
@RestController
public class MessageSender {

  @Autowired private QueueMessagingTemplate queueMessagingTemplate;

  @Value("${cloud.aws.end-point.uri}")
  private String endpoint;

  @GetMapping("/send/{message}")
  public void sendMessage(@PathVariable("message") String message) {
    Message<String> payload =
        MessageBuilder.withPayload(message).setHeader("sender", "Jaish Technologies").build();

    queueMessagingTemplate.send(endpoint, payload);
  }
}

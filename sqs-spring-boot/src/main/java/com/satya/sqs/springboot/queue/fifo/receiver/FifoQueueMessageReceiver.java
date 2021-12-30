package com.satya.sqs.springboot.queue.fifo.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Service;

/**
 * File: MessageReceiver.java Copyright 2021 Jaish Technologies. All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of Jaish Technologies.
 * You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into
 * with Jaish Technologies.
 * <p>
 * Created on: 30/12/21, Created by: satyaveer.yadav, Version: 1.0,  Project Name: sqs-spring-boot
 * Last updated by: satyaveer.yadav
 */
@Service
@Slf4j
public class FifoQueueMessageReceiver {

    @SqsListener(value = "my-fifo-queue.fifo", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void receive(String message) {
        log.info("Message Received {} ", message);
    }
}

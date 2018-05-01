package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.common.Message;

@Repository("messageRepository")
public interface MessageRepository  extends JpaRepository<Message, Long> {}

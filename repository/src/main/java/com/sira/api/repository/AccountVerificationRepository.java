package com.sira.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sira.model.stateschema.common.AccountVerification;

@Repository("accountVerificationRepository")
public interface AccountVerificationRepository  extends JpaRepository<AccountVerification, Long> {

}

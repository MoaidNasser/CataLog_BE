package com.cataas.cataas.repository;

import com.cataas.cataas.model.ActivationCode;
import com.cataas.cataas.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationCodeRepository extends JpaRepository<ActivationCode, Long> {
    ActivationCode findByUser(User user);
    ActivationCode findByCode(String code);
}

package com.sami.supershop.repository;

import com.sami.supershop.domain.UserInformation;
import org.springframework.data.repository.CrudRepository;

public interface UserInformationRepository extends CrudRepository<UserInformation, Long> {
}

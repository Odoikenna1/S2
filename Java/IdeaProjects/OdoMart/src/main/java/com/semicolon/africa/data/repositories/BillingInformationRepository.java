package com.semicolon.africa.data.repositories;
import com.semicolon.africa.data.domain.BillingInformation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillingInformationRepository extends MongoRepository<BillingInformation, String> {
    boolean existsByUserId(String userId);
}

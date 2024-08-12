package com.semicolon.africa.data.repositories;

import com.semicolon.africa.data.domain.Wallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WalletRepository extends MongoRepository<Wallet, String> {
}

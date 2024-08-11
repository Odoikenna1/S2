package com.semicolon.africa.data.models;

import com.semicolon.africa.data.domain.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="admin")
public class Admin extends User {
    private String id;
    private String brandName;
}

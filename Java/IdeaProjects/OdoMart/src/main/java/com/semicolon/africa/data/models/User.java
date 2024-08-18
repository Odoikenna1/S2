package com.semicolon.africa.data.models;

import com.semicolon.africa.data.domain.Gender;
import com.semicolon.africa.data.domain.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Setter
@Getter
@Document(collection="user")
public class User {
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private Gender gender;
    private String email;
    private String password;
    private Role role;
    private boolean isLoggedIn = false;
}

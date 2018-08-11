package com.thoughtworks.training.todoserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue
    public Integer id;
    public String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public String password;

}

package com.personal.freelance_manager.entity;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clients")

public class Client {

    @Id
    private String id;

    private String name;

    private String email;

    private String phone;

    private String address;

    @OneToMany
    @JoinColumn(name = "project_id", referencedColumnName = "id")
    private Project project;
}

package br.com.crudApi.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author maxjdev
 */

@Data
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
}
package br.com.crudApi.dto;

import lombok.Data;

/**
 * @Author maxjdev
 */

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
}

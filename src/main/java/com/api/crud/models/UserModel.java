package com.api.crud.models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class UserModel implements Serializable{
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String firstName;
    
    @Column
    private String lastName;
            
    @Column
    private String email;
    
}

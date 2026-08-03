package io.virinchi.springweb.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

//@Entity creates the table with provided name in database
//UserTbl -> user_tbl
@Entity
@Data
public class UserTbl {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Generated Value- Auto Increment
    private int id;
    private String username;
    private String password;


}

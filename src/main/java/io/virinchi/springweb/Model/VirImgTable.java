package io.virinchi.springweb.Model;

import jakarta.persistence.*;

@Entity
public class VirImgTable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Lob
@Column(columnDefinition = "MEDIUMBLOB")
private String image;

//BLOB is used for image management
//We will encode our image file into string using Base64 Encoder.
//However, mysql still wont be able to hold string coming from image file
//even after encoding as the string will be huge.
//Hence, as mysql can store humongous strings as BLOB- Binary Large Objects
//Our mysql column will use the idea of BLOB -> as above, @Lob.


}

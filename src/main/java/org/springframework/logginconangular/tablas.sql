/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  root
 * Created: 18/05/2016
 */

SHOW TABLES;
CREATE TABLE USUARIO(id_usuario Integer NOT NULL AUTO_INCREMENT,
nombre varchar(30),
email varchar(30),
password varchar(30),
PRIMARY KEY(id_usuario)
);
SELECT * FROM USUARIO;
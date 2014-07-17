Project MenuApp:
-----------------
mvn archetype:generate -DgroupId=com.sunRays -DartifactId=MenuApp -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false


Create DB & Table:
------------------
mysql -u root -p sunRays <Enter>

CREATE TABLE menuitems
(
menuid int NOT NULL AUTO_INCREMENT,
menuName varchar(255),
category varchar(255),
imageId varchar(255),
PRIMARY KEY ( menuid )
);




.
==========================================================================================================================
1.
http://localhost:8080/MenuApp/json/menuItems/listMenu
2.
http://localhost:8080/MenuApp/json/menuItems/get/{menuId}
http://localhost:8080/MenuApp/json/menuItems/get/1
3.
http://localhost:8080/MenuApp/json/menuItems/save
POST
Content-Type:application/json
{"category":"snax","menuId":1,"menuName":"breadroll","imageId":"xxx"}
.
==========================================================================================================================
<pre>===================================================================================================================
Prerequisites:
--------------
1. install git (from installousappstore).
2. MYSQL db
3. Maven
4. Rest Client (like for chrome: Chrome Web Store - Advanced REST client - Google)
====================================================================================================================
Project SetUP:
==============
1. Clone repo in local drive
----------------------------
cmd> git clone https://github.com/sunilkumargupta/MenuApp

2. Create DB & Table:
---------------------

1. mysql -u root -p  <Enter>

2. CREATE DATABASE sunRays  <Enter>

3. connect sunRays; <Enter>

4.
CREATE TABLE menuitems
(
menuid int NOT NULL AUTO_INCREMENT,
menuName varchar(255),
category varchar(255),
imageId varchar(255),
PRIMARY KEY ( menuid )
);

3. Run Maven build
------------------
cmd/MenuApp> mvn clean install

4. Run on Server
----------------
cmd/MenuApp> mvn tomcat:run
above will try to launch tomcat on default port 8080.If default port is already busy then use below command to use different port
cmd/MenuApp> mvn tomcat:run -Dmaven.tomcat.port <any unused port> 
e.g 
cmd/MenuApp> mvn tomcat:run -Dmaven.tomcat.port 9091
==========================================================================================================================

==========================================================================================================================
1.
http://localhost:9091/MenuApp/json/menuItems/listMenu
2.
http://localhost:9091/MenuApp/json/menuItems/get/{menuId}
http://localhost:9091/MenuApp/json/menuItems/get/1
3.
http://localhost:9091/MenuApp/json/menuItems/save
method: POST
Content-Type:  application/json
payload: {"category":"snax","menuName":"breadroll","imageId":"xxx"}
========================================================================================================================</pre>

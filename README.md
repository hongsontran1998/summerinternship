# summerinternship 2019
<h3><i>My Spring boot learning in the summer 2019</i></h3>
<h6>#Modules which i researched</h6>
<ul>
    <li>Spring boot web</li>
    <li>Spring data jpa (MySql)</li>
    <li>Spring hibernate module</li>
    <li>Spring data mongodb (Mongodb)</li>
    <li>Spring security</li>
    <li>Spring task schedule</li>
    <li>Spring thymeleaf template engine</li>
    <li>Spring thymeleaf layout</li>
    <li>Spring email sending (running thread in queue, velocity template)</li>
    <li>Java project lombok</li>
</ul>

<h6>#Start mogodb server<h6>
<p>
mongod --dbpath your_db_location<br>
example: E:\InstallSoftware\MongoDB\DULIEU
</p>

<h6>#Application properties</h6>
<p>
#email<br>
spring.mail.username=your_email_address
spring.mail.password=your_email_password
<br>#mysql<br>
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useUnicode=yes&characterEncoding=UTF-8
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
<br>#mongodb<br>
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=your_database_name
</p>

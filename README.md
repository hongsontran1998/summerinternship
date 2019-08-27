# The Summer 2019
<h3><i>My Spring boot learning in the summer 2019</i></h3>
<h6>#Modules which i researched</h6>
<ul>
    <li>Spring boot web
        <ul>
            <li>application.properties configuration - make bean</li>
            <li>Java code confirguration - @Configuration - @ConfigurationProperties</li>
        </ul>
    </li>
    <li>Spring interceptor</li>
    <li>Spring data jpa (MySql)</li>
    <li>Spring data mongodb (Mongodb)</li>
        <li>Spring MongodbTemplate</li>
        <li>Mongodb pure manupulating</li>
    <li>Spring boot hibernate & data jpa module
        <ul>
            <li>Entity</li>
            <li>Hql query</li>
            <li>Jpql query</li>
            <li>CriteriaBuilder query</li>
            <li>Composable repositories.</li>
        </ul>
    </li>
    <li>Spring security
        <ul>
            <li>Authentication</li>
            <li>Authorization</li>
            <li>Password encoding</li>
            <li>Csrf</li>
            <li>Cors</li>
        </ul>
    </li>
    <li>Spring task schedule</li>
    <li>Spring file uploading - file downloading</li>
    <li>Spring thymeleaf template engine
        <ul>
            <li>Fragment</li>
            <li>Fragment as a function</li>
            <li>Master layout, extending layout</li>
            <li>Thymeleaf - spring security - taglibs</li>
        </ul>
    </li>
    <li>Spring email sending
        <ul>
            <li>Email sending in thread</li>
            <li>Velocity template</li>
            <li>Freemarker template</li>
        </ul>
    </li>
    <li>Java api for excel - Apache POI library</li>
    <li>Java project lombok</li>
    <li>Intellij Idea setting, using</li>
</ul>

<h6>#Plugins setting</h6>
<p>
Project lombok:<br>
Intellij: https://projectlombok.org/setup/intellij<br>
Eclipse, Spring Tools Suite: https://projectlombok.org/setup/eclipse 
</p>

<h6>#Mogodb server starting</h6>
<p>
cd E:\MongoDB\Server\4.0\bin (ignore this step if you created the mongodb's environment variable)<br>
mongod --dbpath your_db_location or mongod<br>
example: mongod --dppath E:\MongoDB\Data<br>
mongodb connection: mongo
</p>

<h6>#Application properties</h6>
<p>
#email<br>
spring.mail.username=your_email_address<br>
spring.mail.password=your_email_password
<br>#mysql<br>
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name?useUnicode=yes&characterEncoding=UTF-8
spring.datasource.username=your_database_username<br>
spring.datasource.password=your_database_password
<br>#mongodb<br>
spring.data.mongodb.host=localhost<br>
spring.data.mongodb.port=27017<br>
spring.data.mongodb.database=your_database_name<br>
</p>

<h6>#Fixing port already use problem</h6>
<p>
change port: server.port=8081 => server.port=another_port<br>
if after port changing, still given errors: open task manager and kill JavaTM program
</p>

<h6>#Tips for using Intellij Idea IDE</h6>
<h6>#Tips for using Eclipse IDE</h6>

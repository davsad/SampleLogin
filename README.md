This sample project demonstrates a login/register/logout functionality of a 3 tier web application.

Tech. included within project:
 1. Maven
 2. HTML/CSS/JS/AJAX/Cookies
 3. REST (jax-rs)
 4. JEE (EJB, JPA, CDI)

Take note: Within this sample, maven modules are coupled together as there was a time restriction create this sample.

Database used by our persistence is H2 so it recommended to change this accordingly.

Application Server: Jboss EAP/AS 6.4 onwards or wildfly equivalent, can run in standalone mode using default standalone.xml configuration or whatever JEE compliant application server of your choice.

Project structure:
 1. SampleLogin-jar hold the interfaces and DTO classes.
 2. SampleLogin-ejb contains the business logic and stateless beans, from here we will interface with peristence layer.
 3. SampleLogin-jpa acts as the persistence layer/provider, contains jpa implementations.
 4. SampleLogin-war contains the html/css/js files (src/webapp/*) and also the REST implementation classes.
 5. SampleLogin-ear the ear file to encaplusate artifacts from previously mention modules

[中文](https://github.com/entropyfeng/simple-auth/blob/master/README.ZH.md) | [English](https://github.com/entropyfeng/simple-auth/blob/master/README.md)
# simple-auth
a simple authenticate and authority framework based in SpringBoot Framework
### required
* redis
### install and quick start
    git clone https://github.com/entropyfeng/simple-auth.git
    mvn install 
    
    add this dependency to your SpringBoot project
    <dependency>
      <groupId>com.github.entropyfeng</groupId>
      <artifactId>simple-auth</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
    
    add your redis configuration or take default configuration--
    according to spring-boot-starter-data-redis dependency ,this framework will connect localhost's 6379 port    

### support functions
your can add this annotation to your controller,and this framework will check this request whether has the permission to access this url . 
#### WARNING
add multi annotations to same method,will cause undefined result
    
* `@GetAuth(value)`
* `@PostAuth(value)`
* `@DeleteAuth(value)`
* `@PutAuth(value)`
* `@PatchAuth(Auth)`
* `@AuthTokenRequired(value="",method=org.springframework.web.bind.annotation.RequestMethod")` 
    
### demo
  ```java
    @RestController
    public class YourController {

    @GetAuth("/your define permission")
    @GetMapping("/login")
    public void yourFunction(){
    
     
       }
    }
``` 


    


[中文](https://github.com/entropyfeng/simple-auth/README.ZH.md) | [English](https://github.com/entropyfeng/simple-auth/README.md)
# simple-auth
一个基于SpringBoot的简单认证、授权框架
### 基本需求
* redis
### 安装及快速开始
    git clone https://github.com/entropyfeng/simple-auth.git
    mvn install 
    
    在你的项目中添加依赖
    <dependency>
      <groupId>com.github.entropyfeng</groupId>
      <artifactId>simple-auth</artifactId>
      <version>0.0.1-SNAPSHOT</version>
    </dependency>
    你可以在你的配置文件中为Redis添加默认配置，否则该框架会自动连接本地的6379端口

### 支持功能
在Controller层的方法上，你可以添加以下任意一种验证方式，该框架会自动确定该次请求是否具有访问此url的相关权限

#### 注意
在方法上添加多个以下注解会产出未定义的行为
* `@GetAuth(value)`
* `@PostAuth(value)`
* `@DeleteAuth(value)`
* `@PutAuth(value)`
* `@PatchAuth(Auth)`
* `@AuthTokenRequired(value="",method=org.springframework.web.bind.annotation.RequestMethod")` 
       
    
### Demo
*  ```java
    @RestController
    public class YourController {

    @GetAuth("/你自定义的权限信息")
    @GetMapping("/login")
    public void yourFunction(){
    
     
       }
    }
    
    ```


    


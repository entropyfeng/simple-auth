package com.github.entropyfeng.simpleauth.data.to;

/**
 * @author entropyfeng
 * @date 2019/7/4 12:01
 */
import java.util.LinkedList;
import java.util.List;

/**
 * @author entryfeng
 * role and resource entity class
 */
@SuppressWarnings("unused")
public class RoleAndResource {
    private String roleName;
    private List<ResourceAndMethod> resourceAndMethods=new LinkedList<>();

    public void addEntity(String resource,String method){
        resourceAndMethods.add(new ResourceAndMethod(resource,method));
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<ResourceAndMethod> getResourceAndMethods() {
        return resourceAndMethods;
    }

    public void setResourceAndMethods(List<ResourceAndMethod> resourceAndMethods) {
        this.resourceAndMethods = resourceAndMethods;
    }

    public class ResourceAndMethod{
        String resource;
        String method;

        public ResourceAndMethod(String resource, String method) {
            this.resource = resource;
            this.method = method;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }
    }
}
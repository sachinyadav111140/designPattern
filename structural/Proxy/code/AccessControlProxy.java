package structural.Proxy.code;

public class AccessControlProxy implements AccessControl{
    
    AccessControl accessControl;
    String accessLevel;
    public AccessControlProxy(String accessLevel) {
        this.accessLevel = accessLevel;
        accessControl =new AccessControlImpl();
    }
    @Override
    public void accessResource() {
        if(accessLevel.equals("admin")) {
            accessControl.accessResource();
        }else {
            System.out.println("You do not have access to this resource");
        }   
    }
}

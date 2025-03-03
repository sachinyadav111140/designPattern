package structural.Proxy.code;

public class Client {
    public static void main(String[] args) {
        AccessControl accessControl = new AccessControlProxy("admin");
        accessControl.accessResource();
        AccessControl accessControl2 = new AccessControlProxy("user");
        accessControl2.accessResource();
        
    }
}

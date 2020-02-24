import HelloApp.Hello;
import HelloApp.HelloHelper;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.awt.Graphics;
import java.util.Properties;


public class HelloApplet extends java.applet.Applet {
    String message = "";

    public void init() {
        try {
            String port = "1099";
            System.out.println("Using ORBInitialPort = " + port);

            // specify the port number by including it in the property list
            Properties props = new Properties();
            props.put("org.omg.CORBA.ORBInitialPort", port);

            ORB orb = ORB.init(this, props);  

            // get the root naming context
            org.omg.CORBA.Object objRef = 
                        orb.resolve_initial_references("NameService");
            NamingContext ncRef = NamingContextHelper.narrow(objRef);

            // resolve the Object Reference in Naming
            NameComponent nc = new NameComponent("Hello", "");
            NameComponent path[] = {nc};
            Hello helloRef = HelloHelper.narrow(ncRef.resolve(path));

            // call the Hello server object and print results
            message = helloRef.sayHello();
 
        } catch (Exception e) {
            System.out.println("HelloApplet exception: " + e.getMessage());
            e.printStackTrace(System.out);
        }
    }
 

    public void paint(Graphics g) 
    {
        g.drawString(message, 25, 20);
}
}
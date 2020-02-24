import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class SumClient {

	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String url="rmi://localhost:1099/SumObj";
		SumInterface robj=(SumInterface)Naming.lookup(url);
		System.out.println("Got remote object");
		int i=robj.sum(10, 20);
		System.out.println("Sum="+i);

	}

}

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class SumServer extends UnicastRemoteObject implements SumInterface {
	public SumServer() throws RemoteException
	{
		super();
	}
	public int sum(int a,int b)throws RemoteException{
		return a+b;
	}

	public static void main(String[] args) throws RemoteException,MalformedURLException,AlreadyBoundException{
		SumServer remoteobj=new SumServer();
		LocateRegistry.createRegistry(1099);
		Naming.bind("rmi://localhost:1099/SumObj", remoteobj);
		System.out.println("Server is waiting");
		
		
	

	}

}


import java.io.PrintWriter;
import java.util.List;

public class User {
	private String name;
	private String pass;
	private PrintWriter printer;
	
	public User(){
		name = "Anon";
		pass = "";
	}

	public User(String n){
		name = n;
		pass = "";
	}
	
	public User(String n, String p){
		name = n;
		pass = p;
	}
	
		public User(String n, String p, PrintWriter out){
		name = n;
		pass = p;
		printer = out;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
		public PrintWriter getPrinter() {
		return printer;
	}
	public void setPrinter(PrintWriter printer) {
		this.printer = printer;
	}
	
	public int containedBy(List<User> list){
		for(User user: list){
			if(user.getName().equalsIgnoreCase(this.name)){
				if(user.getPass().equals(this.pass)){
					return 1;
				}
				else{
					return -1;
				}
			}
		}
		
		return 0;
	}
	
	public void removeFrom(List<User> list){
		for(User user: list){
			if(user.getName().equalsIgnoreCase(this.name)){
				list.remove(user);
			}
		}
	}

	public static User find(String name, List<User> list){
		for(User user: list){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
}

import java.io.Console;



public class Main {

	public static void main(String[] args) {
		Database d = new Database();
		Provider p = new Provider("Octavius",123456,"345 anus avenue","Tuscaloosa","AL","35404");
		d.addProvider(p);
		Member m = new Member("Dillon",356661,"417 Prince Acres","Tuscaloosa","AL","35404");
		Member o = new Member("Matt",236544,"417 Prince Acres","Tuscaloosa","AL","35404");
		d.addMember(m);
		d.addMember(o);
		Member mem = d.getMember(o.getNumber());
		System.out.println(mem.getName());
		System.out.println(d.getProviders());
		
	}

}
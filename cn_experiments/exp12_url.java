import java.net.URI;
import java.net.URISyntaxException;
import java.net.*;

public class url {
	    public static void main(String[] args) {
	        String url = "https://www.youtube.com/watch?v=RNmz_a468Og";
	        try {
	            URI parsed = new URI(url);
	            String protocol = parsed.getScheme();
	            String domain = parsed.getHost();
	            String path = parsed.getPath();
	            String query = parsed.getQuery();

	            System.out.println("Protocol: " + protocol);
	            System.out.println("Domain: " + domain);
	            System.out.println("Path: " + path);
	            System.out.println("Query: " + query);
	        } 
			catch (URISyntaxException e) {
	            System.out.println("Invalid URL: " + e.getMessage());
	    }
	}
}
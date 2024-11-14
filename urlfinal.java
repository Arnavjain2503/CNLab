import java.util.*;

public class url1 {
    private String protocol;
    private String domain;
    private String path;
    private String query;
    // Constructor to parse the URL
    public url1(String url) {
        parse(url);
    }

    // Method to parse the given URL string
    private void parse(String url) {
        int protocolEndIndex = url.indexOf("://");
        if (protocolEndIndex != -1) {
            protocol = url.substring(0, protocolEndIndex); // Extract scheme
            url = url.substring(protocolEndIndex + 3);   // Remove scheme from the URL string
        }

        int domainEndIndex = url.indexOf('/');
        if (domainEndIndex != -1) {
            domain = url.substring(0, domainEndIndex);     // Extract host
            url = url.substring(domainEndIndex);         // Remove host from the URL string
        } else {
            domain = url;  // If there's no path, the remaining part is the host
            url = "";
        }

        int queryStartIndex = url.indexOf('?');
        if (queryStartIndex != -1) {
            path = url.substring(0, queryStartIndex);  // Extract path
            query = url.substring(queryStartIndex + 1); // Extract query
        } else {
            path = url; // If there's no query, the remaining part is the path
        }
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDomain() {
        return domain;
    }

    public String getPath() {
        return path;
    }

    public String getQuery() {
        return query;
    }

    // Main method for testing
    public static void main(String[] args) {
        String url = "https://www.youtube.com/watch?v=RNmz_a468Og";
        url1 parser = new url1(url);

        System.out.println("Protocol: " + parser.getProtocol());
        System.out.println("Host: " + parser.getDomain());
        System.out.println("Path: " + parser.getPath());
        System.out.println("Query: " + parser.getQuery());
    }
}

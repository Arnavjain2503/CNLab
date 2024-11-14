import java.util.*;

public class url1 {
    private String scheme;
    private String host;
    private String path;
    private String query;

    // Constructor to parse the URL
    public url1(String url) {
        parse(url);
    }

    // Method to parse the given URL string
    private void parse(String url) {
        int schemeEndIndex = url.indexOf("://");
        if (schemeEndIndex != -1) {
            scheme = url.substring(0, schemeEndIndex); // Extract scheme
            url = url.substring(schemeEndIndex + 3);   // Remove scheme from the URL string
        }

        int hostEndIndex = url.indexOf('/');
        if (hostEndIndex != -1) {
            host = url.substring(0, hostEndIndex);     // Extract host
            url = url.substring(hostEndIndex);         // Remove host from the URL string
        } else {
            host = url;  // If there's no path, the remaining part is the host
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

    public String getScheme() {
        return scheme;
    }

    public String getHost() {
        return host;
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

        System.out.println("Scheme: " + parser.getScheme());
        System.out.println("Host: " + parser.getHost());
        System.out.println("Path: " + parser.getPath());
        System.out.println("Query: " + parser.getQuery());
    }
}

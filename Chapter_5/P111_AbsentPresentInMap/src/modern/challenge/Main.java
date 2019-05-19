package modern.challenge;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws UnknownHostException, IOException {

        String address = InetAddress.getLocalHost().getHostAddress();

        System.out.println("Use Map.computeIfPresent():");
        System.out.println("---------------------------");

        Map<String, String> map1 = new HashMap<>();

        map1.put("postgresql", "127.0.0.1");
        map1.put("mysql", "192.168.0.50");

        System.out.println("\nThe initial map: " + map1);

        BiFunction<String, String, String> jdbcUrl1
                = (k, v) -> "jdbc:" + k + "://" + v + "/customers_db";

        String mySqlJdbcUrl1 = map1.computeIfPresent("mysql", jdbcUrl1);
        System.out.println("MySQL JDBC URL: " + mySqlJdbcUrl1);

        System.out.println("The resulted map: " + map1);

        System.out.println("\nUse Map.computeIfAbsent():");
        System.out.println("---------------------------");

        Map<String, String> map2 = new HashMap<>();

        map2.put("postgresql", "jdbc:postgresql://127.0.0.1/customers_db");
        map2.put("mysql", "jdbc:mysql://192.168.0.50/customers_db");

        System.out.println("The initial map: " + map2);

        Function<String, String> jdbcUrl2
                = k -> k + "://" + address + "/customers_db";

        String mongodbJdbcUrl = map2.computeIfAbsent("mongodb", jdbcUrl2);
        System.out.println("MongoDB JDBC URL: " + mongodbJdbcUrl);

        System.out.println("The resulted map: " + map2);

        System.out.println("\nUse Map.compute():");
        System.out.println("--------------------");

        Map<String, String> map3 = new HashMap<>();

        map3.put("postgresql", "127.0.0.1");
        map3.put("mysql", "192.168.0.50");

        System.out.println("The initial map: " + map3);

        BiFunction<String, String, String> jdbcUrl3 = (k, v) -> "jdbc:" + k + "://"
                + ((v == null) ? address : v) + "/customers_db";

        String mysqlJdbcUrl = map3.compute("mysql", jdbcUrl3);
        String derbyJdbcUrl = map3.compute("derby", jdbcUrl3);

        System.out.println("MySQL JDBC URL: " + mysqlJdbcUrl);
        System.out.println("Derby JDBC URL: " + derbyJdbcUrl);

        System.out.println("The resulted map: " + map3);

        System.out.println("\nUse Map.merge():");
        System.out.println("-------------------");

        Map<String, String> map4 = new HashMap<>();

        map4.put("postgresql", "9.6.1 ");
        map4.put("mysql", "5.1 5.2 5.6 ");

        System.out.println("The initial map: " + map4);

        BiFunction<String, String, String> jdbcUrl4 = String::concat;

        String mySqlVersion1 = map4.merge("mysql", "8.0 ", jdbcUrl4);
        System.out.println("MySQL versions (added 8.0): " + mySqlVersion1);
        String mySqlVersion2 = map4.merge("mysql", "9.0 ", jdbcUrl4);
        System.out.println("MySQL versions (added 9.0): " + mySqlVersion2);

        String derbyVersion = map4.merge("derby", "10.11.1.1 ", jdbcUrl4);
        System.out.println("Derby versions (added 10.11.1.1): " + derbyVersion);

        System.out.println("The resulted map: " + map4);

        System.out.println("\nUse Map.putIfAbsent():");
        System.out.println("------------------------");

        Map<Integer, String> map5 = new HashMap<>();

        map5.put(1, "postgresql");
        map5.put(2, "mysql");
        map5.put(3, null);

        System.out.println("The initial map: " + map5);

        String v1 = map5.putIfAbsent(1, "derby");
        String v2 = map5.putIfAbsent(3, "derby");
        String v3 = map5.putIfAbsent(4, "cassandra");

        System.out.println("v1: " + v1);
        System.out.println("v2: " + v2);
        System.out.println("v3: " + v3);

        System.out.println("The resulted map: " + map5);
    }

}

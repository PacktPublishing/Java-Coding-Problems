package modern.challenge;

import java.lang.reflect.Proxy;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws MalformedURLException {

        CountingInvocationHandler invocationHandler = new CountingInvocationHandler(new ArrayList<>());

        List<String> listProxy = (List<String>) Proxy.newProxyInstance(
                List.class.getClassLoader(), new Class[]{List.class},
                invocationHandler);

        listProxy.add("Adda");
        listProxy.add("Mark");
        listProxy.add("John");
        listProxy.remove("Adda");
        listProxy.add("Marcel");
        listProxy.remove("Mark");
        listProxy.add(0, "Akiuy");

        System.out.println(invocationHandler.countOf("add"));
        System.out.println();
        System.out.println(invocationHandler.countOf("remove"));
    }

}

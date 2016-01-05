import java.io.IOException;
import java.util.Map;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.VirtualMachineManager;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.jdi.VirtualMachine;

public class Connections {
    public VirtualMachine connect(String host,int port) throws IOException {
        String strPort = Integer.toString(port);
        AttachingConnector connector = getConnector();
        try {
            VirtualMachine vm = connect(connector,host, strPort);
            return vm;
        } catch (IllegalConnectorArgumentsException e) {
            throw new IllegalStateException(e);
        }
    }
//
    private AttachingConnector getConnector() {
        VirtualMachineManager vmManager = Bootstrap.virtualMachineManager();

        for (Connector connector : vmManager.attachingConnectors()) {
            if("com.sun.jdi.SocketAttach".equals(connector.name()))
                return (AttachingConnector) connector;
        }
        throw new IllegalStateException();
    }

    private VirtualMachine connect(AttachingConnector connector,String host,String port)
            throws IllegalConnectorArgumentsException, IOException {

        Map<String, Connector.Argument> args = connector.defaultArguments();
        Connector.Argument portArg = args.get("port");
        portArg.setValue(port);
        Connector.Argument addressArg = args.get("hostname");
        addressArg.setValue(host);

        return connector.attach(args);
    }
}

package design.pattern.structural.facade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * facade design patten ot everywhere, not detailed description
 * @author Ming
 * @date 2019-12-05
 */
public class FacadeDesign implements Serializable {

    private final String url;
    private final String username;
    private final String password;

    public FacadeDesign(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void getConnectionConnection(String type) throws ClassNotFoundException {
        switch (type){
            case "MYSQL":
                Class.forName(Driver.MYSQL.driverClass);
                break;
            case "ORACLE":
                Class.forName(Driver.ORACLE.driverClass);
                break;
            default:
                System.out.println("error error!!");
        }
    }

    public enum Driver{

        /**
         * MYSQL driverUrl
         */
        MYSQL("com.mysql.jdbc.Driver"),

        /**
         * ORACLE driverUrl
         */
        ORACLE("com.mysql.jdbc.Driver");

        private String driverClass;


        Driver(String driverClass){
            this.driverClass = driverClass;
        }
    }

}

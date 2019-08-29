package restaurant_cafe.util;

import java.util.ResourceBundle;

public class PropertyLoader {

	public static String getProperty(String name) {
        ResourceBundle resource = ResourceBundle.getBundle("application");
        return resource.getString(name);
    }
}

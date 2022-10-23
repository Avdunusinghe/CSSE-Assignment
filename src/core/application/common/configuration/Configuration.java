package core.application.common.configuration;
/*
 * Use to load the data from properties
 *
 * @throws IOException
 * 			-Exception produced by failed or interrupted I/O operations
 *
 */

import core.application.common.ApplicationConstants;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Configuration {
    public static final Properties properties = new Properties();
    public static final Logger log = Logger.getLogger(Configuration.class.getName());

    static {

        try {
            properties.load(Configuration.class.getResourceAsStream(ApplicationConstants.PROPERTY_FILE));

        } catch (IOException exception) {
            log.log(Level.SEVERE, exception.getMessage());
        }
    }
}

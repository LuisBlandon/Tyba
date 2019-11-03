package setup;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class ConfigureProperties {

	public Properties props;
	PrintWriter out;
	File hostConfigFile;
	File keycloakConfigFile;

	public ConfigureProperties() {
		props = new Properties();
	}

	/*
	 * Method to retrieve maven properties
	 */
	public static String getMavenProperty(String propertyName) {

		Properties props = new Properties();
		try {
			InputStream inputStream = new FileInputStream("env.properties");
			props.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return props.getProperty(propertyName);
	}
}

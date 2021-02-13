package env;

import java.io.File;

/**
 * 
 * This is to handle application properties instance
 * and handle the resources(/test/resources) path
 *
 */
public enum Environment {
	INSTANCE;

	private ApplicationProperties appProps;

	private String resourcePath;

	private Environment() {

	}

	public ApplicationProperties getApplicationProperties() {
		if (appProps == null) {
			appProps = new ApplicationProperties();
			appProps.loadProperties();
		}

		return appProps;
	}

	public String getResourcePath() {
		if (resourcePath == null) {
			String userDir = System.getProperty("user.dir");
			String projectResourcesPath = userDir.concat("/src/test/resources");
			File f = new File(projectResourcesPath);
			if (f.exists()) {
				resourcePath = projectResourcesPath;
			} else {
				resourcePath = userDir;
			}
		}

		return resourcePath;
	}
}
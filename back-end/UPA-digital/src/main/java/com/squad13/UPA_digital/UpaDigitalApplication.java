/**
 * UpaDigitalApplication is the main entry point for the UPA Digital application.
 * This class is responsible for bootstrapping the Spring Boot application.
 *
 * <h2>Usage</h2>
 * To run the application, execute the main method. This will start the embedded
 * server and deploy the application.
 *
 * <pre>
 * {@code
 * public static void main(String[] args) {
 *     SpringApplication.run(UpaDigitalApplication.class, args);
 * }
 * }
 * </pre>
 *
 * <h2>Annotations</h2>
 * <ul>
 *   <li>@SpringBootApplication: This is a convenience annotation that adds all of the following:
 *     <ul>
 *       <li>@Configuration: Tags the class as a source of bean definitions for the application context.</li>
 *       <li>@EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.</li>
 *       <li>@ComponentScan: Tells Spring to look for other components, configurations, and services in the com/squad13/UPA_digital package, allowing it to find the controllers.</li>
 *     </ul>
 *   </li>
 * </ul>
 *
 * <h2>Dependencies</h2>
 * Ensure that you have the following dependencies in your build configuration:
 * <ul>
 *   <li>spring-boot-starter</li>
 *   <li>spring-boot-starter-web</li>
 *   <li>spring-boot-starter-data-jpa</li>
 *   <li>spring-boot-starter-security (if using Spring Security)</li>
 * </ul>
 *
 * <h2>Configuration</h2>
 * Application-specific configurations can be placed in the application.properties or application.yml file.
 *
 * <h2>Running the Application</h2>
 * You can run the application from the command line using:
 * <pre>
 * {@code
 * mvn spring-boot:run
 * }
 * </pre>
 * or by running the main method in your IDE.
 *
 * <h2>Packaging</h2>
 * To package the application as a JAR file, use:
 * <pre>
 * {@code
 * mvn clean package
 * }
 * </pre>
 * The JAR file will be created in the target directory.
 */
package com.squad13.UPA_digital;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UpaDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpaDigitalApplication.class, args);
	}
}

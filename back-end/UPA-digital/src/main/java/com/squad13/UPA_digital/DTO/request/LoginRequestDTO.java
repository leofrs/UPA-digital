/**
 * The LoginRequestDTO class is a Data Transfer Object (DTO) used to encapsulate
 * the data required for a login request. This class is part of the request package
 * in the UPA-digital project.
 * 
 * <p>It uses Lombok annotations to automatically generate getter and setter methods
 * for its fields, reducing boilerplate code.</p>
 * 
 * <h2>Fields:</h2>
 * <ul>
 *   <li><b>identifier</b>: A String representing the user's identifier, which could be a username, email, or any other unique identifier.</li>
 *   <li><b>password</b>: A String representing the user's password.</li>
 * </ul>
 * 
 * <h2>Usage Example:</h2>
 * <pre>{@code
 * LoginRequestDTO loginRequest = new LoginRequestDTO();
 * loginRequest.setIdentifier("user@example.com");
 * loginRequest.setPassword("securePassword123");
 * 
 * String identifier = loginRequest.getIdentifier();
 * String password = loginRequest.getPassword();
 * }</pre>
 * 
 * <p>This class is typically used in the context of handling login requests in a web application.
 * It can be serialized to JSON and sent in the body of an HTTP POST request to an authentication endpoint.</p>
 * 
 * <h2>Dependencies:</h2>
 * <ul>
 *   <li>Lombok library for @Getter and @Setter annotations.</li>
 * </ul>
 * 
 * <p>Make sure to include Lombok in your project's dependencies to use this class effectively.</p>
 */
package com.squad13.UPA_digital.DTO.request;

import lombok.Getter;



@Getter
public class LoginRequestDTO {

    private String email;
    private String password;

}

/**
 * 
 */
package co.com.atenea.adminactivos.exceptions;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanal
 *
 */
@Getter
@Setter
public class ApiResponseMessage {
    private int statusCode;
    private String message;

    public ApiResponseMessage(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}

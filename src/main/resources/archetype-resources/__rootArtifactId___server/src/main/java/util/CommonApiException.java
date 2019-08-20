#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Copperfield @ 2018/5/29 10:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonApiException extends RuntimeException {
    
    private String errorCode;
    private String extraInfo;
    private String rootError;
    
    public CommonApiException(String errorCode) {
        this.errorCode = errorCode;
    }

    public CommonApiException(String errorCode, String extraInfo) {
        this.errorCode = errorCode;
        this.extraInfo = extraInfo;
    }
    
    public CommonApiException(String errorCode, Exception e) {
        this.errorCode = errorCode;
        this.rootError = getRootCause(e);
    }
    
    private String getRootCause(Exception e) {
        Throwable tmp = e.getCause();
        while (tmp.getCause() != null) {
            tmp = tmp.getCause();
        }
        return tmp.getMessage();
    }
}

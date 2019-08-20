#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import ${package}.bean.resp.ErrorResp;
import ${package}.bean.resp.GenericResp;
import org.springframework.http.HttpStatus;

/**
 * Created by copperfield @ 2019-07-07 17:15
 */
public class ResponseKit {
    
    public static GenericResp buildOKResp(Object data, String message) {
        return GenericResp.builder()
                          .status(HttpStatus.OK.value())
                          .data(data)
                          .message(message)
                          .build();
    }
    
    static ErrorResp buildErrorResp(CommonApiException e) {
        return PropertiesKit.errorPropertyParser(e);
    }
}

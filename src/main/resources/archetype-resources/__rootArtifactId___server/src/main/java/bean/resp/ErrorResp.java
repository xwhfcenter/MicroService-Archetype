#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.bean.resp;

import lombok.Builder;
import lombok.Data;

/**
 * Created by copperfield @ 2019-07-25 15:35
 */
@Data
@Builder
public class ErrorResp {
    private int httpCode;
    private String message;
}

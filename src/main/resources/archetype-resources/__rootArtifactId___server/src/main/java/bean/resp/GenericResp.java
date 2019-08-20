#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.bean.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by copperfield @ 2019-07-07 15:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GenericResp {
    private int status;
    private String message;
    private Object data;
}

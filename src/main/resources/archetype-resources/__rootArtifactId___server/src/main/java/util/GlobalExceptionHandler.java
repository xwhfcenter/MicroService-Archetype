#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import ${package}.bean.resp.ErrorResp;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by copperfield @ 2019-01-09 10:27
 */
@ControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
@Slf4j
public class GlobalExceptionHandler {
    
    @ExceptionHandler({CommonApiException.class})
    @ResponseBody
    public ErrorResp process(CommonApiException ex, HttpServletRequest request) {
    
        
        log.error(ExceptionUtils.getStackTrace(ex));
    
        return ResponseKit.buildErrorResp(ex);
    }
}

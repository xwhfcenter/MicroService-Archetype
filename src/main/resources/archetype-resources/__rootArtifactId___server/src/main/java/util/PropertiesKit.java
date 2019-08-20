#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;


import ${package}.bean.resp.ErrorResp;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Copperfield @ 2018/5/29 11:01
 */
@Slf4j
public class PropertiesKit {
	
	private final static Properties props = new Properties();
	
	public static void load(String path) {
		
		try (InputStream in = PropertiesKit.class.getClassLoader().getResourceAsStream(path)) {
			props.load(in);
			log.info("Properties is = {}", props.toString());
		} catch (IOException e) {
			log.error("Load properties from {} failed.", path, e);
			throw new RuntimeException("Load properties file failed.", e);
		}
	}
	
	static ErrorResp errorPropertyParser(CommonApiException e) {
		String errorCode = e.getErrorCode();
		String property = props.getProperty(errorCode);
		
		String[] errorProp = property.split(";");
		String message = errorProp[1];
		if (e.getExtraInfo() != null) {
			message = message.replace("{}", e.getRootError());
		}
		if (e.getRootError() != null) {
			message = message.replace("{}", e.getRootError());
		}
		
		return ErrorResp.builder()
					    .httpCode(Integer.parseInt(errorProp[0]))
					    .message(message)
					    .build();
	}
}

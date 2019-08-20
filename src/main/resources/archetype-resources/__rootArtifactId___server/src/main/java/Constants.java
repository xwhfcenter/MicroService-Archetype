#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

/**
 * Created by copperfield @ 2019-07-07 15:42
 */
public class Constants {
    private static final String SERVICE_NAME = "${parentArtifactId}";
    private static final String VERSION = "v1";
    private static final String BASE_PATH = "/" + SERVICE_NAME + "/api";
    
    public static final String PATH_WITH_VERSION = BASE_PATH + "/" + VERSION;
}

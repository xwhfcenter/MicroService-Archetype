#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import com.google.common.base.Enums;
import com.google.common.collect.Maps;
import ma.glasnost.orika.metadata.Type;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by copperfield @ 2019-07-24 17:34
 */
public interface CommonEnum {
    
    Integer getValue();
    static <T extends CommonEnum> T fromValue(Type<T> enumType, Integer value) {
        for (T object : enumType.getRawType().getEnumConstants()) {
            if (Objects.equals(value, object.getValue()))
                return object;
        }
        return null;
    }
}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

/**
 * Created by copperfield @ 2019-08-13 14:15
 */
public class EnumConverter<E extends CommonEnum> extends BidirectionalConverter<E, Integer> {
    
    @Override
    public Integer convertTo(E e, Type<Integer> type, MappingContext mappingContext) {
        return e.getValue();
    }
    
    @Override
    public E convertFrom(Integer integer, Type<E> type, MappingContext mappingContext) {
        return CommonEnum.fromValue(type, integer);
    }
}

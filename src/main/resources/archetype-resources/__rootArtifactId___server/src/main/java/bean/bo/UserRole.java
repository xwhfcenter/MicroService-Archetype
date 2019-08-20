#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.bean.bo;

import ${package}.util.CommonEnum;

/**
 * Created by copperfield @ 2019-07-07 15:54
 */
public enum UserRole implements CommonEnum {
    ADMIN(1);
    
    private int value;
    
    UserRole(int value) {
        this.value = value;
    }
    
    @Override
    public Integer getValue() {
        return this.value;
    }
}

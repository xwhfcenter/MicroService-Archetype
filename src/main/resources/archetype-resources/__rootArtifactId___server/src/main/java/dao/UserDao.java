#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dao;

import ${package}.bean.po.UserPO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by copperfield @ 2019-07-23 20:50
 */

public interface UserDao extends CrudRepository<UserPO, Long> {
}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import ${package}.bean.bo.User;
import ${package}.bean.po.UserPO;
import ${package}.dao.UserDao;
import ${package}.util.CommonApiException;
import ${package}.util.EnumConverter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by copperfield @ 2019-07-23 20:59
 */
@Service
public class UserService {
    
    private final UserDao userDao;
    private static final MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
                                                                               .mapNulls(false)
                                                                               .build();
    
    static {
        ConverterFactory converterFactory = mapperFactory.getConverterFactory();
        converterFactory.registerConverter("enum-integer-converter", new EnumConverter<>());
        
        mapperFactory.classMap(User.class, UserPO.class)
                     .fieldMap("role", "role").converter("enum-integer-converter").add()
                     .byDefault()
                     .register();
    }
    
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    
    /*
    * @param user
    */
    @Transactional
    public User addUser(User user) {
        UserPO userPO = mapperFactory.getMapperFacade().map(user, UserPO.class);
        userDao.save(userPO);
        user.setId(userPO.getId());
        
        return user;
    }
    
    public User getUser(Long id) {
        UserPO userPO = userDao.findById(id)
                               .orElseThrow(() -> new CommonApiException("user.not.found"));
        return mapperFactory.getMapperFacade().map(userPO, User.class);
    }
    
    @Transactional
    public User updateUser(Long id, User user) {
        UserPO userPO = userDao.findById(id)
                            .orElseThrow(() -> new CommonApiException("user.not.found"));
        mapperFactory.getMapperFacade().map(user, userPO);
        userDao.save(userPO);
        return mapperFactory.getMapperFacade().map(userPO, User.class);
    }
    
    @Transactional
    public User deleteUser(Long id) {
        
        if (!userDao.existsById(id)) {
            throw new CommonApiException("user.not.found");
        }
        
        User user = getUser(id);
        userDao.deleteById(id);
        
        return user;
    }
}

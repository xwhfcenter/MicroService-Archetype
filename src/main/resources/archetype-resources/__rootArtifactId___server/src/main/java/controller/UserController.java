#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.controller;

import ${package}.Constants;
import ${package}.bean.bo.User;
import ${package}.bean.resp.GenericResp;
import ${package}.service.UserService;
import ${package}.util.ResponseKit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by copperfield @ 2019-07-07 15:34
 */
@Api("用户相关的API")
@RestController
@RequestMapping(value = Constants.PATH_WITH_VERSION)
@Slf4j
public class UserController {
    
    private UserService userService;
   
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @ApiOperation(value = "新增用户(User)")
    @RequestMapping(value = "/users/", method = RequestMethod.POST)
    public GenericResp addUser(@RequestBody User user) {
        User data = userService.addUser(user);
        return ResponseKit.buildOKResp(data, "Add user successfully!");
    }
    
    @ApiOperation(value = "查找用户(User)")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public GenericResp getUser(@PathVariable Long id) {
        User data = userService.getUser(id);
        return ResponseKit.buildOKResp(data, "Get user successfully!");
    }
    
    @ApiOperation(value = "更新用户(User)")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.PATCH)
    public GenericResp updateUser(@PathVariable Long id, @RequestBody User user) {
        User data = userService.updateUser(id, user);
        return ResponseKit.buildOKResp(user, "Update user successfully!");
    }
    
    @ApiOperation(value = "删除用户(User)")
    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public GenericResp deleteUser(@PathVariable Long id) {
        User data = userService.deleteUser(id);
        return ResponseKit.buildOKResp(data, "Delete user successfully!");
    }
}

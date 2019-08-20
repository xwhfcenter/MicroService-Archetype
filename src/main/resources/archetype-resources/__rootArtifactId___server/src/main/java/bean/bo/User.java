#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.bean.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by copperfield @ 2019-07-07 15:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @ApiModelProperty(value = "User Id", hidden = true)
    private Long id;
    @ApiModelProperty(value = "User Name")
    private String userName;
    @ApiModelProperty(value = "Nickname")
    private String nickname;
    @ApiModelProperty(value = "Password")
    private String password;
    @ApiModelProperty(value = "Company")
    private String company;
    @ApiModelProperty(value = "Role")
    private UserRole role;
    @ApiModelProperty(value = "Phone")
    private String phone;
    @ApiModelProperty(value = "Email")
    private String email;
}

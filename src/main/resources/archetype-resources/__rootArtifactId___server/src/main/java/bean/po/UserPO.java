#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.bean.po;

import ${package}.bean.bo.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by copperfield @ 2019-07-23 15:59
 */
@Entity
@Table(name = "T_User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPO {
    
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;
    
    @Column(name = "user_name", unique = true)
    private String userName;
    
    @Column(name = "nickname")
    private String nickname;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "company")
    private String company;
    
    @Column(name = "role")
    private Integer role;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "gmt_create")
    private Date gmtCreate;
    
    @Column(name = "gmt_update")
    private Date gmtUpdate;
    
    @Column(name = "create_user")
    private String createUser;
    
    @Column(name = "last_modify_user")
    private String lastModifyUser;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.builders;

import entity.Role;
import entity.User;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Melnikov
 */
public class UserJsonBuilder {
    public JsonObject createJsonUser(User user, String JSESSIONID, String roleUser){
        if(JSESSIONID == null) JSESSIONID = "null";
        if(roleUser == null) roleUser = "null";
        JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", user.getId())
                .add("login", user.getLogin())
                .add("JSESSIONID", JSESSIONID)
                .add("role", roleUser);
                
        return job.build();
    }
    public JsonObject createJsonUser(User user){
        return createJsonUser(user, null, null);
    }
    public JsonObject createJsonMapUserRoles(User user, List<Role> roles){
        RoleJsonBuilder rjb = new RoleJsonBuilder();
        UserJsonBuilder ujb = new UserJsonBuilder();
        Map<User,Object> userRolesMap = new HashMap<>();
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for(Role role: roles){
             jab.add(rjb.createJsonRole(role));
        }
        
        userRolesMap.put(user, roles)
    }
}

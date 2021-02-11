/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.builders;

import entity.Role;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Melnikov
 */
public class RoleJsonBuilder {
    public JsonObject createJsonRole(Role role){
        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("id", role.getId())
            .add("name", role.getName());
        return job.build();
    }
    
}

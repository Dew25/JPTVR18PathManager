/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json.builders;

import entity.User;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author Melnikov
 */
public class UserJsonBuilder {
    public JsonObject createJsonUser(User user){
        JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", user.getId())
                .add("login", user.getLogin())
                .add("password", user.getPassword());
        return job.build();
    }
}

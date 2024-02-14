package com.glcondominio.auditory;

import java.util.Date;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;

import com.glcondominio.model.Creation;

@Component
public class CreationByToken {
    
    public Creation buildCreationByJwt(Jwt jwt) {
        String userId = jwt.getClaim("user_id");

        Creation creation = new Creation();
        creation.setCreatedAt(new Date());
        creation.setCreatedBy(userId);
        creation.setUpdatedAt(null);
        creation.setUpdatedBy(null);
        return creation;
    }
}

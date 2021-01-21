package com.axsosplatform.axsosplatform.validator;


import com.axsosplatform.axsosplatform.models.User;
import com.axsosplatform.axsosplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserRepository uRepo;
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if(this.uRepo.findByUsername(user.getUsername())!= null) {
            errors.rejectValue("username", "Unique");
        }


    }
}

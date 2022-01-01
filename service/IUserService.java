package nazeem.web.service;

import nazeem.web.model.User;
import nazeem.web.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService{
    User save(UserRegistrationDto registrationDto);
    User findByUsername(String username);
}



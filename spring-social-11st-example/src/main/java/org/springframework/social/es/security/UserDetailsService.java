package org.springframework.social.es.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.es.user.User;
import org.springframework.social.es.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public final UserDetail loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Not Exist User");
        }

        UserDetail userDetail = new UserDetail(user);
        return userDetail;
    }
}

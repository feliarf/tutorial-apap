package apap.tutorial.shapee.security;

import apap.tutorial.shapee.model.UserModel;
import apap.tutorial.shapee.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDb userDb;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userDb.findByUsername(username);

        Set<GrantedAuthority> granthedAuthorities = new HashSet<GrantedAuthority>();
        granthedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));

        return new User(user.getUsername(), user.getPassword(), granthedAuthorities);
    }
}

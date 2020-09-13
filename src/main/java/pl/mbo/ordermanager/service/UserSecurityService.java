package pl.mbo.ordermanager.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.mbo.ordermanager.repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserSecurityService implements UserDetailsService, InitializingBean {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserSecurityService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<pl.mbo.ordermanager.model.User> user = userRepository.findByFirstName(s);
        if (user.isPresent()){
            return new User(user.get().getFirstName(), user.get().getPassword(), roles());
        }
        throw new UsernameNotFoundException(s);
    }

    private Collection<? extends GrantedAuthority> roles() {
        SimpleGrantedAuthority simpleGrantedAuthority= new SimpleGrantedAuthority("ROLE_USER");
        return List.of(simpleGrantedAuthority);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        pl.mbo.ordermanager.model.User user = new pl.mbo.ordermanager.model.User();
        user.setFirstName("Michalek");
        user.setPassword(encoder.encode("qwe123"));
        userRepository.save(user);
    }
}

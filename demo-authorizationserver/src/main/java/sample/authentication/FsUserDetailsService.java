package sample.authentication;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import sample.entity.FsUser;
import sample.repository.FsUserRepository;

@Service
@RequiredArgsConstructor
public class FsUserDetailsService implements UserDetailsService {
	private final FsUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	FsUser user = userRepository.findByUserId(username).orElse(null);
    	
        return new FsUserDetails(user);
    }
}

package me.EranoMarket.com.Service;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.EranoMarket.com.model.User;
import me.EranoMarket.com.repository.UserRepository;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepository userRepository;
	
	//hashlenmiş şifreyi compare eder.(login işlemi için)
	public boolean checkPassword(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return false;
        }
        String hashedPassword = user.getPassword();
        return BCrypt.checkpw(password, hashedPassword);
    }
	
	//diğer kullanıcı işlemleri
}

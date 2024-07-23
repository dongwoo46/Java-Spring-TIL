package amigo.securityjwt.service;

import amigo.securityjwt.domain.Role;
import amigo.securityjwt.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}

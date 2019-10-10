package si.inspirited.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import si.inspirited.persistence.dao.*;
import si.inspirited.persistence.model.Privilege;
import si.inspirited.persistence.model.Role;
import si.inspirited.persistence.model.User;
import si.inspirited.persistence.model.uniqueEntities.Category;
import si.inspirited.persistence.model.uniqueEntities.Kind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private KindRepository kindRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // API

    @Override
    @Transactional
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        if (alreadySetup) {
            return;
        }

        // == create initial privileges
        final Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
        final Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
        final Privilege passwordPrivilege = createPrivilegeIfNotFound("CHANGE_PASSWORD_PRIVILEGE");

        // == create initial roles
        final List<Privilege> adminPrivileges = new ArrayList<Privilege>(Arrays.asList(readPrivilege, writePrivilege, passwordPrivilege));
        final List<Privilege> userPrivileges = new ArrayList<Privilege>(Arrays.asList(readPrivilege, passwordPrivilege));
        final Role adminRole = createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        final Role userRole = createRoleIfNotFound("ROLE_USER", userPrivileges);

        // == create initial user
        createUserIfNotFound("test@test.com", "Test", "Test", "test", new ArrayList<Role>(Arrays.asList(adminRole)));

            // == create main guest user account for tests and persisting guest' ads
            createUserIfNotFound("j2eengineer@gmail.com","DreamHacker", "Administrators", "1Qq_2Ww3", new ArrayList<Role>(Arrays.asList(adminRole, userRole)));

        // == create initial kinds
        createKindIfNotFound("goods");
        createKindIfNotFound("services");

        // == create initial categories
                //init categories for goods
        createCategoryIfNotFound("plants");
        createCategoryIfNotFound("cars");
        createCategoryIfNotFound("foods");
                //init categories for services
        createCategoryIfNotFound("medicine");
        createCategoryIfNotFound("information");
        createCategoryIfNotFound("site-building");

        alreadySetup = true;
    }

    @Transactional
    private final Privilege createPrivilegeIfNotFound(final String name) {
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilege = privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    private final Role createRoleIfNotFound(final String name, final Collection<Privilege> privileges) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
        }
        role.setPrivileges(privileges);
        role = roleRepository.save(role);
        return role;
    }

    @Transactional
    private final User createUserIfNotFound(final String email, final String firstName, final String lastName, final String password, final Collection<Role> roles) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPassword(passwordEncoder.encode(password));
            user.setEmail(email);
            user.setEnabled(true);
        }
        user.setRoles(roles);
        user = userRepository.save(user);
        return user;
    }






    @Transactional
    private final Kind createKindIfNotFound(final String name) {
        Kind kind = kindRepository.findByName(name);
        Kind res = new Kind();
        if (kind == null) {
            res.setName(name);
            res = kindRepository.save(res);
        }
        return res;
    }

    @Transactional
    private final Category createCategoryIfNotFound(final String name) {
        Category category = categoryRepository.findByName(name);
        Category res = new Category();
        if (category == null) {
            res.setName(name);
            res = categoryRepository.save(res);
        }
        return res;
    }


}
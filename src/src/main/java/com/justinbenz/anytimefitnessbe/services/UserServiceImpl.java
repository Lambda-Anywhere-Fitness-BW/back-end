package com.justinbenz.anytimefitnessbe.services;


import com.justinbenz.anytimefitnessbe.exceptions.ResourceNotFoundException;
import com.justinbenz.anytimefitnessbe.models.Role;
import com.justinbenz.anytimefitnessbe.models.User;
import com.justinbenz.anytimefitnessbe.models.UserRoles;
import com.justinbenz.anytimefitnessbe.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userrepos;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Override
    public User update(
            User user,
            long id)
    {
        User currentUser = findUserById(id);

        if (user.getUsername() != null)
        {
            currentUser.setUsername(user.getUsername()
                    .toLowerCase());
        }

        if (user.getPassword() != null)
        {
            currentUser.setPasswordNoEncrypt(user.getPassword());
        }

        if (user.getEmail() != null)
        {
            currentUser.setEmail(user.getEmail()
                    .toLowerCase());
        }

        if (user.getRoles()
                .size() > 0)
        {
            currentUser.getRoles()
                    .clear();
            for (UserRoles ur : user.getRoles())
            {
                Role addRole = roleService.findRoleById(ur.getRole()
                        .getRoleid());

                currentUser.getRoles()
                        .add(new UserRoles(currentUser, addRole));
            }
        }

        return userrepos.save(currentUser);
    }

    @Transactional
    @Override
    public User save(User user)
    {
        User newUser = new User();

        if (user.getUserid() != 0)
        {
            userrepos.findById(user.getUserid())
                    .orElseThrow(() -> new ResourceNotFoundException("User id " + user.getUserid() + " not found!"));
            newUser.setUserid(user.getUserid());
        }

        newUser.setName(user.getName());
        newUser.setUsername(user.getUsername()
                .toLowerCase());
        newUser.setPasswordNoEncrypt(user.getPassword());
        newUser.setEmail(user.getEmail()
                .toLowerCase());
        newUser.setAviurl(user.getAviurl());
        newUser.setBio(user.getBio());

        newUser.getRoles()
                .clear();
        for (UserRoles ur : user.getRoles())
        {
            System.out.println(newUser.getUserid());
            Role addRole = roleService.findRoleById(ur.getRole()
                    .getRoleid());
            System.out.println(addRole);
            newUser.getRoles()
                    .add(new UserRoles(newUser,
                            addRole));
        }

        return userrepos.save(newUser);
    }

    @Transactional
    @Override
    public void delete(long id)
    {
        userrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id:" + id + " not found!"));
        userrepos.deleteById(id);
    }

    public User findUserById(long id) throws
            ResourceNotFoundException
    {
        return userrepos.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Userid " + id + " not found!"));
    }

    @Override
    public User findByName(String name)
    {
        User uu = userrepos.findByUsername(name.toLowerCase());
        if (uu == null)
        {
            throw new ResourceNotFoundException("User name " + name + " not found!");
        }
        return uu;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        userrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}

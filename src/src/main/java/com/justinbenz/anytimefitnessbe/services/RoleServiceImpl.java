package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.Role;
import com.justinbenz.anytimefitnessbe.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleRepository rolerepos;

    @Override
    public Role findByName(String name) {
        return null;
    }

    @Override
    public Role findRoleById(long roleid) {
        return null;
    }
}

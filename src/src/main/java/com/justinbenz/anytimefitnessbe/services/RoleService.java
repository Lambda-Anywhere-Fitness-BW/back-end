package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.models.Role;

public interface RoleService {

    Role findByName(String name);
    Role findRoleById(long roleid);
}

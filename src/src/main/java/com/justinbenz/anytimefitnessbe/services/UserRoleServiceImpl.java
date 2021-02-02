package com.justinbenz.anytimefitnessbe.services;

import com.justinbenz.anytimefitnessbe.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("userRoleService")
public class UserRoleServiceImpl {

    @Autowired
    private UserRoleRepository userRoleRepository;
}

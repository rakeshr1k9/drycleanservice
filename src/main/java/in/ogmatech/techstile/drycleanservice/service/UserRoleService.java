package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.UserRole;

import java.util.List;

public interface UserRoleService {

    boolean isExist(UserRole userRole);

    UserRole save(UserRole userRole);

    UserRole findById(Long idUserRole);

    List<UserRole> findAll();

    UserRole update(Long idUserRole, UserRole userRole);

    void delete(Long idUserRole);

    void deleteAll();
}

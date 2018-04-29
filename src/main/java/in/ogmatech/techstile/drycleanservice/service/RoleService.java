package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Role;

import java.util.List;

public interface RoleService {

    boolean isExist(Role role);

    Role save(Role role);

    Role findById(Long idRole);

    List<Role> findAll();

    Role update(Long idRole, Role role);

    void delete(Long idRole);

    void deleteAll();
}

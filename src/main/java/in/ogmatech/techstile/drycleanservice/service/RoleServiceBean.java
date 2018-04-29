package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Role;
import in.ogmatech.techstile.drycleanservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class RoleServiceBean implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public boolean isExist(Role role) {
        return findById(role.getIdRole())!=null;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(Long idRole) {
        return roleRepository.findOne(idRole);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role update(Long idRole, Role role) {

        Role currentRole = roleRepository.findOne(idRole);

       /* currentRole.setRolename(role.getRolename());
        currentRole.setPassword(role.getPassword());
        currentRole.setRoleMobile(role.getRoleMobile());
        currentRole.setIsDeleted(role.getIsDeleted());
        currentRole.setBranchId(role.getBranchId());
        currentRole.setRoleDeviceIdentity(role.getRoleDeviceIdentity());*/

        return roleRepository.save(currentRole);
    }

    @Override
    public void delete(Long idRole) {
        roleRepository.delete(idRole);
    }

    @Override
    public void deleteAll() {
        roleRepository.deleteAll();
    }
}

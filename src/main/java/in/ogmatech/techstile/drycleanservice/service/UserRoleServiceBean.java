package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.UserRole;
import in.ogmatech.techstile.drycleanservice.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class UserRoleServiceBean implements UserRoleService {

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public boolean isExist(UserRole userRole) {
        return findById(userRole.getIdUserRole())!=null;
    }

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public UserRole findById(Long idUserRole) {
        return userRoleRepository.findOne(idUserRole);
    }

    @Override
    public List<UserRole> findAll() {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole update(Long idUserRole, UserRole userRole) {

        UserRole currentUserRole = userRoleRepository.findOne(idUserRole);

       /* currentUserRole.setUserRolename(userRole.getUserRolename());
        currentUserRole.setPassword(userRole.getPassword());
        currentUserRole.setUserRoleMobile(userRole.getUserRoleMobile());
        currentUserRole.setIsDeleted(userRole.getIsDeleted());
        currentUserRole.setBranchId(userRole.getBranchId());
        currentUserRole.setUserRoleDeviceIdentity(userRole.getUserRoleDeviceIdentity());*/

        return userRoleRepository.save(currentUserRole);
    }

    @Override
    public void delete(Long idUserRole) {
        userRoleRepository.delete(idUserRole);
    }

    @Override
    public void deleteAll() {
        userRoleRepository.deleteAll();
    }
}

package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.exception.AlreadyExistsException;
import in.ogmatech.techstile.drycleanservice.model.User;
import in.ogmatech.techstile.drycleanservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Validated
@Transactional
public class UserServiceBean implements UserService {

    @Autowired
    UserRepository userRepository;

   /* @PersistenceContext
    private EntityManager entityManager;*/

    @Override
    public boolean isExist(User user) {
        return findById(user.getIdUser())!=null;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Long idUser) {
        return userRepository.findOne(idUser);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long idUser, User user) {

        User currentUser = userRepository.findOne(idUser);

        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        currentUser.setUserMobile(user.getUserMobile());
        currentUser.setIsDeleted(user.getIsDeleted());
//        currentUser.setBranchId(user.getBranchId());
        currentUser.setUserDeviceIdentity(user.getUserDeviceIdentity());
       /* if (!entityManager.contains(user))
            user = entityManager.merge(user);*/
        return userRepository.save(currentUser);
    }

    @Override
    public void delete(Long idUser) {
        userRepository.delete(idUser);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}

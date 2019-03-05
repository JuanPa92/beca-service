package mx.com.axity.services.facade;

import mx.com.axity.commons.to.UserTO;

import java.util.List;

public interface IbecaFacade {

    int operation(int num1, int num2);

    List<UserTO> getAllUsers();

    void createUser(UserTO userTO);
    void updateUser(UserTO userTO);
    UserTO readUser(int id);
    void deleteUser(int id);

}

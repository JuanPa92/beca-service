package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;

import java.util.List;

public interface IbecaService {

    int sum(int sum1, int sum2);

    int substraction(int substraction1, int substraction2);

    int multiplication(int multiplication1);

    int division(int division1);

    List<UserDO> getAllUsers();

    void createUser(UserDO userDO);

    UserDO readUser(int id);

}

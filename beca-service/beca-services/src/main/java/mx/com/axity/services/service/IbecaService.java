package mx.com.axity.services.service;

import mx.com.axity.commons.to.UserTO;
import java.util.List;

public interface IbecaService {

    List<UserTO> getUsers();

    int sum(int sum1, int sum2);

    int substraction(int substraction1, int substraction2);

    int multiplication(int multiplication1);

    int division(int division1);
}

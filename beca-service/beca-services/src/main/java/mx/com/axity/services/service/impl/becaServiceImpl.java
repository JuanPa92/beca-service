package mx.com.axity.services.service.impl;

import mx.com.axity.commons.to.UserTO;
import mx.com.axity.model.UserDO;
import mx.com.axity.persistence.UserDAO;
import mx.com.axity.services.service.IbecaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class becaServiceImpl implements IbecaService {

    static final Logger LOG = LogManager.getLogger(becaServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserTO> getUsers() {

        LOG.info("Consultando usuarios");
        List<UserDO> usersDO = this.userDAO.findByLastName("Rodriguez");

        Type userDAOType = new TypeToken<List<UserDO>>() {}.getType();
        List<UserTO> usersTO = this.modelMapper.map(usersDO, userDAOType);
        LOG.info("Se retornan {} elementos", usersTO.size());

        return usersTO;
    }

    @Override
    public int sum(int sum1, int sum2) {
        return sum1 + sum2;
    }

    @Override
    public int substraction(int substraction1, int substraction2) {
        return substraction1 - substraction2;
    }

    @Override
    public int multiplication(int multiplication1) {
        return multiplication1 * 4;
    }

    @Override
    public int division(int division1) {
        return division1 / 4;
    }
}
package mx.com.axity.web.rest;

import io.swagger.annotations.Api;
import mx.com.axity.commons.to.UserTO;
import mx.com.axity.services.facade.IbecaFacade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("beca")
@Api(value="beca", description="Operaciones con beca")
public class HelloController {

    static final Logger LOG = LogManager.getLogger(HelloController.class);

    //@Autowired
    //RestTemplate restTemplate;

    @Autowired
    IbecaFacade IbecaFacade;

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<UserTO>> getAllUsers() {
        LOG.info("Se invoca /users");
        List<UserTO> users = this.IbecaFacade.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/create_user", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createUser(@RequestBody UserTO userTO) {
        LOG.info("Se invoca /create_user");
        this.IbecaFacade.createUser(userTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateUser(@RequestBody UserTO userTO) {
        LOG.info("Se invoca /update_user");
        this.IbecaFacade.updateUser(userTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/read_user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserTO> readUser(@RequestParam(value = "id") int id) {
        LOG.info("Se invoca /read_user");
        UserTO user = this.IbecaFacade.readUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete_user", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUser(@RequestParam(value = "id") int id) {
        LOG.info("Se invoca /delete_user");
        this.IbecaFacade.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveUser(@RequestBody UserTO userTO) {

        LOG.info("User");
        LOG.info(userTO.getName());
        LOG.info(userTO.getAge());
        LOG.info(userTO.getId());
        LOG.info(userTO.getLastName());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity findUser(@RequestParam(value = "id") int id) {

        LOG.info("User id:");
        LOG.info(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity test() {
        LOG.info("Se invoca /test");
        return new ResponseEntity<>("Prueba Ok", HttpStatus.OK);
    }

    @RequestMapping(value = "/operation", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity operation() {
        LOG.info("Se invoca /operation");
        int result = this.IbecaFacade.operation(5, 10);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

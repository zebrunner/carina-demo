package carina.learning;

import carina.learning.api.employees.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class ApiEmployeesTest {

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testCreateUser() {
        PostUserMethod api = new PostUserMethod();
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testUpdateUser() {
        PutUserMethod api = new PutUserMethod(24);
        api.setProperties("api/users/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetUsers() {
        GetAllUsersMethod getUsersMethods = new GetAllUsersMethod();
        getUsersMethods.callAPIExpectSuccess();
        getUsersMethods.validateResponse();
        getUsersMethods.validateResponseAgainstSchema("api/users/_get_all/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testGetUser() {
        GetUserByIdMethod getUsersMethod = new GetUserByIdMethod(23);
        getUsersMethod.callAPIExpectSuccess();
        getUsersMethod.validateResponse();
        getUsersMethod.validateResponseAgainstSchema("api/users/_get_by_id/rs.schema");
    }

    @Test()
    @MethodOwner(owner = "nknysh")
    public void testDeleteUsers() {
        DeleteUserMethod deleteUserMethod = new DeleteUserMethod(24);
        deleteUserMethod.callAPIExpectSuccess();
        deleteUserMethod.validateResponse();
    }
}

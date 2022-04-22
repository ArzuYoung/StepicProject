package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {

    private DBService dbService = new DBService();


   public void addNewUser(UserProfile userProfile) throws DBException {
        dbService.addUser(userProfile.getLogin(), userProfile.getPassword());
    }

    public UserProfile getUserByLogin(String login) {
        UsersDataSet usersDataSet = dbService.getUserByName(login);
        return new UserProfile(usersDataSet.getName(), usersDataSet.getPassword());
    }

}

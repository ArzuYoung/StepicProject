package dbService.dataSets;


/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
//@Entity
//@Table(name = "users")
//public class UsersDataSet implements Serializable { // Serializable Important to Hibernate!
//    private static final long serialVersionUID = -8706689714326132798L;
//
//    @Id
//    @Column(name = "id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @Column(name = "name", unique = true, updatable = false)
//    private String name;

@SuppressWarnings("UnusedDeclaration")
public class UsersDataSet {

    private long id;
    private String login;
    private String password;

    public UsersDataSet(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public UsersDataSet(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return login;
    }

    public void setName(String login) {
        this.login = login;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", login='" + login + '\'' +
                '}';
    }
}
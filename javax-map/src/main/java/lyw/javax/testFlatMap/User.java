package lyw.javax.testFlatMap;

/**
 * @author luohx
 * @version 1.0.0
 * @date: 2023/7/6 下午3:46
 * @menu
 */
public class User {

    private Long userId;

    private String userName;

    private String mobile;

    public User() {
    }

    public User(Long userId, String userName, String mobile) {
        this.userId = userId;
        this.userName = userName;
        this.mobile = mobile;
    }

    /**
     * Gets the value of userId.
     *
     * @return the value of userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the userId. *
     * <p>You can use getUserId() to get the value of userId</p>
     * * @param userId userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Gets the value of userName.
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the userName. *
     * <p>You can use getUserName() to get the value of userName</p>
     * * @param userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the value of mobile.
     *
     * @return the value of mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the mobile. *
     * <p>You can use getMobile() to get the value of mobile</p>
     * * @param mobile mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

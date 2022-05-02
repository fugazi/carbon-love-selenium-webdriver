package com.example.carbon.love.carbonlove.BaseUtility;

public enum LoginCredentials {
    STANDARD_USER("standard_user", "secret_sauce"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce"),
    INVALID_USER("problem_user", "secret_sauce");

    private String userName;
    private String password;

    LoginCredentials(String aUserName, String aPassword) {
        this.userName = aUserName;
        this.password = aPassword;
    }

    /**
     * Get the username to use for the test.
     * @return the username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Get the password to use for the test.
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}

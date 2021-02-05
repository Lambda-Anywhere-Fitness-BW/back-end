package com.justinbenz.anytimefitnessbe.models;

import javax.validation.constraints.Email;

/**
 * A model used to create a new user. The minimum information needed to create a user.
 * Note the role will default to USER.
 */
public class ClientMinimum
{
    /**
     * The username (String)
     */
    private String username;

    /**
     * The user's password (String)
     */
    private String password;

    /**
     * The user's primary email address (String)
     */
    @Email
    private String email;

    private String name;

    private String bio;

    private String aviurl;

    private int fitnesslevel;

    private String location;


    /**
     * Getter for the username
     *
     * @return the username (String) associated with this user
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Setter for the username
     *
     * @param username the new username (String) associated with this user
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * Getter for the password of this user
     *
     * @return the password (String) for this user
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * Setter for the password of this user. This object is a temporary model used to create a new user.
     * The password must remain in clear text until saved into the database.
     *
     * @param password the new password (String in clear texts) for this user
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     * Getter for email for this user
     *
     * @return the email address (String) for this user
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Setter for email for this user
     *
     * @param email the new email address (String) for this user.
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getFitnesslevel() {
        return fitnesslevel;
    }

    public void setFitnesslevel(int fitnesslevel) {
        this.fitnesslevel = fitnesslevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAviurl() {
        return aviurl;
    }

    public void setAviurl(String aviurl) {
        this.aviurl = aviurl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}

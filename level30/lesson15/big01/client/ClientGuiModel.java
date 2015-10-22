package com.javarush.test.level30.lesson15.big01.client;

/**
 * Created by Александр on 20.10.2015.
 */
import java.util.*;

public class ClientGuiModel
{
    private final List<String> allUserNames = new ArrayList<String>();
    private String newMessage;
    public List<String> getAllUserNames()
    {
        return Collections.unmodifiableList(allUserNames);
    }
    public String getNewMessage()
    {
        return newMessage;
    }
    public void setNewMessage(String newMessage)
    {
        this.newMessage = newMessage;
    }
    private void addUser(String newUserName)
    {
        if(newUserName != null && !newUserName.isEmpty()) allUserNames.add(newUserName);
    }
    private void deleteUser(String userName)
    {
        if(userName != null && !userName.isEmpty()) allUserNames.remove(userName);
    }
}
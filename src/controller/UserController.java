package controller;

import model.User;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class UserController {
    private User user;
    private LinkedList<User> users;

    public UserController(){
        users = new LinkedList<>();
        read();
    }

    public void read(){
        try {
            FileReader fileReader = new FileReader("data/users.csv");
            Scanner scanner = new Scanner(fileReader);
            while(scanner.hasNext()){
                String[] data = scanner.nextLine().split(",");
                user = new User(data[0], data[1]);
                users.add(user);
            }
            fileReader.close();
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean read(String username, String password){
        for (int i = 0; i < users.size(); i++) {
            if (    username.equals(users.get(i).getUsername()) &&
                    password.equals(users.get(i).getPassword())     ){
                return true;
            }
        }
        return false;
    }

    public void create(String username, String password){
        try {
            FileWriter fileWriter = new FileWriter("data/users.csv",true);
            fileWriter.write(username+","+password);
            fileWriter.write(System.lineSeparator());
            user = new User(username, password);
            users.add(user);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(String username, String newPassword){
        try {
            FileWriter fileWriter = new FileWriter("data/users.csv", false);
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)){
                    users.get(i).setPassword(newPassword);
                }
                fileWriter.write(users.get(i).getUsername()+","+users.get(i).getPassword());
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(String username){
        try {
            FileWriter fileWriter = new FileWriter("data/users.csv", false);
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getUsername().equals(username)){
                    users.set(i, null);
                }else{
                    fileWriter.write(users.get(i).getUsername()+","+users.get(i).getPassword());
                    fileWriter.write(System.lineSeparator());
                }

            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

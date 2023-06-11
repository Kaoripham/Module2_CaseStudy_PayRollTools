package AP0_Module2_Case_PayRoll;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Authentication {

    List<User> userList = new ArrayList<>();
    File fileAccount = new File("fileAccount");
//    private Map<String, String> users = new HashMap<>();
//    private String loggedInUser;
//    private boolean isAdmin;

    public void addUser(String userName, String password, boolean isAdmin) {
        readFile();
        User account;
        if (isAdmin) {
            account = new User(userName, password, true);
        } else {
            account = new User(userName, password, false);
        }
        userList.add(account);
        writeFile();
    }

    public User login(String username, String password, boolean isAdmin) {
        readFile();
        boolean check=false;
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
               return user;
            }
        }
        if(!check) {
            System.out.println("Tài khoản không tồn tại.");
        }
        return  null;
    }


    public void writeFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileAccount))) {
            oos.writeObject(userList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        if (fileAccount.length() > 0) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileAccount))) {
                userList = (List<User>) ois.readObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//    public static void main(String[] args) {
//        Authentication authentication=new Authentication();
//        authentication.addUser("aaa","123456",true);
//        authentication.addUser("bbb","123456",false);
//    }
}
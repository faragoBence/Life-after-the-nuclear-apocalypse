package com.codecool.web.service.implementations;

import com.codecool.web.dao.implementations.UserDatabaseDao;
import com.codecool.web.exception.UserAlreadyRegisteredException;
import com.codecool.web.exception.UserNotFoundException;
import com.codecool.web.exception.WrongPasswordException;
import com.codecool.web.model.User;
import com.codecool.web.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private final UserDatabaseDao dao;

    public UserServiceImpl(UserDatabaseDao dao) {
        this.dao = dao;
    }


    public String help() {
        return "You need to stay alive in this game, as long as you can.\n\n" +
                "You can go to specific locations and search there, but warning an enemy will attack you.\n" +
                "In combat, you can use a weapon from your inventory.\n" +
                "Every location has a specific radiation level, so it will decrease your radiation damage if you search there.\n" +
                "With every search you can find an item and two resource material for crafting\n" +
                "Your action points will be decreased by 1 and hunger level by 10\n\n" +
                "With materials you can build several useful furnitures (-1 action points) and craft items\n" +
                "If your action points are 0, you need to rest in your outpost.\n" +
                "Every rest will restore you action points, but also decrease your hunger level by 35 and your radiation damage by 10\n" +
                "Your health,radiation and hunger can be restored with ':eat' and ':heal' command.These doesn't takes action points.\n" +
                "You can also save your progress everytime with ':save' command\n\n" +
                "If your hunger,health and radiation hits 0, you are dead, so be careful!\n" +
                "Good luck Survivor!\n";
    }

    @Override
    public void register(String name, String email, String password) throws UserAlreadyRegisteredException, SQLException {
        User alreadyRegisteredUser = dao.findUserbyEmail(email);
        if (alreadyRegisteredUser == null) {
            dao.insertUser(name, email, password);
        } else {
            throw new UserAlreadyRegisteredException();
        }
    }

    @Override
    public boolean containsUser(String email) {
        return false;
    }

    public String story() {
        return "We are in 2030.The population of the world is almost 0.It seems Paks2 was a huge mistake...\n" +
                "The nuclear power plant is built by a famous gas man named 'Meszaros'.\n" +
                "He wanted to build this factory with low cost, but something happened.\n" +
                "The same problem like with the red mud factory.The cheap 'kozbeszerzes' isn't so good.\n" +
                "But you never trusted in goverment's and the modern world.You started to build an atom bunker.\n" +
                "You gathered enough food, and reached your bunker before the catastrophe happened.\n\n" +
                "After 5 year of hiding, you must come out from your bunker, because you consumed all of your foods.\n";
    }

    public User login(String email, String password) throws WrongPasswordException, SQLException, UserNotFoundException {
        User userByEmail = dao.findUserbyEmail(email);
        if (userByEmail != null) {
            User userByEmailAndPassword = dao.findUserbyEmailAndPassword(email, password);
            if (userByEmailAndPassword != null) {
                return userByEmailAndPassword;
            } else {
                throw new WrongPasswordException();
            }
        } else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User login(String email) {
        return null;
    }

    @Override
    public User changeName(String newName, String Password) {
        return null;
    }

    @Override
    public User changePassword(String newPassword, String oldPassword) {
        return null;
    }


}

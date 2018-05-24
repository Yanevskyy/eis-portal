package com.od.eisgroup.service.impl;

import com.od.eisgroup.dao.api.GenericDao;
import com.od.eisgroup.domain.entity.User;
import com.od.eisgroup.service.api.ViewerProfiles;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Takes all user list in the DAO. Sorts the list by comparator "UserProfileComparator" and return to controller.
 * And finds into the users list who names contains search phrase.
 *
 * @author Yanevskyy Igor i.yanevskyy@gmail.com.
 * @since 1.2
 */
@Service
public class ViewerProfilesUsers implements ViewerProfiles {
    /**
     * Count part in the search phrase.
     */
    private final static int ONE_PART_PHRASE = 1;
    /**
     * Count part in the search phrase.
     */
    private final static int TWO_PART_PHRASE = 2;
    /**
     * DAO entity
     */
    private GenericDao userDao;

    public ViewerProfilesUsers(GenericDao userDao) {
        this.userDao = userDao;
    }

    /**
     * If the search phrase contain two parts who separated by space, then first part that before the space,
     * should equals the first name or last name.
     *
     * @param searchPhrase phrase to search for.
     * @return found user list.
     */
    @Override
    public List<User> displayFoundUsers(String searchPhrase) {
        List<User> users = displayAllUsers();
        List<User> foundUsers = new ArrayList<>();
        if (users.isEmpty()) {
            return foundUsers;
        }

        String[] partsSearchPhrase = separatorPhrase(searchPhrase);

        if (partsSearchPhrase.length == ONE_PART_PHRASE) {
            String partName = partsSearchPhrase[0];
            foundUsers = findUserListByPhrase(partName, users);
        } else {
            if (partsSearchPhrase.length == TWO_PART_PHRASE) {
                String wholePartName = partsSearchPhrase[0];
                String secondPartName = partsSearchPhrase[1];
                foundUsers = findUserListByPhrase(wholePartName, secondPartName, users);
            }
        }
        return foundUsers;
    }

    @Override
    public List<User> displayAllUsers() {
        List<User> users = userDao.findAll();
        if (users == null) {
            return new ArrayList<>();
        } else {
            return sortedProfiles(users);
        }
    }

    /**
     * Sorts users by last name and if the last names match, then sorts by first name.
     *
     * @param users collection for sorted.
     * @return sorted user list.
     */
    private List<User> sortedProfiles(List<User> users) {
        Collections.sort(users, new UserProfileComparator());
        return users;
    }

    /**
     * Separates the search phrase into parts.
     *
     * @param searchPhrase the phrase for separates.
     * @return array who contain the parts phrase.
     */
    private static String[] separatorPhrase(String searchPhrase) {
        int indexSpace = searchPhrase.indexOf(" ");
        if (indexSpace < 0) {
            return new String[]{searchPhrase};
        } else if (indexSpace == 0 || indexSpace == searchPhrase.length() - 1) {
            String newSearchPhrase = searchPhrase.replaceAll(" ", "");
            return new String[]{newSearchPhrase};
        } else {
            return searchPhrase.split(" ");
        }
    }

    /**
     * Returns user list who have a "search text" in the last name or in the first name.
     *
     * @param searchText the search text.
     * @param users      all users from DB
     * @return found users.
     */
    private static List<User> findUserListByPhrase(String searchText, List<User> users) {
        List<User> foundUsers = new ArrayList<>();
        for (User user : users) {
            if (user.getFirstName().toLowerCase().contains(searchText.toLowerCase())) {
                foundUsers.add(user);
            } else if (user.getLastName().toLowerCase().contains(searchText.toLowerCase())) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }

    /**
     * Returns user list who have a first part name is whole and second part name is whole or not.
     *
     * @param wholeName first part name is whole.
     * @param partName  second part name is whole or not.
     * @param users     all users from DB
     * @return found users.
     */
    private static List<User> findUserListByPhrase(String wholeName, String partName, List<User> users) {
        List<User> foundUsers = new ArrayList<>();

        for (User user : users) {
            if (wholeName.equalsIgnoreCase(user.getFirstName()) &&
                    user.getLastName().toLowerCase().contains(partName.toLowerCase())) {
                foundUsers.add(user);
            } else if (wholeName.equalsIgnoreCase(user.getLastName()) &&
                    user.getFirstName().toLowerCase().contains(partName.toLowerCase())) {
                foundUsers.add(user);
            }
        }
        return foundUsers;
    }
}

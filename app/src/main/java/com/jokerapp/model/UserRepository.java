package com.jokerapp.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserRepository {
    private UserDAO userDao;
    //    private DatabaseReference firebaseReference;
    private ExecutorService executorService;

    public UserRepository(Application application) {
//        JokerDB db = JokerDB.getInstance(application);
//        userDao = db.getUserDAO();
//        firebaseReference = FirebaseDatabase.getInstance().getReference("users");
        executorService = Executors.newFixedThreadPool(4);
    }

    public LiveData<User> getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    public LiveData<List<User>> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void insertUser(User user) {
//        executorService.execute(() -> {
//            userDao.insertUser(user);
//            // Optionally sync with Firebase
//            firebaseReference.child(String.valueOf(user.getUserId())).setValue(user);
//        });
    }

//    public void deleteUser(int userId) {
//        executorService.execute(() -> {
//            userDao.deleteUserById(userId);
//            // Optionally remove from Firebase
////            firebaseReference.child(String.valueOf(userId)).removeValue();
//        });
//}


}

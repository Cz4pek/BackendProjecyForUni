package com.lab.project.service;

import com.lab.project.auth.AppUser;
import com.lab.project.model.ChangedUserInfo;
import com.lab.project.model.User;
import com.lab.project.repository.ReservationsRepository;
import com.lab.project.repository.UserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.Optional;

@Service
public class UserPageService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ReservationsRepository reservationsRepository;

    private SessionFactory hibernateFactory;

    @Autowired
    public void setFactory(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.hibernateFactory = factory.unwrap(SessionFactory.class);
    }



    private Optional<User> getLoggedInUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Optional<User> userCheck  = userRepository.findByUsername(
                ((AppUser)auth.getPrincipal())
                        .getUsername());
        userCheck.orElseThrow(() ->new UsernameNotFoundException("Nie ma zalogowanego użytkownika"));
        return userCheck;
    }

    public User getUserPage(){
        Optional<User> userCheck = getLoggedInUser();
        return userCheck.get();
    }

    public void changeUsersInfo(ChangedUserInfo changedUserInfo){

        Optional<User> userCheck = getLoggedInUser();
        User user = userCheck.get();
        String temp = changedUserInfo.getFirstname();
        if(temp != null) user.setFirstname(temp);
        temp = changedUserInfo.getLastname();
        if(temp != null) user.setLastname(temp);
        temp = changedUserInfo.getEmail();
        if(temp != null) user.setEmail(temp);

        userRepository.save(user);
//        Optional<User> userCheck = getLoggedInUser();
//        userCheck.get();
    }

    private void executeQuery(Session session, Query query) {



    }

    public void deleteCurrentlyLoggedInUser() {

        Optional<User> userCheck = getLoggedInUser();
        User user = userCheck.get();

        Session session = hibernateFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "DELETE FROM ReservationData E where E.user_id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", user);


        System.out.println("To jest query string ktory nie dziala, bydle jedno " + hql);

        int count = query.executeUpdate();
        System.out.println(count + " Record(s) Deleted.");


        transaction.commit();
        session.clear();
        session.close();

        userRepository.delete(user);

    }

}

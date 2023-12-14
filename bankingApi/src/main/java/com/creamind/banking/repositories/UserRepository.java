package com.creamind.banking.repositories;

import com.creamind.banking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    // select * from accountuser where firstname = "beni"
    List<User> findAllByFirstname(String firstname);

    // select * from accountuser where firstname like "%Beni%"
    List<User> findAllByFirstnameContaining(String firstname);

    // select * from accountuser where firstname like "%beni%"
    // ne prend pas en compte la casse
    List<User> findAllByFirstnameContainingIgnoreCase(String firstname);

    // select * from accountuser u inner join account a on u.id = a.accountowner_id
    // and a.iban = 'HYU235666BNP'
    List<User> findAllByAccountIban(String iban);


    // select * from accountuser where firstname = 'ben' and email = 'beni@gmail.com'
    User findByFirstnameAndEmail(String firstname, String email);
    User findByFirstnameContainingIgnoreCaseAndEmail(String firstname, String email);


    // JPQL
    /* @Query("from User where firstname = :firstname ")
    List<User> searchByFirstName(String firstname); ou */
    @Query("from User where firstname = :fn ")
    List<User> searchByFirstName(@Param("fn") String firstname);

    @Query("from User where firstname = '%:firstname%' ")
    List<User> searchByFirstNameContaining(String firstname);

    @Query("from User u inner join Account a on u.id = a.accountowner.id where a.iban = :iban")
    List<User> searchByIban(String iban);

    @Query(value = "select * from accountuser accu inner join account a on accu.id = a.accountowner_id where a.iban = :iban"
    , nativeQuery = true)
    List<User> searchByIbanNative(String iban);
}

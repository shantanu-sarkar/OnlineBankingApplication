package com.kpmg.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kpmg.entities.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}

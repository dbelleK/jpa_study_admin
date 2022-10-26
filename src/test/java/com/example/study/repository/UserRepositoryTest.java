package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends StudyApplicationTests {

    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test //Test라는 어노테이션
    public void create(){
        // String sql = insert into user(%s, %s, %d) value (account, email, age);

        //jpa
        User user = new User();
        //user.setId(); //자동(AutoIncrement)
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TesetUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser:" + newUser);

    }

    @Test
    @Transactional
    public void read(){
        //select * from user where id=?
        //Optional<User> user = userRepository.findById(5L); //아이디가 3번인 유저가 있으면
        Optional<User>  user = userRepository.findByAccount("TestUser03");

        user.ifPresent(selectUser ->{

            //user에 있는 orderDetailList가져와서서 list형태이기에 stream으로 가져옴
            selectUser.getOrderDetailList().stream().forEach(detail ->{

                //System.out.println(detail.getItemId());

                Item item = detail.getItem();
                System.out.println(item);
            });
        });

    }

    @Test
    @Transactional
    public void update(){

       Optional<User>  user = userRepository.findById(3L); //아이디가 3번인 유저가 있으면

        user.ifPresent(selectUser ->{
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional //롤백이 되어서 실행은되지만 db에는 데이터 원래 상태
    public void delete(){

        Optional<User>  user = userRepository.findById(1L); //아이디가 3번인 유저가 있으면

        Assertions.assertTrue(user.isPresent()); // true

        user.ifPresent(selectUser ->{

            userRepository.delete(selectUser);
        });


        Optional<User>  deleteUser = userRepository.findById(1L);

        Assertions.assertFalse(deleteUser.isPresent()); //false

/*        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : " + deleteUser.get());
        }else{
            System.out.println("데이터 삭제 데이터 없음");
        }*/
    }


}

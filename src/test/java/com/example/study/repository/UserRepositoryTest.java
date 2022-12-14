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
    public void create() {
/*        // String sql = insert into user(%s, %s, %d) value (account, email, age);

        //jpa
        User user = new User();
        //user.setId(); //자동(AutoIncrement)
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TesetUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser:" + newUser);*/

        String account = "Test03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";


        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
       // user.setCreatedAt(createdAt);
       // user.setCreatedBy(createdBy);

        //@Builder 어노테이션을 이용하여 특정 개수만 넣는 생성자 생성 가능
        User u = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

        User newUser = userRepository.save(user);
        Assertions.assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read() {
/*        //select * from user where id=?
        //Optional<User> user = userRepository.findById(5L); //아이디가 3번인 유저가 있으면
        Optional<User>  user = userRepository.findByAccount("TestUser03");

        user.ifPresent(selectUser ->{

            //user에 있는 orderDetailList가져와서서 list형태이기에 stream으로 가져옴
            selectUser.getOrderDetailList().stream().forEach(detail ->{

                //System.out.println(detail.getItemId());

                Item item = detail.getItem();
                System.out.println(item);
            });
        });*/

        //있는 번호라면 에러없이 통과
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

            //@Accessors(chain = true) 으로 인하여 바꿔줌(update)
             user
                .setEmail("")
                .setPhoneNumber("")
                .setStatus("");

             //@Accessors(chain = true) 으로 인하여 3개 값만 가지는 생성자 만들 수 있음
             User u = new User().setAccount("").setEmail("").setPassword("");

        if (user != null) {
            user.getOrderGroupList().stream().forEach(orderGroup -> {
                System.out.println("===============주문묶음==================");
                System.out.println("수령인 : " + orderGroup.getRevName());
                System.out.println("수령지 : " + orderGroup.getRevAddress());
                System.out.println("총금액 : " + orderGroup.getTotalPrice());
                System.out.println("총수량 : " + orderGroup.getTotalQuantity());

                System.out.println("===============주문상세==================");

                orderGroup.getOrderDetailList().forEach(orderDetail -> {
                    System.out.println("파트너사 이름 : " + orderDetail.getItem().getPartner().getName());
                    System.out.println("파트너사 카테고리 : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                    System.out.println("주문상품 : " + orderDetail.getItem().getName());
                    System.out.println("고객센터 번호 : " + orderDetail.getItem().getPartner().getCallCenter());
                    System.out.println("주문의상태 : " + orderDetail.getStatus());
                    System.out.println("도착예정일자 : " + orderDetail.getArrivalDate());

                });
            });
        }
        Assertions.assertNotNull(user);

    }

/*    @Test
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

*//*        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : " + deleteUser.get());
        }else{
            System.out.println("데이터 삭제 데이터 없음");
        }*//*
    }*/


}

package com.example.study.controller;

import ch.qos.logback.core.CoreConstants;
import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //localhost:8080/api/
public class GetController {

    //localhost:8080/api/getMethod
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest() {
        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {

        String password = "bbb";


        System.out.println("id" + id);
        System.out.println("pwd" + pwd);

        return id + pwd;

    }

    //localhost8080/api/getMultiParameter?accout=abc&email=study@gmail.com&page=10
   @GetMapping("/getMultiParameter")
    public String getMultiParameter(SearchParam searchParam){

        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        return "OK";

    }

    //json 형태 - 객체를 리턴한다는 뜻은 자동적으로 json으로 변환 된
    @GetMapping("/getMultiParameter2")
    public SearchParam getMultiParameter2(SearchParam searchParam){

        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //{"account" : ""}, {"email" : ""}, {"page" : ""}
        return searchParam;

    }

    @GetMapping("/header")
    public Header getHeader(){

        //{"resultCode" : "OK", " description :"OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }

}

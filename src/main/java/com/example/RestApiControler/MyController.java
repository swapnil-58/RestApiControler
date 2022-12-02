package com.example.RestApiControler;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MyController {


    //database ki traha use krne ke liyeh hash map banate hai abhi ke liye
    Map<Integer,User> users = new HashMap<>();

    @GetMapping("/get_user")        //annotation for api calling  yeh apna end point hua jo function acces krke ke liye kaam aeynga
    public List<User> getusers(){                   //get api for read operation

        List<User>listofusers= new ArrayList<>();  //array list bani user ki list retun karne ke liye
        for(User users:users.values())              //
            listofusers.add(users);

        return listofusers;

    }

    @PostMapping("/add_user")
    public void adduser(@RequestParam("id")int id,@RequestParam("name")String name,
                        @RequestParam("country")String country,@RequestParam("age")int age){

        User user=new User(id,name,country,age);
        users.put(id,user);
    }


    @PostMapping("/add_user_body")
    public void adduserbody(@RequestBody(required = true)User user){   // url se input na leke user cosole se inpute ke liye request body use kiya and wo compulsory hai is liyeh true kiya

        users.put(user.getId(),user);
    }

}

package com.game.demo.controllers;

import com.game.demo.models.User;
import com.game.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("api/game")
public class GameController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("multiplication/random")
    @ResponseBody
    public String random()
    {
        Random rand = new Random();
        int int1 = rand.nextInt(100);
        int int2 = rand.nextInt(100);
        return int1 + "*" + int2;
    }

    @PostMapping("multiplication/results")
    @ResponseBody
    public Boolean result(@RequestParam String multiplication,@RequestParam int userAnswer,
                          String user)
    {
        String[] temp = multiplication.split("\\*");
        int multi1 = Integer.parseInt(temp[0]);
        int multi2 = Integer.parseInt(temp[1]);
        int actual = multi1 * multi2;

        Integer attemptId = userRepository.findMaximumAttempId(user);
        if(attemptId == null) attemptId=0;

        User obj = new User();
        obj.attemptNo = attemptId + 1;
        obj.multiplication = multiplication;
        obj.result = (actual==userAnswer);
        obj.userAnswer = userAnswer;
        obj.userId = user;

        userRepository.saveAndFlush(obj);

        System.out.println(user + " "+multiplication + " " + userAnswer);

        return actual == userAnswer;
    }




}

package org.ravig.kafka.controller;

import org.ravig.kafka.model.User;
import org.ravig.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class ProducerResource {
    private final ProducerService producerService;

    @Autowired
    public ProducerResource(ProducerService producerService)
    {
        this.producerService = producerService;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message)
    {
        this.producerService.sendMessage(message);
    }

    @PostMapping(value = "/createUser")
    public void sendMessageToKafkaTopic(
            @RequestParam("userId") long userId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {

        User user = new User();
        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setLastName(lastName);

        this.producerService.saveCreateUserLog(user);
    }
}

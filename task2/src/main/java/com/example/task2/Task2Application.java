package com.example.task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.task2.astronaut.Astronaut;
import com.example.task2.spaceship.Spaceship;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootApplication
public class Task2Application {

	public static void main(String[] args) {
		SpringApplication.run(Task2Application.class, args);
	}

}
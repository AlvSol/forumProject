package com.example.forumproject;

import com.example.forumproject.model.Post;
import com.example.forumproject.model.ThreadForum;
import com.example.forumproject.repository.PostRepository;
import com.example.forumproject.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ForumprojectApplication implements CommandLineRunner {

	@Autowired
	PostRepository postRepository;

	@Autowired
	ThreadRepository threadRepository;

	public static void main(String[] args) {
		SpringApplication.run(ForumprojectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		threadRepository.deleteAll();
		postRepository.deleteAll();

		System.out.println("-------------CREATE POSTS ITEMS-------------------------------\n");
		createPosts();

		System.out.println("-------------CREATE THREADS ITEMS-------------------------------\n");
		createThreads();



	}

	public void createThreads() {
		System.out.println("Thread creation started...");

		threadRepository.save(new ThreadForum("0", "Martial arts"));
		threadRepository.save(new ThreadForum("1", "Cooking issues"));
		threadRepository.save(new ThreadForum("Videogames"));

		System.out.println("Thread creation started...");
	}

	public void createPosts() {
		System.out.println("Post creation started...");

		postRepository.save(new Post("How do you bake an apple cake?", "I would like to bake an apple cake", "1",0));
		postRepository.save(new Post("Techniques for baking an apple cake", "There are many techniques for baking an apple cake such as...", "1",2));
		postRepository.save(new Post("Suggestion: open a youtube channel", "People who know many techiniques should open a youtube channel...", "1",1));

		System.out.println("Post creation ended...");
	}

}

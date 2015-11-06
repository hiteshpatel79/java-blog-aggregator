package cz.jiripinkas.jba.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.Item;
import cz.jiripinkas.jba.entity.User;
import cz.jiripinkas.jba.repository.BlogRepository;
import cz.jiripinkas.jba.repository.ItemRepository;
import cz.jiripinkas.jba.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public Object findOne(int id) {		
		return userRepository.findOne(id);
	}

	@Transactional
	public Object findOneWithBlogs(int id) {
		//First Find User by ID
		User user = userRepository.findOne(id);
		//Second Find blogs by User
		List<Blog> blogs = blogRepository.findByUser(user);
		for (Blog blog : blogs) {
			//List<Item> items = itemRepository.findByBlog(blog, new PageRequest(page, size, direction, properties));
			List<Item> items = itemRepository.findByBlog(blog, new PageRequest(0, 3, Direction.DESC, "publishedDate"));
			blog.setItems(items);			
		}
		user.setBlogs(blogs);		
		return user;
	}

	public void save(User user) {
		userRepository.save(user);		
	}
	
	
}

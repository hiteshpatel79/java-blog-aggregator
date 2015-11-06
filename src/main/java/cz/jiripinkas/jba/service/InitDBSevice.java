package cz.jiripinkas.jba.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import cz.jiripinkas.jba.entity.Blog;
import cz.jiripinkas.jba.entity.Item;
import cz.jiripinkas.jba.entity.Role;
import cz.jiripinkas.jba.entity.User;
import cz.jiripinkas.jba.repository.BlogRepository;
import cz.jiripinkas.jba.repository.ItemRepository;
import cz.jiripinkas.jba.repository.RoleRepository;
import cz.jiripinkas.jba.repository.UserRepository;

@Transactional
@Service
public class InitDBSevice {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();		
		userAdmin.setPassword(encoder.encode("admin"));
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleUser);
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		
		Blog blogJavavids = new Blog();
		blogJavavids.setName("JavaVids");
		blogJavavids.setUrl("view-source:http://feeds.feedburner.com/javavids?format=xml");
		blogJavavids.setUser(userAdmin);
		blogRepository.save(blogJavavids);
		
		Item item1 = new Item();
		item1.setBlog(blogJavavids);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com");
		item1.setpublishedDate(new Date());
		itemRepository.save(item1);
		
		Item item2 = new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com");
		item2.setpublishedDate(new Date());
		itemRepository.save(item2);
		
		Item item3 = new Item();
		item3.setBlog(blogJavavids);
		item3.setTitle("3");
		item3.setLink("http://www.javavids.com");
		item3.setpublishedDate(new Date());
		itemRepository.save(item3);
		
		Item item4 = new Item();
		item4.setBlog(blogJavavids);
		item4.setTitle("4");
		item4.setLink("http://www.javavids.com");
		item4.setpublishedDate(new Date());
		itemRepository.save(item4);
		
		Item item5 = new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("5");
		item2.setLink("http://www.javavids.com");
		item2.setpublishedDate(new Date());
		itemRepository.save(item2);
		
		Item item6 = new Item();
		item6.setBlog(blogJavavids);
		item6.setTitle("6");
		item6.setLink("http://www.javavids.com");
		item6.setpublishedDate(new Date());
		itemRepository.save(item6);
		
		Item item7 = new Item();
		item7.setBlog(blogJavavids);
		item7.setTitle("7");
		item7.setLink("http://www.javavids.com");
		item7.setpublishedDate(new Date());
		itemRepository.save(item7);
		
	}
	
	
	
	
	
	
	

}
package de.heallife.app.data.service;

import de.heallife.app.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

@Service
public class UserService extends CrudService<User, Integer> {

  private UserRepository repository;

  public UserService(@Autowired UserRepository repository) {
    this.repository = repository;
  }

  @Override
  protected UserRepository getRepository() {
    return repository;
  }
}

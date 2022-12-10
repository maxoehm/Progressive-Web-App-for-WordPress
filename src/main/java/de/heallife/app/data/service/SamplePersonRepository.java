package de.heallife.app.data.service;

import de.heallife.app.data.entity.SamplePerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SamplePersonRepository extends JpaRepository<SamplePerson, Integer> {}

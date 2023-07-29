package com.protim.monitor.repository;

import com.protim.monitor.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.math.BigInteger;


/**
 * For more information on Spring Data REST, check this
 * <a href="https://docs.spring.io/spring-data/rest/docs/current/reference/html/#repository-resources">documentation</a>.<br>
 * <br>
 * Spring Data REST supports only below delete methods:
 * <ul>
 *     <li>delete(T)</li>
 *     <li>delete(ID)</li>
 *     <li>delete(Iterable)</li>
 * </ul>
 * Note that deleteAll() is not allowed.
 *
 * @author vishwaprotim
 */
@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository extends JpaRepository<Student, BigInteger> {

    // Disabling delete using entity method
    @Override
    @RestResource(exported = false)
    void delete(Student entity);
}

package com.protim.monitor.repository;

import com.protim.monitor.entity.Student;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

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
@Tag(name = "Student API")
@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "student", path = "student")
public interface StudentRepository extends JpaRepository<Student, BigInteger> {

    // You can disable the delete method by setting exported = false
    @Override
    @RestResource(exported = true)
    void delete(Student entity);
}

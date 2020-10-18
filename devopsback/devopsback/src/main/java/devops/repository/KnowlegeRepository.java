/**
 * 
 */
package devops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import devops.model.DevopsKnowledge;

/**
 * @author PMartinH
 *
 */
@Repository
public interface KnowlegeRepository extends JpaRepository<DevopsKnowledge, Long> {

}

package com.razzies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.razzies.model.Producer;
import com.razzies.projection.ProducerProjection;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
	
	@Query(nativeQuery= true, value=
			  " select "
			+ " 	m.year, "
			+ "		p.name "
			+ "	from movie m " 
			+ "	inner join producer p on m.id = p.movie_id "
			+ "	where "
			+ "		m.winner = true " 
			+ "	order by "
			+ "		p.name, m.year")
	List<ProducerProjection> getProducerWinner();
	
}

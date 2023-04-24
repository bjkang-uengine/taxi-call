package taxicall.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import taxicall.domain.*;

@RepositoryRestResource(collectionResourceRel = "taxis", path = "taxis")
public interface TaxiRepository
    extends PagingAndSortingRepository<Taxi, Long> {}

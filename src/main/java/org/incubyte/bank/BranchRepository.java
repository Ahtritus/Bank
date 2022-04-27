package org.incubyte.bank;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
interface  BranchRepository extends CrudRepository<Branch, Long>{

}

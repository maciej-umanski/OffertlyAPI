package pl.mumanski.offertlyapi.userManagement;

import org.springframework.data.repository.PagingAndSortingRepository;

interface UserRepository extends PagingAndSortingRepository<User, Long> {
}

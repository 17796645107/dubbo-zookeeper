package edu.hhu.mapper;

import org.springframework.stereotype.Repository;

import edu.hhu.domain.User;

@Repository("UsersMapper")
public interface UsersMapper {

	User selectUserByUsername(String username);

}
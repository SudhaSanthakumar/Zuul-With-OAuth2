package com.auth.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.server.model.AppClient;


@Repository
public interface ClientRepository extends JpaRepository<AppClient, String> {

	AppClient findByClientId(String clientId);

}

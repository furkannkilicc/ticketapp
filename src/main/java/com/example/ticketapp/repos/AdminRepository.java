package com.example.ticketapp.repos;

import com.example.ticketapp.entities.Admin;
import com.example.ticketapp.reponses.AdminResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {


    List<Admin> findByAdminId(Long adminId);

    AdminResponse findByRole(String role);
}
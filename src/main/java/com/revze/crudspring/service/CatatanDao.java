/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.revze.crudspring.service;

import com.revze.crudspring.domain.Catatan;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author revze
 */
public interface CatatanDao extends PagingAndSortingRepository<Catatan, String>{
    
}

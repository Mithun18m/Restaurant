package com.mindtree.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.ordermanagement.entity.ItemsDetail;


//Repository
public interface ItemRepository extends JpaRepository<ItemsDetail,Integer>
{

	//@SuppressWarnings Indicates that the named compiler warnings should be suppressed in the annotated element
	@SuppressWarnings("unchecked")
	ItemsDetail save(ItemsDetail item);
	

}

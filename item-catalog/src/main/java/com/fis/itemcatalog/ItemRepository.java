package com.fis.itemcatalog;

import org.springframework.data.jpa.repository.JpaRepository;

interface ItemRepository extends JpaRepository<Item, Long> {}

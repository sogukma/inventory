package rocks.process.integration.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rocks.process.integration.inventory.domain.PickingList;

@Repository
public interface InventoryRepository extends JpaRepository<PickingList, Long> { }
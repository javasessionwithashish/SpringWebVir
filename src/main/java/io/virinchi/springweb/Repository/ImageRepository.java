package io.virinchi.springweb.Repository;


import io.virinchi.springweb.Model.VirImgTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<VirImgTable, Integer> {
}
